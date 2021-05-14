import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
/**
 * A class that converts a 32-bit binary number into either a decimal or a hexadecimal number
 * 
 * @author Jonathan Kohler Palomar ID: 011165333
 * @version 6/28/2019
 */
public class Binary
{
    // instance variables 
    private PrintWriter pw;

    //reads user input
    Scanner s = new Scanner(System.in);

    /**
     * Constructor for objects of class Binary
     */
    public Binary(PrintWriter pw)
    {
        this.pw = pw;

    }

    /**
     * Coverts a 32-bit binary number into a decimal number
     * 
     * @param  None
     * @return None
     */
    public void binToDec()
    {

        System.out.println("Enter a Binary Number: ");
        pw.println("Enter a Binary Number: ");
        // declare string containing binary number
        String binaryNumber = s.nextLine();
        pw.println(binaryNumber);

        char[] digits = binaryNumber.toCharArray();
        int sum = 0;
        int index = 0;
        if(binaryNumber.matches("[01]+")){
            //reverse iterate the array since calculation is done from right to left
            for (int radix = digits.length - 1; radix >= 0; radix--) {
                char c = digits[index];
                index++;
                int numericValue = Character.getNumericValue(c);
                int multiplier = (int) Math.pow(2, radix);
                sum += numericValue * multiplier;
            }

            System.out.println("Decimal number is : " + sum);
            pw.println("Decimal number is : " + sum);
        } else {
            System.out.println("ERROR");
            pw.println("ERROR");
        }
    }

    /**
     * Coverts a 32-bit binary number into an 8-digit hexadecimal number
     * 
     * @param   None
     * @return  None
     */
    public void binToHex()
    { 
        int i = 1, j = 0;

        int digitNumber = 1;
        int sum = 0;
        System.out.print("Enter a Binary Number: ");
        pw.println("Enter a Binary Number: ");
        String binary = s.next();
        pw.println(binary);

        if(binary.matches("[01]+")) {
            for( i = 0; i < binary.length(); i++){
                if(digitNumber == 1)
                    sum+=Integer.parseInt(binary.charAt(i) + "")*8;
                else if(digitNumber == 2)
                    sum+=Integer.parseInt(binary.charAt(i) + "")*4;
                else if(digitNumber == 3)
                    sum+=Integer.parseInt(binary.charAt(i) + "")*2;
                else if(digitNumber == 4 || i < binary.length()+1){
                    sum+=Integer.parseInt(binary.charAt(i) + "")*1;
                    digitNumber = 0;
                    if(sum < 10)
                        System.out.print(sum);
                    else if(sum == 10)
                        System.out.print("A");
                    else if(sum == 11)
                        System.out.print("B");
                    else if(sum == 12)
                        System.out.print("C");
                    else if(sum == 13)
                        System.out.print("D");
                    else if(sum == 14)
                        System.out.print("E");
                    else if(sum == 15)
                        System.out.print("F");
                    sum=0;
                }
                digitNumber++; 
                pw.print(digitNumber++);
            }
            
        } else {
            System.out.println("ERROR");
            pw.println("ERROR");
        }
    }
}

