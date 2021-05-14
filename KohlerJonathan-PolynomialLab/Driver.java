import java.io.*;
/**
 * Driver Class
 * 
 * Project Title: Polynomial lab
 * Project Descritption: this project performs operations on polynomials using linear link list
 * @version 8/2/2019
 * How to start the Project: Go to driver and select void main and click on "ok"
 * @author Jonathan Kohler 
 * Palomar ID: 011165333
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
        int choice;

        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        SuperOut so = new SuperOut(pw);
        Polynomial poly = new Polynomial(pw, so);

        Menu menu = new Menu(pw, so);

        do {
            menu.display();
            choice = menu.getSelection();
            switch (choice) {
                case 1 : poly.menu_scalar(); break;
                case 2 : poly.menu_subtract(); break;
                case 3 : poly.menu_derivative(); break;
                case 4 : poly.menu_evaluate(); break;
            }

        } while (choice != 5);
        so.close();
    }
}