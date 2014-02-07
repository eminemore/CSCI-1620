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
// Desc:        This program will be the driver for a program that will make a simple list class that stores user inputed data and get the sum, average, largest value, and smallest value of the values. I will then display the results to the user. A maximum of 10 values will be entered.

public class SimpleListTest
{

    public static void main (String args[])
    {
        SimpleList si = new SimpleList();

        si.getData();
        si.processData();
        si.displayResults();

    }// end main method

} //end SimpleListTest class
