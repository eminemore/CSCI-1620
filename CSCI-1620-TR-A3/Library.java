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
// Desc:        Uses ArrayList, is the driver for the program. Will be a menu driven system and will organize the library.

import java.util.Scanner;

public class Library
{

       public static void main(String[] args)
       {
           
               ArrayList<Book> books;
               ArrayList<Book> stock;
               ArrayList<Member> members;
               Book t = new Book();   //Used for retrieving Class type
               Member m = new Member();
               //Declare other variables to be used
               int selection = 0;
               Scanner in = new Scanner(System.in);
               int id, isbn, mp, bp;
               id = isbn = mp = bp = -1;
                
               books = null;
               stock = null;
               members = null; //for initialization - real initialization is in try statement so compiler had issues

               //Create new ArrayLists for books, stock, and members
               try{
               books  = new ArrayList<Book>((Class<Book>)t.getClass(), 5);
               stock = new ArrayList<Book>((Class<Book>)t.getClass(), 5);
               members = new ArrayList<Member>((Class<Member>)m.getClass(), 5);
               }
               catch (Exception e){
                   System.out.println(e);
               }

               //Populate books ArrayList
               books.addItem(new Book("Ender's Game", "Card, Orson Scott", 812550706));
               books.addItem(new Book("Breakfast of Champions", "Vonnegut, Kurt", 385334206));
               books.addItem(new Book("The Alphabet of Manliness", "Maddox", 80652720));
               books.addItem(new Book("A Condeferacy of Dunces", "Toole, John Kennedy", 141182865));
               books.addItem(new Book("Dune", "Herbert, Frank", 441013597));
               books.addItem(new Book("History of Western Philosophy", "Russell, Bertrand", 415325056));
               books.addItem(new Book("Choke", "Palahniuk, Chuck", 307388921));
               books.addItem(new Book("Me Talk Pretty One Day", "Sedaris, David", 316776963));
               books.addItem(new Book("House of Leaves", "Danielewski, Mark", 375703768));
               books.addItem(new Book("Eats, Shoots, & Leaves", "Truss, Lynne", 1592402038));

               //Populate members ArrayList
               members.addItem(new Member("Parker, Peter", 56754));
               members.addItem(new Member("Spector, Marc", 74686));
               members.addItem(new Member("Curry, Arthur", 71245));
               members.addItem(new Member("Stark, Tony", 96785));
               members.addItem(new Member("Queen, Oliver", 45267));

               //Copy books into stock
               for(int x = 0; x < books.lengthIs(); x++)
               {
                       try
                       {
                               stock.addItem(books.get(x));
                       }
                       catch(Exception e)
                       {
                               System.out.println(e);
                       }
               }

               //Implement Library User Menu
               do
               {
                   System.out.print("\nLibrary Manager\n1. Check Out\n2. Return\n3. List Stock\n4. List Checked Out\n5. Exit\nSelection: ");
                   System.out.println();
                   selection = in.nextInt();
                   switch (selection)
                   {
                        case 1:
                            try{

           Scanner i = new Scanner(System.in);
           System.out.print(members);
           do
           {
                System.out.print("\nPlease select a member by ID: ");
                id = i.nextInt();
           } while(members.findItemByKey(id) == -1);

           System.out.print(books);
           do
           {
               System.out.print("\nPlease select a book by ISBN: ");
               isbn = i.nextInt();
           } while(stock.findItemByKey(isbn) == -1);

           for (int x = 0; x < members.lengthIs(); x++)
           {
               if(members.get(x).key == id)
               {
                   mp = x;
                   break;
               }
           }

           for(int x = 0; x < stock.lengthIs(); x++)
           {
               if(stock.get(x).key == isbn)
               {
                   bp = x;
                   break;
               }
           }

           if(!(members.get(mp).checkOut(stock.get(bp))))
           {
               System.out.print("\nToo many books checked out for that member.\n");
           }
           else
           {
               System.out.print(members.get(mp) + "checked out " + stock.get(bp));
           }

         }
         catch (Exception e){
             System.out.println(e);
         }

                            break;
                        case 2:
                         try{

           Scanner i = new Scanner(System.in);
           System.out.print(members);
           do
           {
                System.out.print("\nPlease select a member by ID: ");
                id = i.nextInt();
           } while(members.findItemByKey(id) == -1);

           System.out.print(books);
           do
           {
               System.out.print("\nPlease select a book by ISBN: ");
               isbn = i.nextInt();
           } while(stock.findItemByKey(isbn) == -1);

           for (int x = 0; x < members.lengthIs(); x++)
           {
               if(members.get(x).key == id)
               {
                   mp = x;
                   break;
               }
           }

           for(int x = 0; x < books.lengthIs(); x++)
           {
               if(books.get(x).key == isbn)
               {
                   bp = x;
                   break;
               }
           }

           if(!(members.get(mp).returnBook(books.get(bp))))
           {
               System.out.print("\nThat book is not checked out. Invalid entry.\n");
           }
           else
           {
               System.out.print(members.get(mp) + "returned " + books.get(bp));
           }

        }

       catch (Exception e){
            System.out.println(e);
        }

                            break;
                        case 3:
                            System.out.print(stock);
                            break;
                        case 4:
                            try{

           
            Scanner i = new Scanner(System.in);
            System.out.print(members);
            do
            {
                System.out.print("\nPlease select a member by ID: ");
                id = i.nextInt();
            }while(members.findItemByKey(id) == -1);

            for(int x = 0; x < members.lengthIs(); x++)
            {
                if(members.get(x).key == id)
                {
                    mp = x;
                    break;
                }
            }

            members.get(mp).printCheckedOut();

          }
          catch (Exception e){
              System.out.println(e);
          }
                            break;
                   } //end switch

               } while (selection != 5);    

       }//end main

// Method Name      : checkOut
// Parameters       : Book: books, Book: stock, Member: members
// Return value(s)  : None
// Partners         : None
// Description      : Checks out a book

/*       public void checkOut(Book books, Book stock, Member members)
       {
           int id = 0;
           int isbn = 0;
           int mp, bp;
           mp = bp = -1;

         try{

           Scanner i = new Scanner(System.in);
           System.out.print(members);
           do
           {
                System.out.print("\nPlease select a member by ID");
                id = i.nextInt();
           } while(members.findItemByKey(id) == -1);

           System.out.print(books);
           do
           {
               System.out.print("\nPlease select a book by ISBN");
               isbn = i.nextInt();
           } while(stock.findItemByKey(isbn) == -1);

           for (int x = 0; x < members.lengthIs(); x++)
           {
               if(members.get(x).key == id)
               {
                   mp = x;
                   break;
               }
           }

           for(int x = 0; x < stock.lengthIs(); x++)
           {
               if(stock.get(x).key == isbn)
               {
                   bp = x;
                   break;
               }
           }

           if(!(members.get(mp).checkOut(stock.get(bp))))
           {
               System.out.print("\nToo many books checked out for that member.\n");
           }
           else
           {
               System.out.print(members.get(mp) + " checked out " + stock.get(bp));
           }

         }
         catch (Exception e){
             System.out.println(e);
         }

       } //end checkout method


// Method Name      : returnB
// Parameters       : Book: books, Book: stock, Member: members
// Return value(s)  : None
// Partners         : None
// Description      : Returns a selected book.

       public void returnB(Book books, Book stock, Member members)
       {
           int id = 0;
           int isbn = 0;
           int mp, bp;
           mp = bp = -1;

        try{

           Scanner i = new Scanner(System.in);
           System.out.print(members);
           do
           {
                System.out.print("\nPlease select a member by ID");
                id = i.nextInt();
           } while(members.findItemByKey(id) == -1);

           System.out.print(books);
           do
           {
               System.out.print("\nPlease select a book by ISBN");
               isbn = i.nextInt();
           } while(stock.findItemByKey(isbn) == -1);

           for (int x = 0; x < members.lengthIs(); x++)
           {
               if(members.get(x).key == id)
               {
                   mp = x;
                   break;
               }
           }

           for(int x = 0; x < books.lengthIs(); x++)
           {
               if(books.get(x).key == isbn)
               {
                   bp = x;
                   break;
               }
           }

           if(!(members.get(mp).returnBook(books.get(bp))))
           {
               System.out.print("\nThat book is not checked out. Invalid entry.\n");
           }
           else
           {
               System.out.print(members.get(mp) + " returned " + books.get(bp));
           }

        }

       catch (Exception e){
          System.out.println(e);
       } 

       } //end returnB method

// Method Name      : listCheckedOut
// Parameters       : Book: books, Book: stock, Member: members
// Return value(s)  : None
// Partners         : None
// Description      : Lists all the books checked out by a particular member

       public void listCheckedOut(Book books, Book stock, Member members)
       {
          try{

            int id, mp;
            id = mp = -1;

            Scanner i = new Scanner(System.in);
            System.out.print(members);
            do
            {
                System.out.print("\nPlease select a member by ID");
                id = i.nextInt();
            }while(members.findItemByKey(id) == -1);

            for(int x = 0; x < members.lengthIs(); x++)
            {
                if(members.get(x).key == id)
                {
                    mp = x;
                    break;
                }
            }

            members.get(mp).printCheckedOut();

          }
          catch (Exception e){
              System.out.println(e);
          }

       } //end listCheckedOut method */
}//end class
