// Name         : Joe Meyer
// Class        : 1620-001 
// Program #    : 6
// Due Date     : 11/29/2011
// 
// Honor Pledge : On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment. 
// 
// NAME:        Joe Meyer 
// NUID:        46487574 
// EMAIL:       josephmeyer@unomaha.edu 
// 
// Partners:    NONE 
// 
// Desc:        Implements the Binary Search Tree using a TreeNode and organizes a user submitted set of data with this structure.

public class Tree<E extends Comparable>
{
    private TreeNode<E> root;
    private Object[] values;
    private int index;

// Method Name      : Tree
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Constructor

    public Tree()
    {
        root = null;
    }

// Method Name      : insertItem
// Parameters       : insertValue: E
// Return value(s)  : None
// Partners         : None
// Description      : Calls upons the recursive method to insert the passed item

    public void insertItem(E insertValue)
    {
        if(root == null)
        {
            root = new TreeNode<E>(insertValue);
        }
        else
        {
            insert(root, insertValue);
        } //end if
    }

// Method Name      : insert
// Parameters       : node: TreeNode<E>, insertValue: E
// Return value(s)  : None
// Partners         : None
// Description      : Recursive insert method which traverses the list and finds the corrent insert location for the data and adds a node in that location

    private void insert(TreeNode<E> node, E insertValue)
    {
        if(insertValue.compareTo(node.getData()) < 0)
        {
            if(node.getLeftNode() == null)
            {
                node.setLeftNode(new TreeNode<E>(insertValue));
            }
            else
            {
                insert(node.getLeftNode(), insertValue);
            } //end if
        }

        else if(insertValue.compareTo(node.getData()) > 0)
        {
            if(node.getRightNode() == null)
            {
                node.setRightNode(new TreeNode<E>(insertValue));
            }
            else
            {
                insert(node.getRightNode(), insertValue);
            } //end if
        }

        else
        {
            return;
        } //end insertion if

    } //end insert method

// Method Name      : count
// Parameters       : None
// Return value(s)  : int
// Partners         : None
// Description      : Public call that will call upon the recursive which will navigate the tree and count the nodes

    public int count()
    {
        return countNodes(root);
    }

// Method Name      : countNodes
// Parameters       : tree: TreeNode<E>
// Return value(s)  : int
// Partners         : None
// Description      : Recursive method used for counting the numbre of nodes in the tree

    private int countNodes(TreeNode<E> tree)
    {
        if(tree == null)
        {
            return 0;
        }
        else
        {
            return countNodes(tree.getLeftNode()) + countNodes(tree.getRightNode()) + 1;
        } //end if

    } //end countNodes

// Method Name      : printInOrder
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Public call for the class to print the tree inOrder

    public void printInOrder()
    {
        printInOrderRecursive(root);
        System.out.println();
    }

// Method Name      : printInOrderRecursive
// Parameters       : node: TreeNode<E>
// Return value(s)  : None
// Partners         : None
// Description      : Prints the left node, then current node, then right node (inOder)

    private void printInOrderRecursive(TreeNode<E> node)
    {
        if(node != null)
        {
            printInOrderRecursive(node.getLeftNode());
            System.out.print(node.getData() + " ");
            printInOrderRecursive(node.getRightNode());
        } //end if
    } //end printInOrderRecursive method

// Method Name      : printPreOrder
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Public call to initiate the printing of the tree in preOrder

    public void printPreOrder()
    {
        printPreOrderRecursive(root);
        System.out.println();
    }

// Method Name      : printPreOrderRecursive
// Parameters       : node: TreeNode<E>
// Return value(s)  : None
// Partners         : None
// Description      : Recursively prints the tree in preOrder (current, left, right)

    private void printPreOrderRecursive(TreeNode<E> node)
    {
        if(node != null)
        {
            System.out.print(node.getData() + " ");
            printPreOrderRecursive(node.getLeftNode());
            printPreOrderRecursive(node.getRightNode());
        } //end if
    } //end printPreOrderRecursive

// Method Name      : printPostOrder
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Initiates the printing of the tree in postOrder

    public void printPostOrder()
    {
        printPostOrderRecursive(root);
        System.out.println();
    }

// Method Name      : printPostOrderRecursive
// Parameters       : node: TreeNode<E>
// Return value(s)  : None
// Partners         : None
// Description      : Prints the tree in postOrder (left, right, current)

    private void printPostOrderRecursive(TreeNode<E> node)
    {
        if(node != null)
        {
            printPostOrderRecursive(node.getLeftNode());
            printPostOrderRecursive(node.getRightNode());
            System.out.print(node.getData() + " ");
        } //end if
    } //end printPostOrderRecursive

// Method Name      : isEmpty
// Parameters       : None
// Return value(s)  : Boolean
// Partners         : None
// Description      : Returns true if the tree is empty, false if otherwise

