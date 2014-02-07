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
// Desc:        Will create a single object of EmployeeManager. Will use this interface by using a menu system. This method will be used to add, remove, sort, etc, all employees and use each of the employees methods to manipulate employee data such as sales. Will also calculate payouts.



public class EmployeeDriver
{

    public static void main (String args[])
    {

        EmployeeManager em = new EmployeeManager();

        int selection = 0;
        
        do
        {

            selection = em.mainMenu();
            
            switch (selection)
            {
                case 1 : 
                    em.empSubmenu1();
                    break;
                case 2 :
                    em.addEmployee();
                    break;
                case 3 :
                    em.removeEmployee();
                    break;
                case 4 :
                    em.sortEmployee();
                    break;
                case 5 :
                    em.calculateWeeklyPayout();
                    break;
                case 6 :
                    em.calculateBonus();
                    break;
                case 7 :
                    em.annualRaises();
                    break;
                case 8 : 
                    em.resetWeek();
                    break;
            
            } // end switch statement

        } while (selection != 9); //end loop
        

    } //end main method

} //end EmployeeDriver class
