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
// Desc:        Node similar to a ListNode, which will be used in a tree structure, in our case, a BinarySearchTree

public class TreeNode<E extends Comparable>
{
   private E data;
   private TreeNode<E> leftNode;
   private TreeNode<E> rightNode;

// Method Name      : TreeNode
// Parameters       : d: E
// Return value(s)  : None
// Partners         : None
// Description      : Constructor which sets the data of the node

   public TreeNode(E d)
   {
      data = d;
      leftNode = null;
      rightNode = null;
   }

// Method Name      : setData
// Parameters       : d: E
// Return value(s)  : None
// Partners         : None
// Description      : Sets the data of the node

   public void setData(E d)
   {
      data = d;
   }

// Method Name      : getData
// Parameters       : None
// Return value(s)  : E
// Partners         : None
// Description      : returns the data of the node

   public E getData()
   {
      return data;
   }

// Method Name      : setLeftNode
// Parameters       : left: TreeNode<E>
// Return value(s)  : None
// Partners         : None
// Description      : Sets which node the current nodes points to for its left node

   public void setLeftNode(TreeNode<E> left)
   {
      leftNode = left;
   }

// Method Name      : getLeftNode
// Parameters       : None
// Return value(s)  : TreeNode<E>
// Partners         : None
// Description      : Returns the left child node

   public TreeNode<E> getLeftNode()
   {
      return leftNode;
   }

// Method Name      : setRightNode
// Parameters       : right: TreeNode<E>
// Return value(s)  : None
// Partners         : None
// Description      : Sets the passed node to the right child of the current node

   public void setRightNode(TreeNode<E> right)
   {
      rightNode = right;
   }

// Method Name      : getRightNode
// Parameters       : None
// Return value(s)  : TreeNode<E>
// Partners         : None
// Description      : Returns the current nodes right child

   public TreeNode<E> getRightNode()
   {
      return rightNode;
   }

} //end class
