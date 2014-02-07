// Name         : Joe Meyer
// Class        : 1620-001
// Program #    : 0
// Due Date     : September 1st, 2011
//
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment.
//
// NAME:        Joe Meyer
// NUID:        46487574
// EMAIL:       josephmeyer@unomaha.edu
//
// Partners:    NONE
//
// Desc:        This program will make a simple list class that stores user inputed data and get the sum, average, largest value, and smallest value of the values. I will then display the results to the user. A maximum of 10 values will be entered.

import java.util.Scanner;

public class SimpleList
{

    private final int ARRAY_LENGTH = 10;
    private float [] list = new float [ARRAY_LENGTH];
    private int count;
    private float sum, average, large, small;

// Method Name      :SimpleList (constructor)
// Parameters       :None
// Return value(s)  :None
// Partners         :None
// Description      :Initializes variables and gives a welcome message

    public SimpleList ()
    {
        sum = 0;
        for (int x = 0; x < 10; x++)
        {
            list[x] = 0;
        } //end array wipe loop

        System.out.println("\n\nWelcome to the Simple List Class\n\nThis program will take up to 10 float values inputed by you\nthe user and calculate the sum, average, largest value,\nand smallest value of these values.");

    }// end constructor method

// Method Name          :getData
// Parameters           :None
// Return value(s)      :None
// Partners             :None
// Description          :This method retrieves the maximum of 10 values from the user.

    public void getData()
    {
        char choice;
        int confirm = 0;

        Scanner in = new Scanner(System.in);

        do
        {
            System.out.print("\nEnter a floating point value: ");
            list[count] = in.nextFloat();

            count++;

            if (count == 10)
            {
                break;
            } // if for exiting loop after 10th entry. After hours of debugging, I finally found
              // out why it always asked for a Y/N after 10th entry. Did not wish to re-write code
              // as a while instead of do while, so this is my fix.

            do
            {
                System.out.print("\nWould you like to input another value (Y or N)? ");
                choice = in.next().charAt(0);

                switch (choice)
                {
                    case 'y':
                        confirm = 1;
                        break;
                    case 'Y':
                        confirm = 1;
                        break;
                    case 'N':
                        confirm = 1;
                        break;
                    case 'n':
                        confirm = 1;
                        break;
                    default:
                        confirm = 0;
                } //end switch statement for confirming choice. A bit of a hassle, but my old logic was not working.
                    

            }while (confirm == 0); //end Y/N confirmation loop

        }while ((choice == 'Y' || choice == 'y') && count < 10); //end user input loop

    }// end getDate method


// Method Name      :processData
// Parameters       :None
// Return value(s)  :None
// Partners         :None
// Description      :This method will calculate the sum, average, high, and low number of the user inputed values.

    public void processData()
    {
        for (int x = 0; x < count; x++)
        {
            sum += list[x];
        }//end sum loop

        average = (sum/count);

        large = list[0]; //sets first number to largest
        small = list[0]; //sets first number to smallest

        for (int x = 1; x < count; x++)
        {
            if (list[x] > large)
            {
                large = list[x];
            } //set large loop

            if (list[x] < small)
            {
                small = list[x];
            } //set small loop

        } // end set large/small loop

    } //end processData method

// Method Name      :displayResults
// Parameters       :None
// Return Value(s)  :None
// Partners         :None
// Description      :This method will show the user the values he inputed and display the sum, average, largest, and smallest values

    public void displayResults()
    {
        for (int x = 0; x < count; x++)
        {
            System.out.printf("\nValue %d = %.6f", x+1, list[x]);
        } //end print loop

        System.out.printf("\n\nSum of all values = %.6f", sum);
        System.out.printf("\nAverage of all values = %.6f", average);
        System.out.printf("\nLargest value = %.6f", large);
        System.out.printf("\nSmallest value = %.6f\n\n", small);

    } //end displayResults method

}//end class simpleList
