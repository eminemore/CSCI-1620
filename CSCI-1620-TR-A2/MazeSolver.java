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
// Desc:        Holds a Maze (as well as any other required data members) and the recursive method to solve the maze (as well as any other required methods).

public class MazeSolver
{
    int counter;
    int endR, endC;
    Maze m;

// Method Name      : MazeSolver (constructor)
// Parameters       : choice:int
// Return value(s)  : None
// Partners         : None
// Description      : Accepts the choice for maze and calls upon Maze to create the maze.

    public MazeSolver(int choice)
    {
        int start = 0;
        int end = 0;

        if (choice == 1)
        {    
            char[][] m1 = {{'#','#','#','#','#','#','#','#','#','#','#','#'},
                           {'#','.','.','.','#','.','.','.','.','.','.','#'},
                           {'.','.','#','.','#','.','#','#','#','#','.','#'},
                           {'#','#','#','.','#','.','.','.','.','#','.','#'},
                           {'#','.','.','.','.','#','#','#','.','#','.','.'},
                           {'#','#','#','#','.','#','.','#','.','#','.','#'},
                           {'#','.','.','#','.','#','.','#','.','#','.','#'},
                           {'#','#','.','#','.','#','.','#','.','#','.','#'},
                           {'#','.','.','.','.','.','.','.','.','#','.','#'},
                           {'#','#','#','#','#','#','.','#','#','#','.','#'},
                           {'#','.','.','.','.','.','.','#','.','.','.','#'},
                           {'#','#','#','#','#','#','#','#','#','#','#','#'}};
            start = 2;
            end = 4;
            m = new Maze(start, end, m1);
        }
        else if (choice == 2)
        {
            char[][] m2 = {{'#','#','#','#','#','#','#','#','#','#','#','#'},
                           {'#','.','.','.','#','.','.','.','#','#','.','.'},
                           {'#','.','#','.','.','.','#','.','.','.','.','#'},
                           {'#','.','#','#','#','#','.','#','.','#','.','#'},
                           {'#','.','.','.','#','#','.','.','.','.','.','#'},
                           {'#','#','#','.','#','#','#','#','.','#','.','#'},
                           {'.','.','.','.','.','.','.','.','.','.','#','#'},
                           {'#','#','#','#','#','#','#','#','#','#','#','#'}};
            start = 6;
            end = 1;
            m = new Maze(start, end, m2);
        }
        else if (choice == 3)
        {
            char[][] m3 = {{'#','#','#','#','#','#','#','#','#'},
                           {'#','.','#','.','#','.','.','.','#'},
                           {'#','.','.','.','#','.','#','#','#'},
                           {'#','#','#','.','#','.','#','.','.'},
                           {'.','.','.','.','.','.','#','.','#'},
                           {'#','#','.','#','.','#','#','.','#'},
                           {'#','.','.','#','.','#','.','.','#'},
                           {'#','#','.','#','.','#','.','.','#'},
                           {'#','#','#','#','#','#','#','#','#'}};
            start = 4;
            end = 3;
            m = new Maze(start, end, m3);
        }
        else
        {
            m = new Maze();

        } //end maze creation if

        endR = m.retrieveEnd();
        endC = m.retrieveEndColumn();

    } //end contructor

// Method Name      : Solve
// Parameters       : r:int, c:int
// Return value(s)  : boolean
// Partners         : None
// Description      : Recursive algorithm method. Tests to see the next move

    public boolean Solve(int r, int c)
    {
        boolean check = false;
        counter++;
        m.changeValue('x', r, c);
        
        if (r == endR && c == endC)
        {
            System.out.print("\nSolved!");
            m.outputMaze();
            System.out.print("\nPath took " + counter + " steps.\n\n");
            return true;
        }

        if (m.retrieveValue(r-1,c) == '.')
        {
            check = Solve(r-1, c);
            if (check)
                return true;
        }
        if (!check && m.retrieveValue(r+1,c) == '.')
        {
            check = Solve(r+1, c);
            if (check)
                return true;
        }
        if (!check && m.retrieveValue(r, c-1) == '.')
        {
            check = Solve(r, c-1);
            if (check)
                return true;
        }
        if (!check && m.retrieveValue(r, c+1) == '.')
        {
            check = Solve(r, c+1);
            if (check)
                return true;
        } //end movement if

        counter --;
        m.changeValue('.', r, c);
        return false;
        
    } //end Solve method

// Method Name      : solveFirst
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Movement from the starter square

    public void solveFirst()
    {
        counter++;
        m.changeValue('x', m.retrieveStart(), 0);

        if (m.retrieveValue(m.retrieveStart(), 1) == '.')
        {
            if (!Solve(m.retrieveStart(), 1))
            {
                System.out.print("\nNot Solved\n\n");
                m.changeValue('.', m.retrieveStart(), 0);
            }
        }
        else
        {
            System.out.print("\nNot Solved\n\n");
            m.changeValue('.', m.retrieveStart(), 0);
        } //end if

    } //end solveFirst method

} //end MazeSolver class
