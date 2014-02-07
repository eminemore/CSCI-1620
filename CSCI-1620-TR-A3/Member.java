// Name         : Joe Meyer
// Class        : 1620-001 
// Program #    : 3
// Due Date     : November 3, 2011
// 
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment. 
// 
// NAME:        Joe Meyer 
// NUID:        46487574 
// EMAIL:       josephmeyer@unomaha.edu 
// 
// Partners:    NONE 
// 
// Desc:        Represents a library member. Will have a string for name and the limiting number of books for the member. Will have an array list for books checked out and will extend hasKey, storing their library number there.

public class Member extends hasKey
{
    private String name;
    private final int MAX_BOOKS = 3;
    private ArrayList<Book> checkedOut;

// Method Name      : Member
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Constructor without parameters

    public Member()
    {
        super(0);
        name = "";

        Book dummy = new Book();
        checkedOut = new ArrayList<Book>((Class<Book>)dummy.getClass());

    } //end constructor

// Method Name      : Member
// Parameters       : n: String, i: int
// Return value(s)  : None
// Partners         : None
// Description      : Constructor with parameters for the name of the member and an int for the ID

    
    public Member( String n, int i)
    { 

        super(i);
        name = n;

        try{

        Book dummy = new Book();
        checkedOut = new ArrayList<Book>((Class<Book>)dummy.getClass(), 3);

        } //end try statement

        catch (Exception E)
        {
            System.out.print("Array size of ArrayList is too large");
        } //end try block

    } //end constructor

    

// Method Name      : checkout
// Parameters       : b: Book
// Return value(s)  : Boolean
// Partners         : None
// Description      : Attempts to check out the passed book.

    public Boolean checkOut(Book b)
    {
        if(checkedOut.lengthIs() != 3)
        {
            checkedOut.addItem(b);
            return true;
        }
        else
            return false;
        
    } //end checkout method

// Method Name      : returnBook
// Parameters       : b: Book
// Return value(s)  : Boolean
// Partners         : None
// Description      : Attempts to return the passed book.

    public Boolean returnBook(Book b)
    {
        return checkedOut.removeItem(b);

    } //end returnBook method

// Method Name      : equals
// Parameters       : m: Member
// Return value(s)  : Boolean
// Partners         : None
// Description      : Sees if the passed member is the same as the calling member

    public Boolean equals(Member m)
    {
        if(this.key == m.key)
            return true;
        else
            return false;

    } //end equals method

// Method Name      : printCheckedOut
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Outputs all of the currently checked out Books

    public void printCheckedOut()
    {
        for(int x = 0; x < checkedOut.lengthIs(); x++)
            System.out.print(checkedOut);
    
    } //end printCheckedOut method

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : None
// Description      : Returns a String of the member name and ID
    
    @Override
    public String toString()
    {
        return String.format("%s\n%d\n", name, key);
    
    } //end toString method

} //end Member class


