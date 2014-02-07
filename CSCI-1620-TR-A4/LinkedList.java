// Name         : Joe Meyer
// Class        : 1620-001 
// Program #    : 4
// Due Date     : 11/10/11
// 
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment. 
// 
// NAME:        Joe Meyer 
// NUID:        46487574 
// EMAIL:       josephmeyer@unomaha.edu 
// 
// Partners:    NONE 
// 
// Desc:        Class that implements the LinkedList Dynamic Data Structure and is driven by LinkedListTest

public class LinkedList<E>
{
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private int numElements;
    private String name;

    // Method Name      : LinkedList
    // Parameters       : None
    // Return value(s)  : None
    // Partners         : None
    // Description      : Constructor to set name to "list" and first/last to null and numElements to 0

    public LinkedList()
    {
        firstNode = lastNode = null;
        numElements = 0;
        name = "list";
    } //end constructor

    // Method Name      : LinkedList
    // Parameters       : listName:String
    // Return value(s)  : None
    // Partners         : None
    // Description      : Constructor to set name to listName, first/last to nulll, and numElements to 0

    public LinkedList(String listName)
    {
        firstNode = lastNode = null;
        numElements = 0;
        name = listName;
    }

    // Method Name      : insertAtFront
    // Parameters       : item:E
    // Return value(s)  : None
    // Partners         : None
    // Description      : Inserts passed data to the front of the list

    public void insertAtFront(E item)
    {
        if(isEmpty())
        {
            firstNode = lastNode = new ListNode<E>(item);
        }
        else
        {
            ListNode<E> node = new ListNode<E>(item, firstNode);
            firstNode = node;
        } //end if

        numElements++;

    } //end insertAtFront method

    // Method Name      : insertAtBack
    // Parameters       : item:E
    // Return value(s)  : None
    // Partners         : None
    // Description      : Inserts passed data to the back of the list

    public void insertAtBack(E item)
    {
        if(isEmpty())
        {
            firstNode = lastNode =new ListNode(item);
        }
        else
        {
            ListNode<E> node = new ListNode<E>(item);
            lastNode.setNext(node);
            lastNode = node;
        } //end if

        numElements++;
    } //end insertAtBack

    // Method Name      : removeFromFront
    // Parameters       : None
    // Return value(s)  : E
    // Partners         : None
    // Description      : Removes the first item and returns it

    public E removeFromFront() throws EmptyListException
    {

        E item = null;

        if(isEmpty())
        {
            throw new EmptyListException(name);
        }
        else if(firstNode == lastNode)
        {
            item = firstNode.getData();
            firstNode = lastNode = null;
            numElements--;
            return item;
        }
        else
        {
            item = firstNode.getData();
            firstNode = firstNode.getNext();
            numElements--;
            return item;
        }

    } //end removeFromFront method

    // Method Name      : removeFromBack
    // Parameters       : None
    // Return value(s)  : E
    // Partners         : None
    // Description      : Removes and returns the last item

    public E removeFromBack() throws EmptyListException
    {
        E item = null;
        int counter = 0;

        if(isEmpty())
        {
            throw new EmptyListException(name);
        }
        else if(firstNode == lastNode)
        {
            item = lastNode.getData();
            firstNode = lastNode = null;
            numElements--;
            return item;
        }
        else
        {
            item = lastNode.getData();
            ListNode<E> current = firstNode;
            for(int x = 0; x < lengthIs(); x++)
            {
                if(x == (lengthIs()-2))
                {
                    item = current.getData();
                    lastNode = current;
                    current.setNext(null);
                }
                else
                {
                    current = current.getNext();
                }
            } //end for
            numElements--;
            return item;

        } //end if

    } //end removeFromBack method

    // Method Name      : remove
    // Parameters       : index:int
    // Return value(s)  : None
    // Partners         : None
    // Description      : removes the element from the list at the given index

