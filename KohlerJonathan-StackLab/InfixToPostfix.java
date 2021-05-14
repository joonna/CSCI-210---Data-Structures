import java.io.PrintWriter;
import java.util.Stack;

/**
 * InfixToPrefix converts an infix expression to a prefix expression
 * 
 * @author Jonathan Kohler
 * @version 7/3/2019
 */
public class InfixToPostfix {

    private String expression;
    private ObjectStack stack;

    /**
     * Constructor for objects of class InfixToPostfix
     * @param infix is a string read in from scanner
     */
    public InfixToPostfix(String ex) 
    {
        this.expression = ex;
        this.stack = new ObjectStack();
    }

    /**
     * Method that transforms an infix expression to postfix
     * @param expr is the infix expresion
     * 
     * @return postfix.toString() the resulting postfix form
     */
    public String  convertToPostfix(String expr) {

        StringBuilder postfix = new StringBuilder();  
        Stack<Character> stack = new Stack<Character>();  

        for (int i=0; i<expr.length(); ++i) {  // goes through the expresion length 
            char c = expr.charAt(i);  
            if (isDigit(c)) { //if statements used to determine the infix
                postfix.append(c);  
            } else if (isOp(c)) {  
                while (isLeftAssociative(c) && !stack.isEmpty() && priority(stack.peek()) >= priority(c)) {  
                    postfix.append(stack.pop());  
                }  
                stack.push(c);  //push the operator
            } else if (c == '(') {  
                stack.push(c);  //pushes the starting parenthesis
            } else if (c == ')') {  
                while (!stack.isEmpty() && stack.peek() != '(') {  
                    postfix.append(stack.pop());  //closing parenthesis pops in the infix
                }  
                if (stack.isEmpty()) {  
                    throw new IllegalArgumentException("mismatched parentheses...");  // appears if the infix has an illegal parenthesis
                }  
                stack.pop(); // pop '(' without adding to output  
            } else if (c == ' ') {  
                // do nothing  
            } else {  
                throw new IllegalArgumentException("Invalid input.");  
            }  
        }  

        // an empty stack  
        while (!stack.isEmpty()) {  
            char c = stack.pop(); 
            if (c == '(') {  
                throw new IllegalArgumentException("mismatched parentheses.");  
            }  
            postfix.append(c);  
        }  

        return postfix.toString();
    }

    /**
     * this method determines the precedence of the left operator
     * 
     * @param  op these are the operators
     * @return true if left opearator has lower precedence
     * @return false if left opearator does not have lower precedence
     */
    private  boolean isLeftAssociative(char op) {  
        switch (op) {  
            case '+':  
            case '-':  
            case '*':  
            case '/':  
            return true;  
            case '^':  
            return false;  
        }  
        return false; 
    }  

    /**
     * Establishes priority of operators
     * 
     * @param  op is the operator
     * @return 3,2,1,0  priority numbers of the operators
     */
    private int priority(char op) {  
        switch (op) {

            case '^': return 3;
            case '*': 
            case '/': return 2;
            case '+':
            case '-': return 1;
            default : return 0;

        }  

    }  

    /**
     * checks for valid digits 
     * 
     * @param  c is the character in question 
     * @return the number
     */
    private boolean isDigit(char c) {  
        return (c >= '0' && c <= '9');  
    }  

    /**
     * to see if operator exists.
     * 
     * @param   c
     * @return  true if operator exists
     * @return  false if operator doesn't exist
     */   
    private boolean isOp(char c) {  
        switch (c) {  
            case '+':  
            case '-':  
            case '*':  
            case '/':  
            case '^':  
            return true;  
        }  
        return false;  
    }

    /**
     * Method that checks if a string is a numeric character
     * @param str
     * @return true if string is a numeric character
     * @return false if string is not a numeric character
     */
    public boolean isNumeric(String str)  
    {  
        try  
        {  
            int d = Integer.parseInt(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    }

}