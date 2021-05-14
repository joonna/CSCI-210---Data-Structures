import java.io.*;
import java.util.Scanner;

/**
 * Driver Class
 * 
 * Project Title: Multi-Level Feedback Queue Simulation.
 * Project Descritption: simulates an operating system's job schedule 
 * which determines which process will be given to the CPU when it becomes available.  
 * How to start the Project: Go to driver and select void main and click on "ok"
 * @author Jonathan Kohler 
 * Palomar ID: 011165333
 * @version 7/22/2019
 * User Instructions: Compile first.
 * 
 */

public class Driver {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException  {
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Scanner inputFile = new Scanner(new File("mfq5.txt")); //used to read mfq text file	
		JFrameExtraCredit jFrame = new JFrameExtraCredit();
		MFQ mfq = new MFQ(pw, jFrame);
		jFrame.setVisible(true);
		Clock clock = new Clock(inputFile, pw, jFrame);
		clock.getJobs();	
		mfq.header();
		clock.runSimulation();
		clock.stats();
		inputFile.close();
		pw.close();
	}

}