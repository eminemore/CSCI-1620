// Name         : Joe Meyer
// Class        : 1620-001 
// Program #    : 5
// Due Date     : 11/17/2011
// 
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment. 
// 
// NAME:        Joe Meyer 
// NUID:        46487574 
// EMAIL:       josephmeyer@unomaha.edu 
// 
// Partners:    NONE 
// 
// Desc:        Composite Implementation of a Stack. Uses a LinkedList.

public class Stack<E>
{
    private LinkedList<E> list;

    // Method Name      : Stack<E>
    // Parameters       : None
    // Return value(s)  : None
    // Partners         : None
    // Description      : Constructor

    public Stack()
    {
        list = new LinkedList<E>();
    } //end constructor

    // Method Name      : Stack<E>
    // Parameters       : name:String
    // Return value(s)  : None
    // Partners         : None
    // Description      : Constructor

    public Stack(String name)
    {
        list = new LinkedList<E>(name);
    } //end constructor

    // Method Name      : push
    // Parameters       : item: E
    // Return value(s)  : None
    // Partners         : None
    // Description      : Pushes the passed value to the top of the stack

    public void push(E item)
    {
        list.insertAtFront(item);
    } //end push

    // Method Name      : pop
    // Parameters       : None
    // Return value(s)  : E
    // Partners         : None
    // Description      : Pops the item at the top of the stack and removes/returns it.

    public E pop() throws EmptyListException
    {
        return list.removeFromFront();
    } //end pop

    // Method Name      : lengthIs()
    // Parameters       : None
    // Return value(s)  : int
    // Partners         : None
    // Description      : Returns the number of elements in the stack

    public int lengthIs()
    {
        return list.lengthIs();
    } //end lengthIs

    // Method Name      : peek
    // Parameters       : None
    // Return value(s)  : E
    // Partners         : None
    // Description      : Tells the user what value is at the top of the stack

    public E peek() throws EmptyListException, IndexOutOfBoundsException
    {
        return list.get(0);
    } //end peek

    // Method Name      : print
    // Parameters       : None
    // Return value(s)  : None
    // Partners         : None
    // Description      : Prints the contents of the stack

    public void print()
    {
        list.print();
    } //end print

    // Method Name      : isEmpty
    // Parameters       : None
    // Return value(s)  : Boolean
    // Partners         : None
    // Description      : Returns true if stack is empty, false if otherwise

    public boolean isEmpty()
    {
        return list.isEmpty();
    } //end isEmpty

} //end class
