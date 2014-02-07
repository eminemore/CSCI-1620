// Name         : Joe Meyer
// Class        : 1620-001
// Program #    : 1
// Due Date     : September 22nd, 2011
//
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment.
//
// NAME:        Joe Meyer
// NUID:        46487574
// EMAIL:       josephmeyer@unomaha.edu
//
// Partners:    NONE
//
// Desc:        An abstract class which the other employee types inherit from.

import java.util.Scanner;

public abstract class Employee
{

    protected String firstName, lastName;
    protected char middleInitial;
    protected boolean fulltime;
    private char gender;
    private int employeeNum;

// Method Name      : Employee (constructor)
// Parameters       : fn : String, ln: String, m : String, g : char, empNum : int, ft : boolean
// Return value(s)  : None
// Partners         : None
// Description      : This sets the passed variables to the field variables.

    public Employee(String fn, String ln, char m, char g, int empNum, boolean ft)
    {
        Scanner in = new Scanner (System.in);

        firstName = fn;
        lastName = ln;
        middleInitial = m;
        fulltime = ft;

        if (g == 'M' || g == 'F')
        {    
            gender = g;
        }
        else if (g == 'm')
        {
            gender = 'M';
        }
        else
        {    
            gender = 'F';
        }

        setEmployeeNumber(empNum);
    } //end constructor

// Method Name      : getEmloyeeNumber
// Parameters       : None
// Return value(s)  : Integer
// Partners         : None
// Description      : Returns the employee number.

    public int getEmployeeNumber()
    {
        return employeeNum;
    } //end getEmployeeNumber method

// Method Name      : Name
// Parameters       : None
// Return value(s)  : String
// Partners         : None
// Description      : Returns last name of employee

    public String Name()
    {
        return lastName;
    } //end Name method

// Method Name      : setEmloyeeNumber
// Parameters       : empNum : int
// Return value(s)  : None
// Partners         : None
// Description      : Sets the employee number to the one passed to the method.

    public void setEmployeeNumber(int empNum)
    {
        Scanner in = new Scanner(System.in);

        if (empNum >= 10000 && empNum <= 99999)
        {
            employeeNum = empNum;
        }
        else
        {
            do
            {
            System.out.print("Invalid employee number. Enter a new one between 10000 and 99999.");
            empNum = in.nextInt();

            }while (empNum < 10000 || empNum > 99999);
            
        employeeNum = empNum;

        }

     } //end setEmployeeNumber method

// Method Name      : equals
// Parameters       : e2 : Employee
// Return value(s)  : Boolean
// Partners         : None
// Description      : Compares two employees to see if they have the same employee number.

    @Override
    public boolean equals(Object e2)
    {
        if (this.employeeNum == ((Employee)e2).employeeNum)
        {
            return true;
        }
        else
        {
            return false;
        }
    } //end equals method

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : None
// Descrition       : Returns a String of the employee number, name, gender, and status.

    @Override
    public String toString()
    {
        String requested = "";
        requested =  employeeNum + "\n" + lastName + ", " + firstName + " " + middleInitial + ".\n" + "Gender: " + gender + "\nStatus: ";

        if (fulltime)
        {
            requested += "Full Time\n";
        }
        else
        {
            requested += "Part Time\n";
        }

        return requested;
    } //end toString method

// Method Name      : calculateWeeklyPay
// Parameters       : None
// Return value(s)  : Double
// Partners         : None
// Descrition       : Abstract method which will later calculate how much to pay employee in a week.

    public abstract double calculateWeeklyPay();

// Method Name      : annualRaise
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Abstract method which will later calculate a raise for the employee.

    public abstract void annualRaise();

// Method Name      : holidayBonus
// Parameters       : None
// Return value(s)  : Double
// Partners         : None
// Descrition       : Abstract method which will later give Employee their holidy bonus payout.

    public abstract double holidayBonus();

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Abstract method which will later reset the weekly values for Employee.

    public abstract void resetWeek();

} //end Employee class
