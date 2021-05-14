import java.util.*;
import java.io.*;
/**
 * Driver class
 * 
 * Project Title: Factorials Lab
 * Project Description: This program allows the user to input an integer value whose factorial will be produced by implementing
 * double linked lists. The program will output the number, the amount of microseconds it took to calculate
 * the factorial, the number of digits in the factorial, and the factorial solution. 
 * How to Start the Project: Go to driver and select void main and click on "ok"
 * @author Jonathan Kohler
 * Palomar ID: 011165333
 * @version 8/2/2019.
 * User Instructions: Compile first and go to Driver
 */
public class Driver 
{
    /**
     *  main method
     * @param args
     * @throws IOException 
     */

    public static void main(String[] args) throws IOException
    {        File file = new File("csis.txt"); ///
        Scanner s = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(file);
        Factorials factorial = new Factorials(pw);
        int choice;
        do {
            System.out.println("Enter the value of the factorial: ");
            pw.println("Enter the value of the factorial: ");
            choice = s.nextInt();
            System.out.print(choice + "! ");
            pw.print(choice + "! ");
            ObjectList factList = factorial.getList(choice);
            factorial.printDigits(factList);
            factorial.printFactorial(factList);
            System.out.println("Enter another value? No: input 0, Yes: input any number other than 0");
            pw.println("Enter another value? No: input 0, Yes: input any number other than 0");
            choice = s.nextInt();
        } while(choice != 0);
        System.out.println("Goodbye.");
        pw.println("Goodbye");
        pw.close();
    }
}