    public boolean isEmpty()
    {
        if(root == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    } //end isEmpty method

// Method Name      : clear
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Clears the tree

    public void clear()
    {
        root = null;
    }

// Method Name      : findItem
// Parameters       : item: E
// Return value(s)  : boolean
// Partners         : None
// Description      : Public call to find the selected item

    public boolean findItem(E item)
    {
        return findItemRecursive(root, item);
    }

// Method Name      : findItemRecursive
// Parameters       : node: TreeNode<E>, item: E
// Return value(s)  : Boolean
// Partners         : None
// Description      : Searches for the passed item throughout the tree

    private boolean findItemRecursive(TreeNode<E> node, E item)
    {
        if(node == null)
        {
            return false;
        }
        else if(item == node.getData())
        {
            return true;
        }
        else if(item.compareTo(node.getData()) < 0)
        {
            return findItemRecursive(node.getLeftNode(), item);
        }
        else
        {
            return findItemRecursive(node.getRightNode(), item);
        }
    } //end findItemRecursive method

// Method Name      : deleteItem
// Parameters       : item: E
// Return value(s)  : None
// Partners         : None
// Description      : Calls upon deleteRecursive to remove the node

    public void deleteItem(E item)
    {
        root = deleteRecursive(root, item);
    }

// Method Name      : deleteRecursive
// Parameters       : node: TreeNode<E>, item: E
// Return value(s)  : TreeNode<E>
// Partners         : None
// Description      : Deletes the node passed

    private TreeNode<E> deleteRecursive(TreeNode<E> node, E item)
    {
        TreeNode<E> temp = node;

        if(node == null)
        {
            return null;
        }
        else if(item == node.getData())
        {
            if(node.getLeftNode() == null && node.getRightNode() == null)
            {
                return null;
            }
            else if(node.getLeftNode() == null)
            {
                return node.getRightNode();
            }
            else if(node.getRightNode() == null)
            {
                return node.getLeftNode();
            }
            else
            {
                temp = node.getLeftNode();
                while(temp.getRightNode() != null)
                {
                    temp = temp.getRightNode();
                }
                node.setData(temp.getData());
                node.setLeftNode(deleteRecursive(node.getLeftNode(), temp.getData()));
                return node;
            }
        }
        else if(item.compareTo(node.getData()) < 0)
        {
            node.setLeftNode(deleteRecursive(node.getLeftNode(), item));
            return node;
        }
        else
        {
            node.setRightNode(deleteRecursive(node.getRightNode(), item));
            return node;
        } //end if
            
    } //end deleteRecursive method

// Method Name      : search
// Parameters       : item: E
// Return value(s)  : TreeNode<E>
// Partners         : None
// Description      : Calls upon the recursive method to look for a particular piece of data

    public TreeNode<E> search(E item)
    {
        return searchRecursive(root, item);
    }

// Method Name      : searchRecursive
// Parameters       : node: TreeNode<E>, item: E
// Return value(s)  : TreeNode<E>
// Partners         : None
// Description      : Searches for a value and returns reference to the node with the data

    private TreeNode<E> searchRecursive(TreeNode<E> node, E item)
    {
        if(node == null)
        {
            return null;
        }
        else if(item == node.getData())
        {
            return node;
        }
        else if(item.compareTo(node.getData()) < 0)
        {
            return searchRecursive(node.getLeftNode(), item);
        }
        else
        {
            return searchRecursive(node.getRightNode(), item);
        }
    } //end searchRecursive

// Method Name      : balance
// Parameters       : none
// Return value(s)  : none
// Partners         : none
// Description      : Initiates the balancing of the tree

    public void balance()
    {
        if(isEmpty())
        {
            System.out.println("Empty Tree");
            return;
        }
        else
        {
            values = new Object[count()];
            index = 0;
            createAscendingArray(root);
            clear();
            balanceRecursive(0, values.length - 1);
        } //end if
    } //end balance method

// Method Name      : createAscendingArray
// Parameters       : current: TreeNode<E>
// Return value(s)  : None
// Partners         : None
// Description      : Transfers the tree to an array

    private void createAscendingArray(TreeNode<E> current)
    {
        if(current != null)
        {
            createAscendingArray(current.getLeftNode());
            values[index] = current.getData();
            index++;
            createAscendingArray(current.getRightNode());
        }
    } //end if

// Method Name      : balanceRecursive
// Parameters       : low: int, high: int
// Return value(s)  : None
// Partners         : None
// Description      : Recreates the tree from the values array, balancing it

    private void balanceRecursive(int low, int high)
    {
        int middle = ((low + high) / 2);

        if(low > high)
        {
            return;
        }
        else
        {
            insertItem((E)values[middle]);
            balanceRecursive(low, middle-1);
            balanceRecursive(middle + 1, high);
        }
    } //end balanceRecursive method

// Method Name      : printTree
// Parameters       : None
// Return value(s)  : None
// Partners         : None
// Description      : Initiates the printing of the tree

    public void printTree()
    {
        printTreeRecursive(root, 0);
    }
 
// Method Name      : printTreeRecursive
// Parameters       : node: TreeNode<E>, spaces: int
// Return value(s)  : None
// Partners         : None
// Description      : Prints the tree recursively

    private void printTreeRecursive(TreeNode<E> node, int spaces)
    {
        if(node != null)
        {
            printTreeRecursive(node.getRightNode(), spaces + 5);
            for(int x = 0; x < spaces; x++)
            {
                System.out.print(" ");
            } //end space loop
            System.out.print(node.getData());
            System.out.println();
            printTreeRecursive(node.getLeftNode(), spaces + 5);
        }
    } //end printTreeRecursive method

} //end class!
