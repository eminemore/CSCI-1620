// Name         : Joe Meyer
// Class        : 1620-001
// Program #    : 7
// Due Date     : December 8th, 2011
//
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment.
//
// NAME:        Joe Meyer
// NUID:        46487574
// EMAIL:       josephmeyer@unomaha.edu
//
// Partners:    NONE
//
// Desc:        The purpose of this program is to manage a file of accounts. A single account is represented by an AccountRecordSerializable object

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AccountManager
{
    private AccountRecordSerializable[] accounts;
    private int numRecords;
    private final int MAX_RECORDS = 100;

// Method Name      : AccountManager
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Initializes the accounts array and sets numRecords to 0

    public AccountManager()
    {
        accounts = new AccountRecordSerializable[MAX_RECORDS];
        numRecords = 0;
    } //end constructor

// Method Name      : readRecords
// Parameters       : file: String
// Return value(s)  : None
// Partners         : None
// Description      : Reads the passed Serialized AccountRecordSerializeable and populates the accounts array

    public void readRecords(String file)
    {
        ObjectInputStream input = null;

        try
        {
            input = new ObjectInputStream(new FileInputStream(file));
        }
        catch(FileNotFoundException FNFE)
        {
            System.err.println("No Existing Records.");
            return;
        }
        catch(IOException IOE)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        } //end open try block

        while(true)
        {
            try
            {
                accounts[numRecords] = (AccountRecordSerializable)input.readObject();
                numRecords++;
            }
            catch(EOFException EOFE)
            {
                break;
            }
            catch(ClassNotFoundException CNFE)
            {
                System.err.println("Unable to create object.");
                break;
            }
            catch(IOException IOE)
            {
                System.err.println("Error during read from file.");
                break;
            } //end read try block

        } //end read loop

        try
        {
            if(input != null)
            {
                input.close();
            }
        }
        catch (IOException IOE)
        {
            System.err.println("Error closing file.");
            System.exit(1);
        }

    } //end readRecords method

// Method Name      : writeRecords
// Parameters       : file: String
// Return value(s)  : None
// Partners         : None
// Description      : Writes all the objects in the accoutns array to the passed .ser file

    public void writeRecords(String file)
    {
        ObjectOutputStream output = null;
        try
        {
            output = new ObjectOutputStream(new FileOutputStream(file));
        }
        catch (IOException IOE)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }

        for(int x = 0; x < numRecords; x++)
        {
            try
            {
                output.writeObject(accounts[x]);
            }
            catch (IOException IOE)
            {
                System.err.println("Error writing to file.");
                return;
            }
        } //end writing loop

        try
        {
            if(output != null)
            {
                output.close();
            }
        }
        catch (IOException IOE)
        {
            System.err.println("Error closing file.");
            System.exit(1);
        }

    } //end writeRecords method

// Method Name      : printRecords
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Prints a formatted header and all of the current records in sorted order

    public void printRecords()
    {
        sortRecords();

        System.out.printf("%-10s%-12s%-12s%10s", "Account", "First Name", "Last Name", "Balance\n");

        for(int x = 0; x < numRecords; x++)
        {
            System.out.print(accounts[x]);

        } //end output loop

    } //end printRecords

// Method Name      : addRecord
// Parameters       : accountNumber: int, balance: double
// Return value(s)  : None
// Partners         : None
// Description      : Creates a new account and adds it to the array, and prints out a message confirming creation

    public void addRecord(int accountNumber, double balance)
    {
        Scanner input = new Scanner(System.in);
        String first, last;
        first = last = "";
        System.out.println("New account number " + accountNumber + " found!");
        System.out.print("Enter First Name: ");
        first = input.next();
        System.out.print("Enter Last Name: ");
        last = input.next();
        
        accounts[numRecords] = new AccountRecordSerializable(accountNumber, first, last, balance);
        System.out.println("New acount added:");
        System.out.println(accounts[numRecords]);
        numRecords++;

    } //end addRecord method

// Method Name      : sortRecords()
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Sorts records by account number

    public void sortRecords()
    {
        AccountRecordSerializable temp;

        for(int x = 0; x < numRecords; x++)
        {
            for(int y = 1; y < numRecords; y++)
            {
                if(accounts[y - 1].getAccount() > accounts[y].getAccount())
                {
                    temp = accounts[y-1];
                    accounts[y-1] = accounts[y];
                    accounts[y] = temp;
                }
            }
        } //end bubble sort loop

    } //end sortRecords method
 
// Method Name      : findRecord
// Parameters       : accountNumber: int
// Return value(s)  : int
// Partners         : None
// Description      : Returns the position of the passed record, or -1 if not found

    public int findRecord(int accountNumber)
    {
        int location = -1;

        for(int x = 0; x < numRecords; x++)
        {
            if(accounts[x].getAccount() == accountNumber)
            {
                location = x;
            }
        } //end find loop

        return location;

    } //end findRecord method

// Method Name      : updateTransactions
// Parameters       : file: String
// Return value(s)  : None
// Partners         : None
// Description      : Data is read from a trnsaction file and accounts are adjusted or added as needed.

    public void updateTransactions(String file)
    {
        int acc = 0;
        double bal = 0.0;

        Scanner input = null;

        try
        {
            input = new Scanner(new File(file));
        }
        catch(FileNotFoundException FNFE)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }

        while(true)
        {   
            try
            {
            acc = input.nextInt();
            bal = input.nextDouble();
            }
            catch(NoSuchElementException NSEE)
            {
                break;
            }
            catch(IllegalStateException ISE)
            {
                System.err.println("Scanner closed error.");
                System.exit(1);
            }
            boolean flag = false;

            for(int x = 0; x < numRecords; x++)
            {
                if(accounts[x].getAccount() == acc)
                {
                    accounts[x].addBalance(bal);
                    flag = true;
                }
            }

            if(!flag)
            {
                addRecord(acc, bal);
            }
        } //end loop

        if(input != null);
        {
            input.close();
        }

    } //end updateTransactions method

} //end class
