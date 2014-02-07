// Name         : Joe Meyer
// Class        : 1620-001
// Program #    : 2
// Due Date     : October 6th, 2011
//
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment.
//
// NAME:        Joe Meyer
// NUID:        46487574
// EMAIL:       josephmeyer@unomaha.edu
//
// Partners:    NONE
//
// Desc:        Defines what a maze is.

import java.util.Random;

public class Maze
{

char[][] maze;
int start, end;

// Method Name      : Maze (contructor)
// Parameters       : start:int, end:int, temp:char[][]
// Return value(s)  : None
// Partners         : None
// Description      : Copies passed maze to the maze array. Also records start and end point.

    public Maze(int s, int e, char[][] temp)
    {
        maze = new char[temp.length][temp[0].length]; //allocates maze array

        start = s;
        end = e;

        for (int r = 0; r < temp.length; r++)
        {
            for (int c = 0; c < temp[r].length; c++)
            {
                maze[r][c] = temp[r][c];
            }
        } //end copy loop

        outputMaze();

    } //end Maze contructor with parameters


// Method Name      : Maze (contructor)
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Generates a random maze, along with random start and end points.

    public Maze()
    {
        Random gen = new Random();
        int rows, columns;
        int chance = 0;

        rows = gen.nextInt(7) + 6; // 6 - 12
        columns = gen.nextInt(7) + 6; // 6 - 12

        start = gen.nextInt(rows-2) + 1; // 1 - (rows-2) (excludes corners)
        end = gen.nextInt(rows-2) +1; // 1 - (rows - 2) (excludes corners)

        maze = new char[rows][columns];

        System.out.print("\nGenerating a random maze.\n");

        for (int r = 0; r < maze.length; r++)
        {
            for (int c = 0; c < maze[r].length; c++)
            {
                if (r == 0 || c == 0)
                {
                    maze[r][c] = '#';
                }
                else if (r == maze.length-1)
                {
                    maze[r][c] = '#';
                }
                else if (c == maze[r].length-1)
                {
                    maze [r][c] = '#';
                }
                else
                {
                    chance = gen.nextInt(3); // 0 - 2
                    if (chance == 0)
                    {
                        maze[r][c] = '#';
                    }
                    else
                    {
                        maze[r][c] = '.';
                    } //end inner array random generator

                } //end array generator if

            } //end column for
        } // end row for

        maze[start][0] = '.';

        maze[end][maze[0].length-1] = '.';

        outputMaze();

    } //end Maze contructor without parameters


// Method Name      : changeValue
// Parameters       : value:char, row:int, column:int
// Return value(s)  : None
// Partners         : None
// Description      : Changes a particular array element to the value passed.

    public void changeValue(char value, int row, int column)
    {
        maze[row][column] = value;

    } //end changeValue method


// Method Name      : retrieveValue
// Parameters       : row:int, column:int
// Return value(s)  : char
// Partners         : None
// Description      : Returns what character is in the given array element

    public char retrieveValue(int row, int column)
    {
        return maze[row][column];

    } //end retrieveValue method


// Method Name      : retrieveStart
// Parameters       : None
// Return value(s)  : int
// Partners         : None
// Description      : Gives the row that the starting position is located

    public int retrieveStart()
    {
        return start;
    } //end retrieveStart method


// Method Name      : retrieveEnd
// Parameters       : None
// Return value(s)  : int
// Partners         : None
// Description      : Gives the row that the exit is located

    public int retrieveEnd()
    {
        return end;
    } //end retrieveEnd method

// Method Name      : retrieveEndColumn
// Parameters       : None
// Return value(s)  : int
// Partners         : None
// Description      : Gives the column that the exit is located

    public int retrieveEndColumn()
    {
        return maze[0].length-1;

    } //end retrieveEndColumn method

// Method Name      : outputMaze
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Outputs the maze, either solved or unsolved.

    public void outputMaze()
    {

        System.out.print("\nYour Maze:\n\n");

        for (int r = 0; r < maze.length; r++)
        {
            for (int c = 0; c < maze[r].length; c++)
            {
                System.out.print(maze[r][c]);
            }

            System.out.print("\n");

        } //end print loop

    } //end outputMaze method


} //end Maze class
