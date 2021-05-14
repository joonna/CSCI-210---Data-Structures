import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class is an implementation of a polynomial.
 * @author Jonathan Kohler
 * @version 8/2/2019
 */
public class Polynomial {
    private PrintWriter pw;
    private SuperOut so;

    private String polyExpression;
    private String polyExpression2;

    private ObjectList list;
    private ObjectList polylist1;
    private ObjectList polylist2;
    private ObjectList difference;
    private ObjectList deriv1;
    private ObjectList deriv2;
    private ObjectList deriv3;
    private ObjectList scalar;
    private ObjectList evaluate;
    private int result;

    /**
     * This is the default constructor for Polynomial.
     * @param pw
     * @param so
     */
    public Polynomial(PrintWriter pw, SuperOut so) {
        this.pw = pw;
        this.so = so;

        this.polyExpression = "";
        this.polyExpression2 = "";
        this.result = 0;

        this.evaluate = new ObjectList();
        this.deriv1 = new ObjectList();
        this.deriv2 = new ObjectList();
        this.deriv3 = new ObjectList();
        this.scalar = new ObjectList();
        this.list = new ObjectList();
        this.polylist1 = new ObjectList();
        this.polylist2 = new ObjectList();
        this.difference = new ObjectList();
    }

    /**
     * This method creates a term object with the given parameters and adds to the list.
     * @param coeff
     * @param exp
     */
    public void attach(int coeff, int exp) {
        Term t = new Term(coeff, exp);
        list.addLast(t);
    }

    /**
     * This method gets one polynomial from the user.
     */
    public void getInput() {
        Scanner keyboard = new Scanner(System.in);

        so.superPrint("Enter Polymonimal: ");
        polyExpression = keyboard.nextLine();

        pw.print(polyExpression);
        pw.println(" ");

        parsePoly(polyExpression);
        polylist1 = list.copyList();
        list = new ObjectList();
    }

    /**
     * This method gets two polynomials from the user.
     */
    public void getInput2() {

        Scanner keyboard = new Scanner(System.in);

        so.superPrint("Enter first Polymonimal: ");
        polyExpression = keyboard.nextLine();
        pw.print(polyExpression);
        pw.println(" ");

        so.superPrint("Enter second Polymonimal: ");
        polyExpression2 = keyboard.nextLine();
        pw.print(polyExpression2);

        parsePoly(polyExpression);
        polylist1 = list.copyList();
        list = new ObjectList();

        parsePoly(polyExpression2);
        polylist2 = list.copyList();
        list = new ObjectList();

    }

    /**
     * This method returns the first polynomial
     * @return polyExpression
     */
    public String getPoly1() {
        return polyExpression;
    }

    /**
     * This method returns the second polynomial.
     * @return polyExpression2
     */
    public String getPoly2() {
        return polyExpression2;
    }

    /**
     * This method is used to launch scalar from the menu.
     */
    public void menu_scalar(){
        pw.println("");
        so.superPrintln("  _________________________________  ");
        so.superPrintln("<| =======   [1] Scalar   ======== |>");
        so.superPrintln("<|_________________________________|>");
        msg();

        int num = 0;
        Scanner key = new Scanner(System.in);

        so.superPrint("Enter scalar: ");
        num = key.nextInt();

        pw.print(num);
        pw.println(" ");

        getInput();

        so.superPrintln(" ");
        calc_scalar(polylist1, num);
    }

    /**
     * This method is used to launch subtraction from the menu.
     */
    public void menu_subtract() {
        pw.println("");
        so.superPrintln("  _________________________________  ");
        so.superPrintln("<| =======  [2] Subtract   ======= |>");
        so.superPrintln("<|_________________________________|>");
        msg();

        getInput2();

        pw.println(" ");
        subTwoPolys(polylist1, polylist2);
        difference = list.copyList();
        list = new ObjectList();

        so.superPrintln(" ");
        outputDifference();

    }

    /**
     * This method calculates the first 3 derivatives of a polynomial.
     */
    public void menu_derivative() {
        pw.println("");
        so.superPrintln("  _________________________________  ");
        so.superPrintln("<| =====   [3] Derivative   ====== |>");
        so.superPrintln("<|_________________________________|>");
        msg();

        getInput();

        so.superPrintln("");
        so.superPrintln("[1st derivative] ");
        calc_derivative(polylist1, deriv1);

        so.superPrintln("");
        so.superPrintln("[2nd derivative] ");
        calc_derivative(deriv1, deriv2);

        so.superPrintln("");
        so.superPrintln("[3rd derivative] ");
        calc_derivative(deriv2, deriv3);
    }

    /**
     * This method evaluates a polynomial.
     */
    public void menu_evaluate() {
        pw.println("");
        so.superPrintln("  _________________________________  ");
        so.superPrintln("<| =====  [4] Evaluate poly  ===== |>");
        so.superPrintln("<|_________________________________|>");
        msg();

        int x = 0;
        int coeff_temp;
        int exp_temp;

        getInput();

        Scanner key = new Scanner(System.in);

        so.superPrint("Enter x: ");
        x = key.nextInt();

        pw.print(x);
        pw.println("");

        so.superPrintln("");
        calc_evaluate(polylist1, x);

        ObjectListNode p = evaluate.getFirstNode();

        while(p != null) {
            Term temp = (Term) p.getInfo();

            coeff_temp = temp.getCoeff();
            exp_temp = temp.getExpon();

            result = result + (int) (Math.pow(coeff_temp, exp_temp));
            p = p.getNext();
        }

        so.superPrintln(" ");
        so.superPrintln("result = " + result);
    }

