import java.io.*;
/**
 * MFQ displays a header.
 * 
 * @author Jonathan Kohler
 * @version 7/22/2019
 */
public class MFQ
{
    // instance variables - replace the example below with your own
    private PrintWriter pw;
    private JFrameExtraCredit gui;

    /**
     * Constructor for objects of class MFQ
     * @param pw
     * @param gui
     */
    public MFQ(PrintWriter pw, JFrameExtraCredit gui)
    {
        this.pw = pw;
        this.gui = gui;
    }

    /**
     * this outputs a header
     */
    public void header() {
        System.out.println("Event\tSystemTime\tPID\tCPUTimeNeeded\tTotalTimeInSystem\tLowestLevelQueue\tResponseTime");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println();
       
        pw.println("Event\tSystemTime\tPID\tCPUTimeNeeded\tTotalTimeInSystem\tLovestLevelQueue\tResponseTime\n");
        pw.println("---------------------------------------------------------------------------------------------------------------------");
        pw.println("---------------------------------------------------------------------------------------------------------------------");
        pw.println();
        
        gui.console.append("Event\tSystemTime\tPID\tCPUTimeNeeded\tTotalTimeInSystem\tLovestLevelQueue\tResponseTime\n");
    }

    
}
