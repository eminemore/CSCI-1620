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
// Desc:        Inherits Employee class and creats an employee of type commission which is paid by how many sales are made

public class CommissionEmployee extends Employee
{

    double sales, rate;

// Method Name      : CommissonEmployee (constructor)
// Parameters       : fn:String, ln:String, m:char, g:char, empNum:int, ft:boolean, r:double
// Return value(s)  : None
// Partners         : None
// Descrition       : Accepts all that Employee requires and sets the rate to the defined value as well as sets sales to 0.0

    public CommissionEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double r)
    {
        super(fn, ln, m, g, empNum, ft);

        sales = 0.0;

        if (r >= 0)
        {
            rate = r;
        }

        else
        {
            rate = 0.0;
        }

    } //end constructor

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : None
// Descrition       : Returns a String identical to Employee's toString as well as outputting the rate and sales of the employee

    @Override
    public String toString()
    {

        return String.format("\n\n%sRate: %.2f\nSales: %.2f", super.toString(), rate, sales);

    } //end toString method

// Method Name      : calculateWeeklyPay
// Parameters       : None
// Return value(s)  : Double
// Partners         : None
// Descrition       : Returns the rate percentage of sales

    @Override
    public double calculateWeeklyPay()
    {
        double tempRate = 0.0;

        tempRate = rate * .01;

        return sales * tempRate;

    } //end calculateWeeklyPay method

// Method Name      : annualRaise
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Increases rate by .2%

    @Override
    public void annualRaise()
    {

        rate += rate*.02;

    } //end annualRaise method

// Method Name      : holidayBonus
// Parameters       : None
// Return value(s)  : Double
// Partners         : None
// Descrition       : Null method

    @Override
    public double holidayBonus()
    {
        return 0.0;
    } //end holidayBonus method

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Resets sales to 0.0

    @Override
    public void resetWeek()
    {
        sales = 0.0;
    } //end resetWeek method

// Method Name      : increaseSales
// Parameters       : amount:double
// Return value(s)  : None
// Partners         : None
// Descrition       : Increases sales by a secified amount

    public void increaseSales(double amount)
    {

        if (amount >= 0)
        {
            sales += amount;
        }

        else
        {
            System.out.print("\n You attempted to increase sales by a negative value. No change has occured.");
        }

    } //end increaseSales method

} //end CommissionEmployee class
