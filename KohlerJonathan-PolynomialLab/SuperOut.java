import java.io.PrintWriter;

/**
 * The SuperOut class is a convenient way way to print to console and to file at the same time.
 * @author Jonathan Kohler
 * @version 8/2/2019
 */
public class SuperOut {
    private PrintWriter pw;

    /**
     * Default constructor for SuperOut, passes pw object.
     * @param pw
     */
    public SuperOut(PrintWriter pw) {
        this.pw = pw;
    }

    /**
     * This method prints string to console and to file.
     * @param s
     */
    public void superPrint(String s) {
        System.out.print(s);
        pw.print(s);

    }

    /**
     * This method prints int to console and to file.
     * @param x
     */
    public void superPrint(int x) {
        System.out.print(x);
        pw.print(x);

    }

    /**
     * This method prints string to console and to file with new line.
     * @param s
     */
    public void superPrintln(String s) {
        System.out.println(s);
        pw.println(s);

    }

    /**
     * This method prints int to console and to file with new line.
     * @param x
     */
    public void superPrintln(int x) {
        System.out.println(x);
        pw.println(x);

    }

    /**
     * This method closes the printWriter object.
     */
    public void close(){
        pw.close();
    }
}
