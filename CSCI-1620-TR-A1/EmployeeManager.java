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
// Desc:        Is controlled by the EmployeeDriver class. Is used to navigate the menu system and make changes to employees stored in the array.

import java.util.Scanner;

public class EmployeeManager
{

    final int EMPLOYEEMAX = 100;
    Employee[] employees = new Employee[EMPLOYEEMAX];
    int currentEmployees = 0;

// Method Name      : mainMenu
// Parameters       : None
// Return value(s)  : Integer
// Partners         : None
// Descrition       : Returns the choice for which submenu the user wishes to go to.

    public int mainMenu()
    {
        Scanner in = new Scanner (System.in);

        System.out.print("\n\nMain Menu\n");

        listEmployees();

        System.out.print("\n1. Employee Submenu\n2. Add Employee\n3. Remove Employee\n4. Sort Employees\n5. Calculate Weekly Payout\n6. Calculate Bonus\n7. Annual Raises\n8. Reset Week\n9. Quit\n");

        System.out.print("\nEnter Choice: ");
        return in.nextInt();

    } //end mainMenu method

// Method Name      : listEmployees
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Prints out the contents of the Employee array, listing all of the employees currently in the system.

    public void listEmployees()
    {
        if (currentEmployees == 0)
        {
            System.out.print("\nNo Employees.\n");
        }

        else
        {
            for(int e = 0; e < currentEmployees; e++)
            {
                System.out.println(employees[e].toString());
            } //end for loop

        } //end if

    } //end listeEmployees method

// Method Name      : empSubmenu1
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Lists the three types of employees and an option to add hours/sales to them once the user goes to a deeper sub-menu.

    public void empSubmenu1()
    {

        Scanner in = new Scanner (System.in);

        System.out.print("\n1. Hourly Employees\n2. Salary Employees\n3. Commission Employees\n4. Back\n");
        System.out.print("\nEnter Choice : ");
        int choice = in.nextInt();

        if (choice != 4)
        {
            empSubmenu2(choice);
        }

    } //end empSubmenu1 method

// Method Name      : empSubmenu2
// Parameters       : choice:int
// Return value(s)  : None
// Partners         : None
// Descrition       : Lists only employees of a certain type and allows some added functionality depending on which type of employee is being altered.

    public void empSubmenu2(int c)
    {
        Scanner in = new Scanner (System.in);
        int choice = 0; 
        switch (c)
        {
            case 1 :

                for(Employee e: employees)
                {
                    if(e instanceof HourlyEmployee)
                    {
                        e.toString();
                    } //end if

                } //end for loop

                System.out.print("\n\n1. Add Hours\n2. Back\n\n");
                System.out.print("Enter Choice: ");

                choice = in.nextInt();

                if (choice == 1)
                {
                    addHours();
                }
                else
                {
                    empSubmenu1();
                } //end if

                break;
            case 2 :

                for(Employee e: employees)
                {
                    if(e instanceof SalaryEmployee)
                    {
                        e.toString();
                    } //end if
                } //end for loop

                System.out.print("\n\n1. Back\n\n");
                System.out.print("Enter to return to previous menu");

                choice = in.nextInt();

                empSubmenu1();

                break;
            case 3 :

                for(Employee e: employees)
                {
                    if(e instanceof CommissionEmployee)
                    {
                        e.toString();
                    } //end if
                }//end for loop

                System.out.print("\n\n1. Add Sales\n2. Back\n\n");
                System.out.print("Enter Choice: ");

                choice = in.nextInt();

                if (choice == 1)
                {
                    addSales();
                }
                else
                {
                    empSubmenu1();
                } //end if
                
                break;

        } //end switch

    } //end empSubmenu2 method

// Method Name      : addHours
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Adds hours to a selected HourlyEmployee

    public void addHours()
    {
        Scanner in = new Scanner (System.in);

        boolean flag = false;

        System.out.print ("\nEnter employee number: ");
        int empNum = in.nextInt();

        System.out.print("\nHow many hours to be added? ");

        double hours = in.nextDouble();

        for(Employee e: employees)
        {
            if (e instanceof HourlyEmployee)
            {
                if(empNum == ((HourlyEmployee)e).getEmployeeNumber())
                {
                    ((HourlyEmployee)e).increaseHoursWorked(hours);
                    flag = true;
                }
            } //end if structure

        } //end for loop

        if(!flag)
        {
            System.out.print("\nEmployee number did not match an hourly employee");
        } //end if

        empSubmenu1();

    } //end addHours method
                    



// Method Name      : addSales
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Adds sales to a commission employee

    public void addSales()
    {

        Scanner in = new Scanner (System.in);

        boolean flag = false;

        System.out.print ("\nEnter employee number: ");
        int empNum = in.nextInt();

        System.out.print("\nHow many sales to be added? ");

        double sales = in.nextDouble();

        for(Employee e: employees)
        {

            if (e instanceof CommissionEmployee)
            {
 
                if(empNum == ((CommissionEmployee)e).getEmployeeNumber())
                {
                
                    ((CommissionEmployee)e).increaseSales(sales);
                    flag = true;
                }
            } //end if structure
        } //end for loop

        if(!flag)
        {
            System.out.print("\nEmployee number did not match a commission employee");
        } //end if

        empSubmenu1();

    } //end addSales method

// Method Name      : addEmployee
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Adds an employee to the array

    public void addEmployee()
    {
        Scanner in = new Scanner (System.in);
        System.out.print("\n1. Hourly Employees\n2. Salary Employees\n3. Commission Employees\n4. Back\n");

        System.out.print("\nEnter Choice : ");
        int choice = in.nextInt();

        if (choice != 4)
        {
            addEmployeeSubmenu(choice);
        }

    } //end addEmployee method

// Method Name      : addEmployeeSubmenu
// Parameters       : choice:int
// Return value(s)  : None
// Partners         : None
// Description      : Submenu for adding a new employee to the array

