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
// Desc:        Creates an instance of MazeSolver and provides the user interface.
//

import java.util.Scanner;
import java.util.InputMismatchException;

public class MazeDriver
{
  
    public static void main (String[] args)
    {
        Scanner in = new Scanner (System.in);
        boolean loop = true;      
        int choice = 0;

        System.out.print("\n\nThis program will ask you to select a maze to solve.\nFollow on screen instructions to select which maze\nyou wish to solve, and the program will output whether\nor not it is solvable.");

        do
        {
            try
            {
            
                System.out.print("\n\nWhich Maze would you like?\n1. Maze 1\n2. Maze 2\n3. Maze 3\n4. Random\nEnter Choice: ");

                choice = in.nextInt();

                if (choice > 4 || choice < 1)
                {
                    System.out.print("\nMaze selection does not exist. Please enter a valid maze selection.");
                }
                else
                {    
                    loop = false;
                } //end validation if

            } //end try

            catch (InputMismatchException ime)
            {
                in.nextLine();
                System.out.print("\nI see you did not follow instructions. Please enter an *integer*.");
            } //end try block

        } while (loop); //end loop for entry

        MazeSolver ms = new MazeSolver(choice);

        ms.solveFirst();

    } //end main method
        

} //end MazeDriver class


