import java.io.*;
import java.util.Scanner;
/**
 * This is the driver class which contains the main method to run the whole program.
 * Project Title: Binary Tree and Hashing Lab
 * Project Descritption: utilizes binary trees to build a cross-reference listing,
 * display word line numbers and the number of times each word appears in the document and
 * allow the user to query for specific words.
 * How to start the Project: Go to driver and select void main and click on "ok"
 * User Instructions: Compile first and go to Driver
 * @author Jonathan Kohler
 * ID: 011165333
 * @version 8/15/19
 */
public class Driver {

    /**
     * This is the main method for the driver.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Scanner getty = new Scanner(new File("getty.txt"));
        Scanner omitt = new Scanner(new File("omit.txt"));

        Hash h = new Hash(pw);
        Xref x = new Xref(pw, getty, omitt, h);
        Query q = new Query(pw, x);

        System.out.println("Hash Function Description");
        pw.println("Hash Function Description");
        h.hashFunctionDescription();

        System.out.println("\n\n Getty Address");
        pw.println("\r\n\r\n  Getty Address");
        x.printGetty();

        System.out.println("\n\n Hash Table");
        pw.println("\r\n\r\n Hash Table");
        x.parseOmitt();
        h.printHashTable();

        System.out.println("\n\n Cross Reference");
        pw.println("\r\n\r\n Cross Reference");
        x.parseGetty();
        x.printTree();

        System.out.println("\n\n Query Search");
        pw.println("\r\n\r\n Query Search");
        q.search();

        pw.close();
    }
}
