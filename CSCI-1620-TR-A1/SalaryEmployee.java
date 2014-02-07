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
// Desc:        Extension of the Employee class, a salaryEmployee will be payed by their salary divided by 52.

public class SalaryEmployee extends Employee
{

    double salary = 0.0; 

// Method Name      : SalaryEmployee (constructor)
// Parameters       : fn:String, ln:String, m:char, g:char, empNum:int, ft:boolean, s:double
// Return value(s)  : None
// Partners         : None
// Descrition       : Sets the values of the name, gender, employee number, full time status, and salary for the SalaryEmployee

    public SalaryEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double s)
    {
        super(fn, ln, m, g, empNum, ft);
        
        if (salary >= 0)
        { 
            salary = s;
        }

        else
        {
            salary = 0;
        }

    } //end constructor

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : None
// Descrition       : Overrides the toString method to dislay the Employee class's toString as well as output the salary of the employee

    @Override
    public String toString()
    {

        return String.format("\n\n%sSalary: %.2f", super.toString(), salary);

    } //end toString method

// Method Name      : calculateWeeklyPay
// Parameters       : None
// Return value(s)  : Double
// Partners         : None
// Descrition       : Returns amount earned in the week by dividing salary by 52

    @Override
    public double calculateWeeklyPay()
    {

        return salary/52;

    } //end calculateWeeklyPay method

// Method Name      : annualRaise
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Increases salary by %6

    @Override
    public void annualRaise()
    {

        salary += salary*.06;

    } //end annualRaise method

// Method Name      : holidayBonus
// Parameters       : None
// Return value(s)  : Double
// Partners         : None
// Descrition       : Returns 3% of salary as a bonus

    @Override
    public double holidayBonus()
    {

        return salary * .03;

    } //end holidayBonus method

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Null method

    @Override
    public void resetWeek()
    {
    } //end resetWeek method

} //end SalaryEmployee class
