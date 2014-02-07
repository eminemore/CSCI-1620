// Name         : Joe Meyer
// Class        : 1620-001 
// Program #    : 5
// Due Date     : 11/17/11
// 
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment. 
// 
// NAME:        Joe Meyer 
// NUID:        46487574 
// EMAIL:       josephmeyer@unomaha.edu 
// 
// Partners:    NONE 
// 
// Desc:        Node of a dynamic Data Structure that can hold any data and is manipulated by LinkedList

public class ListNode<E>
{
    private E data;
    private ListNode<E> nextNode;

    // Method Name      : ListNode
    // Parameters       : d: E
    // Return value(s)  : None
    // Partners         : None
    // Description      : Constructor to set nextNode to null

    public ListNode(E d)
    {
        nextNode = null;
        data = d;
    }

    // Method Name      : ListNode
    // Parameters       : d:E, node:ListNode<E>
    // Return value(s)  : None
    // Partners         : None
    // Description      : Constructor to set nextNode to the passed node

    public ListNode(E d, ListNode<E> node)
    {   
        nextNode = node;
        data = d;
    }

    // Method Name      : setData
    // Parameters       : d:E
    // Return value(s)  : None
    // Partners         : None
    // Description      : Sets the nodes data to d

    public void setData(E d)
    {
        data = d;
    }

    // Method Name      : getData
    // Parameters       : None
    // Return value(s)  : E
    // Partners         : None
    // Description      : Returns the node's data

    public E getData()
    {
        return data;
    }

    // Method Name      : setNext
    // Parameters       : next: ListNode<E>
    // Return value(s)  : None
    // Partners         : None
    // Description      : Sets the next node's data

    public void setNext(ListNode<E> next)
    {
        nextNode = next;
    }

    // Method Name      : getNext
    // Parameters       : None
    // Return value(s)  : ListNode<E>
    // Partners         : None
    // Description      : Returns the next node

    public ListNode<E> getNext()
    {
        return nextNode;
    }

} //end ListNode class
