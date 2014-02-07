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
// Desc:        An extension of Employee, this is a specific type of employee payed by wage and hours worked.

import java.util.Scanner;

public class HourlyEmployee extends Employee
{

    double wage, hoursWorked;

// Method Name      : HourlyEmployee (constructor)
// Parameters       : fn:String, ln:String, m:char, g:char, empNum:int, w:double
// Return value(s)  : None
// Partners         : None
// Descrition       : Accepts all that Employee requires as well as a double for wage. Sets hoursWorked to 0.0

    public HourlyEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double w)
    {              
        super(fn, ln, m, g, empNum, ft);
        
        Scanner in = new Scanner (System.in);

        if (w >= 0)
        {
            wage = w;
        }
        else
        {
            do
            {
                System.out.print("\nInvalid wage. Enter another. ");
                w = in.nextDouble();
            }while (w < 0);

            wage = w;
        }

        hoursWorked = 0.0;

    } //end constructor

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : None
// Descrition       : Overrides Employee's toString so it does everything Employee's toString does as well as output wage and hours worked.

    @Override
    public String toString()
    {
        return String.format("\n\n%sWage: %.2f\nHours Worked: %.2f", super.toString(), wage, hoursWorked);

    } //end toString method

// Method Name      : calculateWeeklyPay
// Parameters       : None
// Return value(s)  : Double
// Partners         : None
// Descrition       : Returns amount earned in the week using wage and hoursWorked. Over 40 = double wage.

    @Override
    public double calculateWeeklyPay()
    {
        double pay = 0.0;

        if (hoursWorked <= 40)
        {
            pay = wage * hoursWorked;
        }
        else
        {
            pay = wage * 40;
            hoursWorked -= 40;
            pay += (wage * 2) * hoursWorked;
        }

        return pay;

    } //end calculateWeeklyPay method

// Method Name      : annualRaise
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Increases wage by 5%

    @Override
    public void annualRaise()
    {
        wage += wage * .05;

    } //end annualRaise method

// Method Name      : holidayBonus
// Parameters       : None
// Return value(s)  : Double
// Partners         : None
// Descrition       : Gives a bonus equivilant to 40 hours worked.

    @Override
    public double holidayBonus()
    {
        return wage * 40;

    } //end holidayBonus method

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Resets hours worked to 0.

    @Override
    public void resetWeek()
    {
        hoursWorked = 0.0;

    } //end resetWeek method

// Method Name      : increaseHoursWorked
// Parameters       : inc:double
// Return value(s)  : None
// Partners         : None
// Descrition       : Increased hours worked. If a negative value is recieved, no change is made and an error is reported.

    public void increaseHoursWorked(double inc)
    {
        if (inc >= 0)
        {
            hoursWorked += inc;
        }
        else
        {
            System.out.print("\nNegative increase requested. Request could not be completed.\n");
        }

    } //end increaseHoursWorked method

} //end HourlyEmployee class
