import java.io.*;
/**
 * Project Title: Number Systems Lab
 * Project Description: Java program that performs number conversion for binary, decimal, and hexadecimal numbers
 * @version 6/28/2019
 * How to Start the Project: compile the driver.
 * @author Jonathan Kohler
 * PalomarID 011165333
 * User Instructions: Enter menu choices to do desired conversions
 */
public class Driver
{
    public static void main(String[] args) throws IOException {
        int choice;

        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Decimal dec = new Decimal(pw);
        Binary bin = new Binary(pw);
        Hexadecimal hex = new Hexadecimal(pw);
        Menu menu = new Menu(pw);

        do {
            menu.display();
            choice = menu.getSelection();
            switch (choice) {
                case 1 : dec.decToBin(); break;
                case 2 : dec.decToHex(); break;
                case 3 : bin.binToDec(); break;
                case 4 : bin.binToHex(); break;
                case 5 : hex.hexToDec(); break;
                case 6 : hex.hexToBin(); break;

            }
        } while (choice != 7);
        pw.close();
    }
}

