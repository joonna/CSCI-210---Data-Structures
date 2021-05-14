import java.io.*;
import java.util.Scanner;

/**
 * project title Lab: Infix to Postfix Notation and Evaluation
 * Project Description: Program that reads infix expression from a file, infix.txt, 
 * converts the infix expression to postfix notation, and evaluates the postfix expression.
 * User Instructions: compile code.
 * Driver Class
 * How to start project: Compile and go to Driver
 * @author Jonathan Kohler 
 * palomar ID: 011165333
 * @version 7/5/2019
 * 
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        Scanner fileScan = new Scanner(new File("infix.txt"));
        PrintWriter pw = new PrintWriter (new FileWriter("csis.txt"));
        while (fileScan.hasNext()) {
            String buf = fileScan.nextLine();
            //removes white spaces
            buf = buf.replaceAll("\\s+", "");
            InfixToPostfix infix = new InfixToPostfix(buf);
            String postfix = infix.convertToPostfix(buf);

            System.out.println("\nInfix: " + buf); //prints out the infix expression 
            pw.print("\n\n\rInfix expression: ");
            pw.println(buf);

            System.out.println("Postfix: " + postfix); //prints out the postfix expression 
            pw.print("\n\n\rPostfix expression: ");
            pw.println(postfix);

            EvalPostfix eval = new EvalPostfix(postfix, pw); // prints out the calculations
            eval.calculate();
        }
        fileScan.close();
        pw.close();
    }
}
