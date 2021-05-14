import java.util.Scanner;
import java.io.*;
/**
 * Converts an 8-digit hexadecimal number into either a decimal or a binary number
 *
 * @author Jonathan Kohler Palomar ID: 011165333
 * @version 6/30/2019
 */
public class Hexadecimal
{
    // instance variables
    private PrintWriter pw;
    // reads input
    Scanner s = new Scanner(System.in); 

    /**
     * Constructor for objects of class Hexadecimal
     */
    public Hexadecimal(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     * converts an 8-digit hexadecimal number into a decimal integer
     * 
     * @param  None
     * @return None
     */
    public void hexToDec()
    {
      String hexStr;   // The input hexadecimal String
      int hexStrLen;   // The length of hexStr
      int dec = 0;     // The decimal equivalent, accumulating from 0
 
    
      System.out.print("Enter a Hexadecimal: ");
      pw.println("Enter a Hexadecimal: ");
      hexStr = s.next();
      hexStrLen = hexStr.length();
      pw.println(hexStr);
 
      // Process char by char from the right (least-significant digit)
      for (int exp = 0; exp < hexStrLen; ++exp) {
         int charPos = hexStrLen - 1 - exp;
         char hexChar = hexStr.charAt(charPos);
         int factor = (int)Math.pow(16, exp);
         // 23 cases: '0'-'9', 'a'-'f', 'A'-'F', other (error)
         if (hexChar >= '0' && hexChar <= '9') {
            dec += (hexChar - '0') * factor;
         } else if (hexChar >= 'a' && hexChar <= 'f') {
            dec += (hexChar - 'a' + 10) * factor;
         } else if (hexChar >= 'A' && hexChar <= 'F') {
            dec += (hexChar - 'A' + 10) * factor;
         } else {
            // checks for user input error if input is not a hexadecimal
            System.out.println("Error: Invalid hex string \"" + hexStr + "\"");
            System.exit(1);
         }
      }
      System.out.println(dec);
      pw.println( dec);
     }
   
    /**
     *  converts an 8-digit hexadecimal number into a 32-bit binary number
     * 
     * @param  None
     * @return None
     */
     public void  hexToBin()
    {
        
        
       String[]hex={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};  
       String[]binary={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};  
  
       
       System.out.print("Enter a Hexadecimal: "); 
       pw.println("Enter a Hexadecimal: ");  
       String userInput=s.next();
       pw.println(userInput);
       String result="";  
       for(int i=0;i<userInput.length();i++) {  
           char temp=userInput.charAt(i);  
           String temp2=""+temp+"";  
           for(int j=0;j<hex.length;j++) {  
               if(temp2.equalsIgnoreCase(hex[j])) {  
                   result=result+binary[j];  
               }  
           }  
        }  
        System.out.println(result);  
        pw.println(result);
    }
  
}