    /**
     * This method shows a tip the user.
     */
    public void msg() {
        so.superPrintln("Tip: Enter polynomial using the following format = 10x^2 + 5x^1 + 2");
        so.superPrintln(" ");

    }

    /**
     * This method outputs the header for the terms.
     */
    public void outputTermHeader() {
        so.superPrintln("\t" + "coeff" + "\t" + "expon");

    }

    /**
     * This method outputs the terms of a polynomial.
     * @param temp
     * @param counter
     */
    public void outputTerms(Term temp, int counter) {
        so.superPrintln("term " + counter + " | " +  temp.getCoeff() + "\t" + temp.getExpon());
    }

    /**
     * This method evaluates a polynomial.
     * @param alist
     * @param num
     */
    public void calc_evaluate(ObjectList alist, int num) {
        int counter = 1;
        int x = num;
        int coeff_temp;
        int exp_temp;

        ObjectListNode p = alist.getFirstNode();
        outputTermHeader();

        while(p != null) {
            Term temp = (Term) p.getInfo();

            coeff_temp = temp.getCoeff();
            exp_temp = temp.getExpon();

            if (exp_temp >= 1) {
                temp.setCoeff(coeff_temp * x);
                temp.setExpon(exp_temp);
            }

            outputTerms(temp, counter);
            evaluate.addLast(temp);

            p = p.getNext();
            counter++;
        }

    }

    /**
     * This method scales a polynomial
     * @param alist
     * @param num
     */
    public void calc_scalar(ObjectList alist, int num) {
        int counter = 1;
        int scalarnum = num;
        int coeff_temp;
        int exp_temp;

        ObjectListNode p = alist.getFirstNode();

        outputTermHeader();

        while(p != null) {
            Term temp = (Term) p.getInfo();

            coeff_temp = temp.getCoeff();
            exp_temp = temp.getExpon();

            temp.setCoeff(scalarnum * coeff_temp);
            temp.setExpon(exp_temp);

            outputTerms(temp, counter);

            scalar.addLast(temp);

            p = p.getNext();
            counter++;
        }
    }

    /**
     * This method derives a polynomial.
     * @param alist
     * @param derivlist
     */
    public void calc_derivative(ObjectList alist, ObjectList derivlist) {
        int counter = 1;
        int coeff_temp;
        int exp_temp;

        ObjectListNode p = alist.getFirstNode();

        outputTermHeader();

        while(p != null) {
            Term temp = (Term) p.getInfo();

            coeff_temp = temp.getCoeff();
            exp_temp = temp.getExpon();

            temp.setCoeff(coeff_temp * exp_temp);
            temp.setExpon(exp_temp - 1);

            outputTerms(temp, counter);

            derivlist.addLast(temp);

            p = p.getNext();
            counter++;
        }
    }

    /**
     * This method outputs the difference between two polynomials.
     */
    public void outputDifference() {
        int counter = 1;
        ObjectListNode p = difference.getFirstNode();

        outputTermHeader();

        while(p != null) {
            Term temp = (Term) p.getInfo();
            outputTerms(temp, counter);

            p = p.getNext();
            counter++;
        }
    }

    /**
     * This method parses the polynomial inputed from user.
     * @param poly
     */
    public void parsePoly(String poly) {
        String[] tokens;
        boolean isNeg = false;
        int coeff_temp;
        int exp_temp;

        tokens = poly.split("[ ]+");

        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].contains("-")) {
                isNeg = true;
            }

            if (tokens[i].contains("x") && tokens[i].contains("^")){
                String[] split = tokens[i].split("\\D+");

                coeff_temp = (Integer.parseInt(split[0]));
                exp_temp = (Integer.parseInt(split[1]));

                if (isNeg == true) {
                    coeff_temp = -coeff_temp;
                    isNeg = false;
                }

                attach(coeff_temp, exp_temp);
            }

            else if (tokens[i].contains("x") && !tokens[i].contains("^")){
                String split[] = tokens[i].split("x");

                coeff_temp = Integer.parseInt(split[0]);
                exp_temp = 1;

                if (isNeg == true) {
                    coeff_temp = -coeff_temp;
                    isNeg = false;
                }

                attach(coeff_temp, exp_temp);
            }

            else if (tokens[i].matches("\\d+")){
                coeff_temp = Integer.parseInt(tokens[i]);
                exp_temp = 0;

                if (isNeg == true) {
                    coeff_temp = -coeff_temp;
                    isNeg = false;
                }

                attach(coeff_temp, exp_temp);
            }
        }
    }

    /**
     * This method subtracts two polynomials.
     * @param list1
     * @param list2
     * @return list
     */
    public ObjectList subTwoPolys(ObjectList list1, ObjectList list2) {
        ObjectListNode p = list1.getFirstNode();
        ObjectListNode q = list2.getFirstNode();

        while (p != null && q != null) {
            Term t1 = (Term) p.getInfo();
            Term t2 = (Term) q.getInfo();

            if(t1.getExpon() == t2.getExpon()) {
                int coeff = t1.getCoeff() - t2.getCoeff();
                if (coeff != 0) {
                    attach(coeff, t1.getExpon());
                }

                p = p.getNext();
                q = q.getNext();
            }
            else if (t1.getExpon() > t2.getExpon()) {
                attach(t1.getCoeff(), t2.getExpon());
                p = p.getNext();
            }
            else {
                attach(t2.getCoeff(), t2.getExpon());
                q = q.getNext();
            }
        }
        while (p != null ) {
            Term t1 = (Term) p.getInfo();
            attach(t1.getCoeff(), t1.getExpon());
            p = p.getNext();
        }
        while (q != null ) {
            Term t2 = (Term) q.getInfo();
            attach(t2.getCoeff(), t2.getExpon());
            q = q.getNext();
        }
        return list;
    }
}
