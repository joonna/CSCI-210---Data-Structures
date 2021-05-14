import java.io.*;
import java.util.Scanner;

/**
 * Driver Class
 * 
 * Project Title: Payroll Processing lab
 * Project Descritption: Retrieve, update, and manipulate a smallpayroll database(using linear link list)
 * How to start the Project: Go to driver and select void main and click on "ok"
 * @author Jonathan Kohler 
 * Palomar ID: 011165333
 * @version 7/27/2019
 * User Instructions: Compile first and go to Driver
 * 
 */

public class Driver {

    /**
     * Main method
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Scanner inputFile = new Scanner(new File("payfile.txt"));
        Scanner hireFile = new Scanner(new File("hirefile.txt"));
        Scanner fireFile = new Scanner(new File("firefile.txt"));
        Payroll payroll = new Payroll(inputFile, pw, hireFile, fireFile);

        payroll.ReadInputFile();
        payroll.header();
        payroll.printEmployeeData();
        payroll.printWomen();
        payroll.tenure();
        payroll.raise();
        payroll.sortLastName();
        payroll.hire();
        payroll.fire();
        inputFile.close();
        pw.close();
    }
}

