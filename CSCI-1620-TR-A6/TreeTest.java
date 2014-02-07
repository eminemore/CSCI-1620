public class TreeTest
{
   public static void main(String args[])
   {
      Tree<Integer> t = new Tree<Integer>();
      System.out.println("Populating");
      t.insertItem(1);
      t.insertItem(2);
      t.insertItem(3);
      t.insertItem(4);
      t.insertItem(5);
      t.insertItem(6);

      printBreak(t);
      System.out.println("Balancing");
      t.balance();
      printBreak(t);
      System.out.println("Deleting 3");
      t.deleteItem(3);

      printBreak(t);
      System.out.println("Balancing");
      t.balance();
      printBreak(t);
      System.out.println("Populating");
      t.insertItem(12);
      t.insertItem(9);
      t.insertItem(13);
      t.insertItem(10);
      t.insertItem(11);
      t.insertItem(9);

      printBreak(t);
      System.out.println("Balancing");
      t.balance();
      printBreak(t);
      System.out.println("Deleting 11, 2, 10");
      t.deleteItem(11);
      t.deleteItem(2);
      t.deleteItem(10);
      printBreak(t);
      System.out.println("Balancing");
      t.balance();

      printBreak(t);

      System.out.print("Getting 13's node: ");
      TreeNode<Integer> node = t.search(13);
      System.out.println(node.getData());

      System.out.printf("Tree currently has %d nodes\n", t.count());

      System.out.print("Looking for 10: ");
      if(t.findItem(10))
      {
         System.out.println("Found");
      }
      else
      {
         System.out.println("Not Found");
      }

      System.out.print("Looking for 9: ");
      if(t.findItem(9))
      {
         System.out.println("Found");
      }
      else
      {
         System.out.println("Not Found");
      }

      System.out.print("In Order: ");
      t.printInOrder();
      System.out.print("Pre Order: ");
      t.printPreOrder();
      System.out.print("Post Order: ");
      t.printPostOrder();
   }

   public static void printBreak(Tree<Integer> t)
   {
      t.printTree();
      System.out.println("--------------------------------");
   }
}