    public void addEmployeeSubmenu(int choice)
    {
        Scanner in = new Scanner (System.in);
        String fn, ln = "";
        char mi, g;
        boolean ft = false;
        int empNum = 0;
        double wage, salary, rate = 0.0;
        boolean taken = false;

        System.out.print("\nEnter first name: ");
        fn = in.nextLine();
        System.out.print("Enter last name: ");
        ln = in.nextLine();
        System.out.print("Enter middle Initial: ");
        mi = in.next().charAt(0);
        System.out.print("What gender is this employee? ");
        g = in.next().charAt(0);
        System.out.print("Is this employee full time? y/n : ");

        if(in.next().charAt(0) == 'y')
        {
            ft = true;
        }

        System.out.print("What is the employee's new employee number? ");
        empNum = in.nextInt();

        for (int e = 0; e < currentEmployees; e++)
        {
            if (employees[e].getEmployeeNumber() == empNum)
            {
                taken = true;
            }
        } //end employeenumber varification loop

       if (!taken)
       {
        switch (choice)
        {
            case 1 :
                System.out.print("What will be this employee's wage? ");
                wage = in.nextDouble();
                employees[currentEmployees] = new HourlyEmployee(fn, ln, mi, g, empNum, ft, wage);
                currentEmployees ++;
                break;
            case 2 :
                System.out.print("What will be this employee's salary? ");
                salary = in.nextDouble();
                employees[currentEmployees] = new SalaryEmployee(fn, ln, mi, g, empNum, ft, salary);
                currentEmployees ++;
                break;
            case 3 :
                System.out.print("What will be this employee's commission rate? ");
                rate = in.nextDouble();
                employees[currentEmployees] = new CommissionEmployee(fn, ln, mi, g, empNum, ft, rate);
                currentEmployees ++;
                break;
        } //end switch statement

       } //end if for taken

       else
       {
           System.out.print("\nEmployee number taken. Invalid entry.\n");
       } //end if for taken

    } //end addEmployeeSubmenu method

// Method Name      : removeEmployee
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Removes a selected employee

    public void removeEmployee()
    {
        Scanner in = new Scanner (System.in);
        int empNum = 0;
        System.out.print("\nWhich employee would you like to remove? (Enter employee number) ");
        empNum = in.nextInt();
        boolean found = false;

        for(int e = 0; e < currentEmployees; e++)
        {
            if(empNum == employees[e].getEmployeeNumber())
            {
                for(int f = e; f < currentEmployees; f++)
                {
                    employees[f] = employees[f+1];
                } //end for

                found = true;
                currentEmployees --;
            } //end if
        } //end outer for
        
    } //end removeEmployee method

// Method Name      : sortEmployee
// Parameters       : None 
// Return value(s)  : None
// Partners         : None
// Descrition       : Sorts employees by either employee number or last name

    public void sortEmployee()
    {
        Scanner in = new Scanner (System.in);
        int choice = 0;
        System.out.print("\n\nSort by (1) Employee Number or\n(2) Alphabetical? (Enter 1 or 2)\nSelection: ");
        choice = in.nextInt();

        Employee temp;

        if (choice == 1)
        {
            for (int e = 0; e < currentEmployees; e++)
            {
                for(int i = 0; i < currentEmployees-1; i++)
                {
                    if (employees[i].getEmployeeNumber() > employees[i+1].getEmployeeNumber())
                    {
                        temp = employees[i];
                        employees[i] = employees[i+1];
                        employees[i+1] = temp;
                    } //end if
                } //end loop
            } //end bubble sort
        } //end empnum sort

        else
        {
            for (int e = 0; e < currentEmployees; e++)
            {
                for(int i = 0; i < currentEmployees - 1; i++)
                {
                    if(employees[i].Name().compareTo(employees[i+1].Name()) > 0)
                    {
                        temp = employees[i];
                        employees[i] = employees[i+1];
                        employees[i+1] = temp;
                    } //end if

                } //end inner for
            } //end outer for
        } //end if structure

    } //end sortEmployee method


// Method Name      : calculateWeeklyPayout
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Calculate how much the company owes to all employees for the week

    public void calculateWeeklyPayout()
    {

            double total = 0.0;

            for(int e = 0; e < currentEmployees; e++)
            {
                total += employees[e].calculateWeeklyPay();
            } //end loop

            System.out.printf("\n\nThis week's payout is %.2f", total);


    } //end calculateWeeklyPayout method

// Method Name      : calculateBonus
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Calculate bonus payout and list total payout
    public void calculateBonus()
    {

            double total = 0.0;

            for(int e = 0; e < currentEmployees; e++)
            {
                total += employees[e].holidayBonus();
                System.out.print(employees[e].toString());
                System.out.printf("\nBonus Amount: %.2f", employees[e].holidayBonus());
            } //end loop

            System.out.printf("\n\nTotal holiday bonus payout is %.2f", total);

    } //end calculateBonus method

// Method Name      : annualRaises
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Gives employees their annual raise in pay

    public void annualRaises()
    {
            for(int e = 0; e < currentEmployees; e++)
            {
                employees[e].annualRaise();
                System.out.print("\nRaises Applied\n");
            }
    } //end annualRaises method

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Descrition       : Resets the hours worked/sales

    public void resetWeek()
    {
            for(int e = 0; e < currentEmployees; e++)
            {
                employees[e].resetWeek();
                System.out.print("\nWeek Reset\n");
            }
    } //end resetWeek method

} //end EmployeeManager class
