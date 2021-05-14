import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
/**
 * A class that converts Decimal into either a binary or a hexadecimal number
 * 
 * @author Jonathan Kohler Palomar ID: 011165333
 * @version 6/30/2019
 */
public class Decimal
{
    // instance variables 
    private PrintWriter pw;

    Scanner s = new Scanner(System.in);

    /**
     * Constructor for objects of class Decimal
     */
    public Decimal(PrintWriter pw)
    {
        this.pw = pw;

    }

    /**
     * Converts a decimal value to a binary 
     * 
     * @param  None
     * @return None
     */
    public void decToBin() 
    {
        try{
            System.out.println("Enter a decimal number: " );
            pw.println("Enter a decimal number: ");
            int a=s.nextInt();
            pw.println(a);
            int t=a;
            int z;
            String sa="";

            while(t>0){
                z=t%2;
                if(z==1){

                    sa="1"+sa;
                } else {

                    sa="0"+sa;
                }
                t=t/2;
            }

            System.out.println(sa);
            pw.println(sa);
        } catch(InputMismatchException exception) {

            //Print "NOT AN INTEGER" when the user puts something other than an integer
            System.out.println("NOT AN INTEGER");
            pw.println("NOT AN INTEGER");
        }
    }

    /**
     * Converts a deccimal value to a hexadecimal value
     * 
     * @param  None
     * @return None
     */
    public void decToHex()
    {
        try{
            System.out.println("Enter a decimal number: ");
            pw.println("Enter a decimal number: ");
            int num = s.nextInt();
            pw.println(num);
            int rmndr; // For storing remainder
            String str2="";  // For storing result

            // Digits in the hexadecimal number system
            char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

            while(num>0){
                rmndr=num%16; 
                str2=hex[rmndr]+str2; 
                num=num/16;
            }
            System.out.println("Decimal to Hexadecimal: "+str2);
            pw.println("Decimal to Hexadecimal: "+str2);     
        } catch(InputMismatchException exception) {

            //Print "NOT AN INTEGER" when user puts something other than an integer
            System.out.println("NOT AN INTEGER");
            
        }  
    }
}


