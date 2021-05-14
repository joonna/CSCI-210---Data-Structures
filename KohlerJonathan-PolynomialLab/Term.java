/**
 * This class is an implementation of terms of a polynomial.
 * @author Jonathan Kohler
 * @version 8/2/2019
 */
public class Term {
    public int coeff;
    private int exp;

    /**
     * Term constructor that sets the coeff and exp from the parameters passed.
     * @param c
     * @param e
     */
    public Term(int c, int e){
        coeff = c;
        exp = e;
    }

    /**
     * This method sets the terms coefficient.
     * @param c
     */
    public void setCoeff(int c) {
        coeff = c;
    }

    /**
     * This method sets the terms exponent.
     * @param e
     */
    public void setExpon(int e) {
        exp = e;
    }

    /**
     * This method gets the terms coefficient.
     * @return coeff
     */
    public int getCoeff(){
        return coeff;
    }

    /**
     * This method gets the terms exponent.
     * @return exp
     */
    public int getExpon() {
        return exp;
    }
}
