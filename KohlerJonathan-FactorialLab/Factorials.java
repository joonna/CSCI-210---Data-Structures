import java.io.PrintWriter;
/**
 * The point of the class is to calculate the factorials of numbers provided by the user
 * @author Jonathan Kohler
 * @version 7/27/2019
 */

public class Factorials
{
    private PrintWriter pw;

    /**
     * Factorials constructor
     * @param PrintWriter pw
     */

    public Factorials(PrintWriter pw) {
        this.pw = pw;
    }

    /**
     * getList calculates the factorial of the number provided to the method by the user from the main method.
     * @param int fact 
     * @return ObjectList f
     */

    public ObjectList getList(int fact) {
        long start = System.currentTimeMillis();
        ObjectList f = new ObjectList();
        ObjectList g = new ObjectList();
        ObjectList h = new ObjectList();
        f.addFirst(1);
        h.addFirst(0);
        ObjectListNode here;
        ObjectListNode there;
        int remaining = 0;
        int count = 2; 
        int divisor = 1;
        if(fact == 1) //If the number provided is 1, then the factorial of 1 is immediately returned.
            return f; 
        while(count <= fact) { //If the number is more than 1, then the calculation of the factorial takes place in one long while loop, until the count of the while loop is equivalent to the number provided by the user.
            while(count / divisor != 0) {
                g = f.copyList();
                here = g.getFirstNode();
                there = h.getFirstNode();

                remaining = 0;
                while(here != null) 
                {
                    here.setInfo((Integer)here.getInfo() * ((count%(divisor*10))/(divisor)) + remaining); // how to get from 0-9 to 10 - 100

                    remaining = 0;
                    if(((Integer)here.getInfo()) > 999) {
                        remaining = ((Integer)here.getInfo() / 1000);
                        here.setInfo(((Integer)here.getInfo()) % 1000);
                    }
                    here = here.getNext();
                }
                if(here == null) 
                {
                    if(remaining != 0){
                        g.addLast(remaining); 

                    }
                    here = g.getFirstNode();
                    remaining = 0;
                    int divisor2 = divisor;
                    while(divisor2 / 10 != 0) {
                        while(here != null) {
                            here.setInfo(((Integer)here.getInfo()) * 10 + remaining); // how to get from 0-9 to 10 - 100
                            remaining = 0;
                            if(((Integer)here.getInfo()) > 999) {
                                remaining = ((Integer)here.getInfo() / 1000);
                                here.setInfo(((Integer)here.getInfo()) % 1000);
                            }
                            here = here.getNext();
                        }
                        if(remaining != 0){
                            g.addLast(remaining); 
                        }
                        remaining = 0;
                        divisor2 /= 10;
                        here = g.getFirstNode();
                    }
                }                   
                here = g.getFirstNode();
                there = h.getFirstNode();
                remaining = 0;
                while(here != null) {
                    there.setInfo((Integer)there.getInfo() + (Integer)here.getInfo() + remaining);
                    remaining = 0;
                    if((Integer)there.getInfo() > 999) {
                        remaining = ((Integer)there.getInfo() / 1000);
                        there.setInfo((Integer)there.getInfo()%1000);
                    }
                    here = here.getNext();
                    if(there.getNext() == null && here != null) h.addLast(0);
                    there = there.getNext();
                }
                if(remaining != 0){
                    h.addLast(remaining); 
                }
                divisor *= 10;
            }
            divisor = 1;
            count++;
            f = h.copyList();
            h.clear();
            h.addFirst(0);
        }
        long end = System.currentTimeMillis();
        System.out.print("took " + (end - start) + " milliseconds to compute and contains ");
        pw.println("took " + (end - start) + " milliseconds to compute and contains ");
        return f;
    }

    /**
     * Prints the values contained in the ObjectList from end to beginning in an appropriate manner.
     * @param ObjectList list 
     */

    public void printFactorial(ObjectList list) {
        ObjectListNode p = list.getLastNode();
        int count = 0;
        if(list.size() == 1) {
            System.out.println(p.getInfo());
            pw.println(p.getInfo());
            return;
        }
        else {
            System.out.print(p.getInfo() + ",");
            pw.print(p.getInfo() + ",");
        }
        if((Integer)p.getInfo() < 10) count += 1;
        else if((Integer)p.getInfo() < 100) count += 2;
        else count += 3;
        p = p.getBack();
        while(p.getBack() != null) {
            if(count > 42 && count <= 45) {
                System.out.println();
                pw.println();
                count = 0;
            }
            if((Integer)p.getInfo() < 10) {
                System.out.print("00" + p.getInfo() + ",");
                pw.print("00" + p.getInfo() + ",");
            }
            else if((Integer)p.getInfo() < 100) {
                System.out.print("0" + p.getInfo() + ",");
                pw.print("0" + p.getInfo() + ",");
            }
            else {
                System.out.print(p.getInfo() + ",");
                pw.print(p.getInfo() + ",");
            }
            count += 3;
            p = p.getBack();
        }
        if(count > 42 && count <= 45) {
            System.out.println();
            pw.println();
            count = 0;
        }
        if((Integer)p.getInfo() < 10) {
            System.out.print("00" + p.getInfo());
            pw.print("00" + p.getInfo());
        }
        else if((Integer)p.getInfo() < 100) {
            System.out.print("0" + p.getInfo());
            pw.print("0" + p.getInfo());
        }
        else {
            System.out.print(p.getInfo());
            pw.print(p.getInfo());
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        pw.println();
        pw.println("-------------------------------------------------------------");
        pw.println();
    }

    /**
     * The number of digits in the factorial are determined and printed.
     * @param ObjectList list
     */

    public void printDigits(ObjectList list) {
        int count = 0;
        ObjectListNode d = list.getLastNode();
        if((Integer)d.getInfo() < 10) {
            count += 1;
        }
        else if((Integer)d.getInfo() < 100 && (Integer)d.getInfo() >= 10) {
            count += 2;
        }
        else count += 3;
        count += (list.size()-1)*3;
        System.out.println(count + " digits.");
        System.out.println();
        pw.println(count + " digits.");
        pw.println();
    }
}
