import java.io.PrintWriter;
/**
 * Class evaluates a postfix expresion
 * 
 * @author Jonathan Kohler
 * @version 7/3/2019
 */
public class EvalPostfix {

    private String expression;
    private ObjectStack stack;
    private PrintWriter pw;

    /**
     * Class constructor
     * @param ex the expresion to be evaluated
     * @param pw this is to print into the csis.txt
     */
    public EvalPostfix(String ex,PrintWriter pw) {
        this.expression = ex;
        this.pw = pw;
        this.stack = new ObjectStack();
    }

    /**
     * method to evaluate a postfix expression
     */
    public void calculate() {
        int num3 = 0;       
        //goes through each character of the input expresion
        for (int i =0; i < expression.length(); i++ ) {
            String temp = expression.substring(i, i+ 1);
            if (isNumeric(temp)){
                stack.push(temp); //pushes temp onto stack if its numeric
            } else { // pops numbers and calculates them, then pushes the result
                int num2 = Integer.parseInt((String) stack.pop());  
                int num1 = Integer.parseInt((String) stack.pop()); 
                int result = calculateOperation(num1, num2, temp); 
                stack.push(String.valueOf(result)); 
            }
        }

        System.out.println("Evaluated postfix =  " + stack.top()+ "\n");
        pw.write("\n\n\rEvaluated postfix =  " + stack.pop() + "\n");
        pw.println();//I added these two extra lines to make the csis document look cleaner.
        pw.println();
    }

    /**
     * Evaluates an operation given 2 integers and a string operator
     * @param num1 first number to be involved in operation
     * @param num2 second number to be involved in the operation
     * @param operator the operator that is going to be used
     * @return result the result of the operation
     */
    private int calculateOperation (int num1, int num2, String operator) {
        int result = 0;
        if (operator.equals("+")) {
            result = num1 +num2;
        }else if (operator.equals("-")) {
            result = num1 -num2;
        }else if (operator.equals("*")) {
            result = num1 * num2;
        }else if (operator.equals("/")) {
            result = num1/num2;
        }else if (operator.equals("^")) {
            result = exponential(num1, num2);
        }
        return result;

    }

    /**
     * Recursive method that calculates the exponential of a number
     * 
     * @param num1 the first number which is multiplied
     * @param num2 the second number to be used as the exponent
     * @return exponential the result of the exponent
     */
    private int exponential(int num1, int num2) {

        if (num2 == 0) {
            return 1;
        } else if (num2 == 1) {
            return num1;
        } else {
            return num1* exponential(num1, num2-1);
        }
    }

    /**
     * Method that verifies if String is numeric
     * 
     * @param str the string in question 
     * @return false if not numeric
     * @return true if it is numeric
     */
    private boolean isNumeric(String str)  
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