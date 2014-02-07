// Name         :st = Array.newInstance(elementType, origCap); Joe Meyer
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
// Desc:        Implements an ArrayList data structure capable of handling any type of data, as long as it inherits from hasKay.

import java.lang.reflect.Array;

public class ArrayList<E extends hasKey>
{
    private final int DEFCAP = 50;
    private int origCap;
    private int  numElements;
    private E[] list;
    private Class<E> elementType;

// Method Name      : ArrayList
// Parameters       : et: Class<E>
// Return value(s)  : None
// Partners         : None
// Description      : Constructor being passed the type of data being held in the Array List

    public ArrayList(Class<E> et)
    {
        elementType = et;
        origCap = DEFCAP;
        numElements = 0;
        list = (E[]) Array.newInstance(elementType, origCap);
    
    } //end constuctor

// Method Name      : ArrayList
// Parameters       : et: Class<E>, size:int
// Return value(s)  : None
// Partners         : None
// Description      : Constructor being passed the type of data being held in the Array List as well as how long the Array List should be

    public ArrayList(Class<E> et, int size) throws Exception
    {
        elementType = et;
        if(size <= DEFCAP)
        {
            origCap = size;
            list = (E[]) Array.newInstance(elementType, origCap);
            numElements = 0;
        }
        else
            throw new Exception();

    } //end constuctor

// Method Name      : addItem
// Parameters       : item: E
// Return value(s)  : None
// Partners         : None
// Description      : Adds an item to the last unused element of the array

    public void addItem(E item)
    {
        if(list.length == numElements)
        {
            enlarge();
        }
        list[numElements] = item;
        numElements++;

    } //end addItem method

// Method Name      : removeItem
// Parameters       : item: E
// Return value(s)  : Boolean
// Partners         : None
// Description      : Attempts to remove the passed object from the ArrayList

    public <E> boolean removeItem(E item)
    {
        int location;

        location = findItem(item);

        if(location != -1)
        {
            list[location] = list[numElements-1];
            numElements--;
            return true;
        }
        else
            return false;

    } //end removeItem method

// Method Name      : findItem
// Parameters       : item: E
// Return value(s)  : int
// Partners         : None
// Description      : Attempts to locate an item in the array. If it finds it, it returns the location. If not, returns -1

    public <E> int findItem(E item)
    {
        boolean flag = false;
        int location = -1;

        for(int x = 0; x < numElements; x++)
        {
            if(list[x] == item)
            {
                flag = true;
                location = x;
                break;
            }
        }

        if(flag)
            return location;
        else
            return -1;

    } //end findItem method

// Method Name      : findItemByKey
// Parameters       : key: int
// Return value(s)  : int
// Partners         : None
// Description      : Searched through the array by the key and attempts to find the item matching the key. If not found, returns -1

    public int findItemByKey( int key)
    {
        boolean flag = false;
        int location = -1;

        for(int x = 0; x < numElements; x++)
        {
            if(list[x].key == key)
            {
                flag = true;
                location = x;
                break;
            }
        }

        if(flag)
            return location;
        else
            return -1;

    } //end findItemByKey method

// Method Name      : isEmpty
// Parameters       : none
// Return value(s)  : boolean
// Partners         : None
// Description      : returns whether the ArrayList is empty or not

    public boolean isEmpty()
    {
        if(numElements == 0)
            return true;
        else
            return false;
    } //end isEmpty

// Method Name      : lengthIs
// Parameters       : None
// Return value(s)  : int
// Partners         : None
// Description      : returns the length of the ArrayList being used

    public int lengthIs()
    {
        return numElements;
    } //end lengthIs method

// Method Name      : clear
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : clears the arraylist

    public void clear()
    {
        numElements = 0;
        if(list.length > origCap)
        {
             E[] newlist = (E[]) Array.newInstance(elementType, origCap);
             list = newlist;
        }

    } //end clear method

// Method Name      : get
// Parameters       : index: int
// Return value(s)  : None
// Partners         : None
// Description      : gets the item in the list of index "index"

    public E get(int index) throws Exception
    {
        if(index > numElements-1 || index < 0)
            throw new Exception();
        else
            return list[index];
    } //end get method

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : None
// Description      : Returns the contents of the arraylist as strings

    @Override
    public String toString()
    {
        String all = "";

        for(int x = 0; x < numElements; x++)
        {
            all += list[x].toString();
        }

        return all;
    } //end toString method

// Method Name      : enlarge
// Parameters       : none
// Return value(s)  : None
// Partners         : None
// Description      : enlarges the list by origcap

    private void enlarge()
    {
       E[] larger;

       if((list.length + origCap) < DEFCAP)
       {
            larger = (E[]) Array.newInstance(elementType, origCap + list.length);

            for(int x = 0; x < numElements; x++)
            {
                larger[x] = list[x];
            }

            list = larger;
       }

   } //end enlarge method

}//end arraylist class

