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
// Desc:        Class conatining main method that converts infix to postfix and evaluates postfix.


import java.util.Scanner;

public class Postfix
{

    public static void main (String args[])
    {
        Scanner in = new Scanner(System.in);
        String input;
        StringBuffer infix, postfix;
        boolean keepGoing = true;

        System.out.println();
        do
        {
            System.out.print("Enter infix expression: ");
            input = in.nextLine();
            infix = new StringBuffer(input);
            postfix = new StringBuffer(infix.length());

            try
            {
                postfix = infixToPostfix(infix);
                keepGoing = false;
            }

            catch(InvalidCharacterException iCE)
            {
                System.out.println(iCE);
            } //end try block

        } while(keepGoing); //end input loop

        System.out.println("The postfix expression is: " + postfix);
        System.out.println("The expression evaluates to: " +  evaluatePost(postfix) + "\n");

    } //end main method

    // Method Name      : infixToPostfix
    // Parameters       : infix: StringBuffer
    // Return value(s)  : StringBuffer
    // Partners         : None
    // Description      : Converts a passed infix to a postfix

    public static StringBuffer infixToPostfix(StringBuffer infix) throws InvalidCharacterException
    {
        int index = 0;
        char current = infix.charAt(0);
        StringBuffer post = new StringBuffer(infix.length());
        Stack<Character> stack = new Stack<Character>("Operators");

        stack.push('(');
        infix.append(' ');
        infix.append(')');

        while(!stack.isEmpty())
        {
            current = infix.charAt(index);

            if((current == '1') || (current == '2') || (current == '3') || (current == '4') || (current == '5') || (current == '6') || (current == '7') || (current == '8') || (current == '9') || (current == '0'))
            {
                post.append(current);
                post.append(' ');
            }
            else if(current == '(')
            {
                stack.push(current);
            }
            else if(isOperator(current))
            {
                for(int x = 0; x < 100; x++)
                {
                    try
                    {

                        if(isOperator(stack.peek()))
                        {
                            if(!precedence(current, stack.peek()))
                            {
                                post.append(stack.pop());
                                post.append(' ');
                            }
                        }

                    }

                    catch (EmptyListException ELE)
                    {
                        System.out.println(ELE);
                    } //end try block
                }
                stack.push(current);
            }
            else if(current == ')')
            {
                try
                {

                    while(stack.peek() != '(')
                    {    
                        post.append(stack.pop());
                        post.append(' ');
                    } //end while loop

                    stack.pop();

                }

                catch (EmptyListException ELE)
                {
                    System.out.println(ELE);
                } //end try block
            }
            else
            {
                throw new InvalidCharacterException(current);
            } //end if

            index += 2;
        } //end converter loop

        return post;

    } //end infixtopostfix


  

    // Method Name      : evaluatePost
    // Parameters       : postfix: StringBuffer
    // Return value(s)  : double
    // Partners         : None
    // Description      : Accepts a StringBuffer of a postfix expression, evaluates it, and returns the result as a double

    public static double evaluatePost(StringBuffer postfix)
    {
        char c;
        int index = 0;
        postfix.append(')');
        Stack<Double> stack = new Stack<Double>("Values");
        double x, y;
        x = y = 0.0;
        double z = 0.0;

        while(postfix.charAt(index) != ')')
        {
            c = postfix.charAt(index);
            
            if(isOperator(c))
            {
                try
                {
                    x = stack.pop();
                    y = stack.pop();
                }
                catch (EmptyListException ELE)
                {
                    System.out.println(ELE);
                }
                stack.push(calculate(y, c, x));
            }
            else
            {
                z = Character.getNumericValue(c);
                stack.push(z);
            }

            index += 2;
        }

        return stack.pop();
    } //end evaluatePost

    // Method Name      : isOperator
    // Parameters       : c: char
    // Return value(s)  : boolean
    // Partners         : None
    // Description      : determines if the passed value is an operator

    public static boolean isOperator(char c)
    {
        if(c == '+' || c == '-' || c == '/' || c == '*' || c == '%')
        {
            return true;
        }
        else
        {
            return false;
        }

    } //end isOperator

    // Method Name      : precedence
    // Parameters       : o1: char, o2: char
    // Return value(s)  : boolean
    // Partners         : None
    // Description      : Returns true if o1 has greater precedence than o2, false otherwise

    public static boolean precedence(char o1, char o2)
    {
        if(o1 == '+' || o1 == '-')
        {
            return false;
        }
        else
        {
            if(o2 == '+' || o2 == '-')
            {
                return true;
            }
            else
            {
                return false;
            }
        } //end if

    } //end precedence

    // Method Name      : calculate
    // Parameters       : op1: double, oper: char, op2: double
    // Return value(s)  : double
    // Partners         : None
    // Description      : Evaluates the passed expressions and returns the result

    public static double calculate(double op1, char oper, double op2)
    {
        double result = 0.0;
        switch (oper)
        {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
            case '*':
                result = op1*op2;
                break;
            case '/':
                result = op1/op2;
                break;
            case '%':
                result = op1%op2;
                break;
        } //end switch
        return result;
    } //end calculate
} //end class
