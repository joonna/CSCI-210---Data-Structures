import java.io.*;
import java.util.Scanner;
/**
 * This class is used to query words from the binary tree.
 * @author Jonathan Kohler
 * @version 8/13/19
 */
public class Query {
    private PrintWriter pw;
    private Xref refer;
    private String queryWord;

    /**
     * This is the default constructor for Query.
     * @param pw
     * @param x
     */
    public Query (PrintWriter pw, Xref x){
        this.pw = pw;
        this.refer = x;

        this.queryWord = null;
    }

    /**
     * This method is used to search words from the binary tree.
     */
    public void search() {
        char xchar = 'y';

        ObjectBinaryTree tree = refer.getTree();

        Scanner keyboard = new Scanner(System.in);
        Scanner tryAgain = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Type 0 to quit query & save log.");

        pw.println("----------------------------------------------------------------");
        pw.println("Type 0 to quit querying & save log.");

        while (xchar == 'y') {
            System.out.println(" ");
            System.out.print("Enter word to query: ");

            pw.println(" ");
            pw.print("Enter word to query: ");

            queryWord = keyboard.nextLine();
            pw.print(queryWord);
            pw.println(" ");

            if (queryWord.contains("0")) {
                System.out.println("----------------------------------------------------------------");
                System.out.println("Quering has stopped. Exiting program...");

                pw.println("----------------------------------------------------------------");
                pw.println("Quering has stopped. Exiting program...");
                break;
            }

            Word temp = new Word(queryWord.toLowerCase());

            //A word is searched in the binary tree by passing a word object into the method searchBST().
            ObjectTreeNode current = tree.searchBST(temp);

            //If the word is not found, it will give an error.
            if (current == null) {
                System.out.println("[Error] Could not find '" + queryWord +"'");
                pw.println("[Error] Could not find '" + queryWord +"'");
            }
            //If the word is found, it will print out the words information.
            else {
                Word w = (Word) current.getInfo();
                ObjectListNode p = w.getList().getFirstNode();

                System.out.print(String.format("%-15s %-10s", w.getWord(), w.getCount()));
                pw.print(String.format("%-15s %-10s", w.getWord(), w.getCount()));

                while (p != null) {
                    LinePosition l_temp = (LinePosition) p.getInfo();
                    System.out.print(l_temp.getLine() + "-" + l_temp.getPosition() + " ");
                    pw.print(l_temp.getLine() + "-" + l_temp.getPosition() + " ");

                    p = p.getNext();
                }

                System.out.println("");
                pw.println("");
            }

        }

        keyboard.close();
        tryAgain.close();
    }

    /**
     * This method outputs the header for cross reference.
     */
    public void header() {
        System.out.println("");
        System.out.println("----------------------------------------------------------------");
        System.out.println(String.format("%-12s %-12s %-8s",
                "[Word]",
                "[Count]",
                "[Line-Position]"));
        System.out.println("----------------------------------------------------------------");

        pw.println("");
        pw.println("----------------------------------------------------------------");
        pw.println(String.format("%-12s %-12s %-8s",
                "[Word]",
                "[Count]",
                "[Line-Position]"));
        pw.println("----------------------------------------------------------------");
    }
}
