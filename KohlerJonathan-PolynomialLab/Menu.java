import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is an implementation of a Menu class which is used to display the conversion menu to user.
 * @author Jonathan Kohler
 * @version 8/2/2019
 */
public class Menu {
    public SuperOut so;
    public PrintWriter pw;
    public int selection;

    /**
     * This is the default constructor for Menu.
     * PrintWriter object is passed through this method for file writing in Menu Class.
     * @param pw
     * @param so superOut
     */
    public Menu(PrintWriter pw, SuperOut so) 
    {
        this.pw = pw;
        this.so = so;
    }

    /**
     * This method displays the main menu that contains options for conversions.
     */
    public void display()
    {
        so.superPrintln("  _________________________________  ");
        so.superPrintln("<| ========   Main Menu   ======== |>");
        so.superPrintln("<|_________________________________|>");
        so.superPrintln("[1] Scalar");
        so.superPrintln("[2] Subtract");
        so.superPrintln("[3] Derivative");
        so.superPrintln("[4] Evaluate poly");
        so.superPrintln("[5] Exit & Save log\n");

        so.superPrint("Select option[?]: ");

    }

    /**
     * This method receives input from user and is validated using boolean and if statement.
     * Input is not valid when input is out of range.
     */
    public void inputCheck()
    {
        Boolean isValid = false;

        while(!isValid) {
            try {
                Scanner keyboard = new Scanner(System.in);
                selection = keyboard.nextInt();

                pw.print(selection);

                if (selection < 1 || selection > 7 ) {
                    so.superPrint("[Error] Invalid option, enter again: ");
                    isValid = false;
                }
                else {
                    isValid = true;
                }
            }
            catch(InputMismatchException exception) {
                pw.print(selection);
                so.superPrint("[Error] Invalid option, enter again: ");
            }
        }
    }

    /**
     * This method returns the selected menu option from inputCheck().
     * @return int selection
     */
    public int getSelection()
    {
        inputCheck();
        return selection;
    }
}