    public void remove(int index) throws EmptyListException, IndexOutOfBoundsException
    {

        if(isEmpty())
        {
            throw new EmptyListException(name);
        }
        else
        {    
            ListNode<E> current = firstNode;

            if((index > (lengthIs() - 1)) || (index < 0))
            {
                throw new IndexOutOfBoundsException();
            }
            else if(index == 0)
            {
                removeFromFront();
            }
            else if(index == lengthIs()-1)
            {
                removeFromBack();
            }
            else
            {
                for(int x = 0; x <= index; x++)
                {
                    if(x == index-1)
                    {
                        current.setNext(current.getNext().getNext());
                        break;
                    }
                    else
                    {
                        current = current.getNext();
                    }//end if
                    
                } //end for
                numElements--;
            } //end if
        } //end if
    } //end remove

    // Method Name      : get
    // Parameters       : index:int
    // Return value(s)  : E
    // Partners         : None
    // Description      : returns the element at the given position

    public E get(int index) throws EmptyListException, IndexOutOfBoundsException
    {
        E data = null;

        ListNode<E> current = firstNode;
        if(isEmpty())
        {
            throw new EmptyListException(name);
        }
        else
        {
           
            if((index > (lengthIs() - 1)) || (index < 0))
            {
                throw new IndexOutOfBoundsException();
            }
            else if(index == 0)
            {
                data =  firstNode.getData();
            }
            else if(index == lengthIs()-1)
            {
                data =  lastNode.getData();
            }
            else
            {
                for(int x = 0; x <= index; x++)
                {
                    if(x == index)
                    {
                        data = current.getData();
                        break;
                    }
                    else
                    {
                        current = current.getNext();
                    }//end if
                } //end for
            } //end if
        } //end if

        return data;
    } //end get method

    // Method Name      : findAndRemove
    // Parameters       : item:E
    // Return value(s)  : Boolean
    // Partners         : None
    // Description      : Attempts to find the passed item. if found, removes it and returns true, if not, returns false

    public boolean findAndRemove(E item) throws EmptyListException
    {
        
        if(isEmpty())
        {
            throw new EmptyListException(name);
        }
        else
        {
            if(findItem(item) == -1)
            {
                return false;
            }
            else
            {
                remove(findItem(item));
                return true;
            }
        } //end if

    } //end findAndRemove method

    // Method Name      : findItem
    // Parameters       : item: E
    // Return value(s)  : int
    // Partners         : None
    // Description      : Attempts to find the passed item. Returns location if found, -1 if not found

    public int findItem(E item)
    {
        int location = -1;
        ListNode<E> current = firstNode;

        for(int x = 0; x < lengthIs(); x++)
        {
            if(current.getData() == item)
            {
                location = x;
                break;
            }
            else
            {
                current = current.getNext();
            }
        } //end for

        return location;
    } //end findItem

    // Method Name      : lengthIs
    // Parameters       : None
    // Return value(s)  : int
    // Partners         : None
    // Description      : returns the number of elements

    public int lengthIs()
    {
        return numElements;
    } //end lengthIs method

    // Method Name      : clear
    // Parameters       : None
    // Return value(s)  : None
    // Partners         : None
    // Description      : removes all elements from the list

    public void clear()
    {
        numElements = 0;
        firstNode = lastNode = null;
    } //end clear method

    // Method Name      : print
    // Parameters       : None
    // Return value(s)  : None
    // Partners         : None
    // Description      : prints out the contents of the list

    public void print()
    {
        if(isEmpty())
        {
            System.out.println("Empty " + name);
        }
        else
        {
            ListNode<E> current = firstNode;
            System.out.println("The list " + name + " is:");
            for(int x = 0; x < lengthIs(); x++)
            {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } //end print loop

            System.out.println();
        } //end if

    } //end print method

    // Method Name      : isEmpty
    // Parameters       : None
    // Return value(s)  : Boolean
    // Partners         : None
    // Description      : returns true if the list is empty, false if otherwise

    public boolean isEmpty()
    {
        if(numElements == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    } //end isEmpty method
} //end class
