import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
/**
 * Displays menu selection prompt for user
 * 
 * @author Jonathan Kohler Palomar ID: 011165333
 * @version 6/28/2019
 */
public class Menu 
{
    // instance variables 
    private PrintWriter pw;
    int choice;
    // reads user input
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for objects of class Menu
     */
    public Menu(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     * Displays a menu for the user
     * 
     * @param  None
     * @return None 
     */
    public void display() 
    {
        System.out.println("\nEnter choices 1-7");
        System.out.println("1: Decimal to Binary");
        System.out.println("2: Decimal to Hex");
        System.out.println("3: Binary to Decimal");
        System.out.println("4: Binary to Hex");
        System.out.println("5: Hex to Decimal");
        System.out.println("6: Hex to Binary");
        System.out.println("7: Exit Menu\n");

        pw.println("\nEnter choices 1-7");
        pw.println("1: Decimal to Binary");
        pw.println("2: Decimal to Hex");
        pw.println("3: Binary to Decimal");
        pw.println("4: Binary to Hex");
        pw.println("5: Hex to Decimal");
        pw.println("6: Hex to Binary");
        pw.println("7: Exit Menu\n");
    }

       
    /**
     * Allows user to input a choice from the menu
     * 
     * @param  None
     * @return user's choice
     */
    public int getSelection()
    {

        choice = scanner.nextInt();
        pw.println(choice);

        return choice;
    }

}