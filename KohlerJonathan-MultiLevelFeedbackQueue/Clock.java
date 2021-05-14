import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * Class that manages the queue input
 * @author Jonathan Kohler
 * @version 7/22/2019
 */

public class Clock {

    private Scanner inputFile;
    private PrintWriter pw;
    private ObjectQueue queueOfJobs;
    private ObjectQueue queue1;
    private ObjectQueue queue2;
    private ObjectQueue queue3;
    private ObjectQueue queue4;

    private JFrameExtraCredit gui;
    private double numJobs; // Number of jobs
    private int timeJobsSystem; // the total time of all the jobs in the system
    private int average_response_time;
    private int waitTime;
    /**
     * Constructor for class Clock
     * @param input
     * @param pw
     * @param gui
     */
    public Clock(Scanner input, PrintWriter pw, JFrameExtraCredit gui) {
        this.inputFile = input;
        this.pw = pw;
        this.queueOfJobs = new ObjectQueue();
        this.queue1 = new ObjectQueue();
        this.queue2 = new ObjectQueue();
        this.queue3 = new ObjectQueue();
        this.queue4 = new ObjectQueue();
        this.numJobs = 0;
        this.timeJobsSystem = 0;
        this.average_response_time = 0;
        this.waitTime = 0;
        this.gui = gui;

    }

    /**
     * Method that extracts the job from cpu
     */
    public void getJobs() throws InterruptedException {
        while(inputFile.hasNext()){
            String buf = inputFile.nextLine();
            String[] tokens = buf.split("\\s+");
            Job temp = new Job (Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
            queueOfJobs.insert(temp);
            Thread.sleep(gui.jSlider1.getValue());
            gui.inputQueue_model.addRow(new Object[] {temp.getPID() });
        }
    }

    /**
     * Calculates the statistics
     */
    public void stats() {
        System.out.println("\n        STATISTICS            ");
        System.out.println("Total number of jobs: " + String.valueOf(numJobs));
        System.out.println("Total time of all jobs in the system: " + String.valueOf(timeJobsSystem));
        System.out.println("Average response time: " + String.valueOf(average_response_time));
        double turnaround =  timeJobsSystem/numJobs;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Average turnaround time for all jobs: " + df.format(turnaround));
        double wait_time = waitTime/numJobs;
        System.out.println("Average waiting time: " + df.format(wait_time));
        double throughput = numJobs/timeJobsSystem;
        System.out.println("Average throughput for the system as a whole: " + df.format(throughput));

        pw.println();
        pw.println("\n        STATISTICS            ");
        pw.println("Total number of jobs: " + String.valueOf(numJobs)+ "\n\n");
        pw.println("Total time of all jobs in the system: " + String.valueOf(timeJobsSystem)+ "\n\n");
        pw.println("Average response time: " + String.valueOf(average_response_time)+ "\n\n");
        pw.println("Average turnaround time for all jobs: " + df.format(turnaround)+ "\n\n");
        pw.println("Average waiting time: " + df.format(wait_time) + "\n");
        pw.println("Average throughput for the system as a whole: " + df.format(throughput) + "\n");

        gui.console.append("\n        STATISTICS            \n");
        gui.console.append("Total number of jobs: " + String.valueOf(numJobs)+ "\n");
        gui.console.append("Total time of all jobs in the system: " + String.valueOf(timeJobsSystem)+ "\n");
        gui.console.append("Average response time: " + String.valueOf(average_response_time)+ "\n");
        gui.console.append("Average turnaround time for all jobs: " + df.format(turnaround)+ "\n");
        gui.console.append("Average waiting time: " + df.format(wait_time) + "\n");
        gui.console.append("Average throughput for the system as a whole: " + df.format(throughput) + "\n");
    }

    /**
     * Runs the simulation
     */
    public void runSimulation() throws InterruptedException{
        CPU cpu_stat = new CPU(gui);
        if (!queueOfJobs.isEmpty()) {
            Job newJob = (Job) queueOfJobs.remove();

            //This system will work only for 200 minutes
            for (int SystemTime = 0; SystemTime<156; SystemTime++) 
            {
                Thread.sleep(gui.jSlider1.getValue());
                gui.system.setText("System Time: " + SystemTime);
                if (cpu_stat.get_remaining_time() == 1) 
                {
                    Thread.sleep(gui.jSlider1.getValue());
                    int time = SystemTime - cpu_stat.get_arrival_time();
                    waitTime = time - cpu_stat.getCPUtime();
                    int repsonse_time = cpu_stat.getCPUtime()- cpu_stat.get_remaining_time();
                    gui.console.append("Departure\t" + SystemTime + "\t" + String.valueOf(cpu_stat.getPID()) + "\t \t" + "-"  + "\t \t \t" + String.valueOf(time) +  "\t \t \t" + String.valueOf(cpu_stat.getLevel())  + "\t \t" + repsonse_time + "\n");
                    System.out.println("Departure\t" + SystemTime + "\t" + String.valueOf(cpu_stat.getPID()) + "\t \t" + "-"  + "\t \t \t" + String.valueOf(time) +  "\t \t \t" + String.valueOf(cpu_stat.getLevel())  + "\t \t" + repsonse_time);
                    pw.println("Departure\t" + SystemTime + "\t" + String.valueOf(cpu_stat.getPID()) + "\t \t" + "-"  + "\t \t \t"+ String.valueOf(time) +  "\t \t \t" + String.valueOf(cpu_stat.getLevel())  + "\t \t" + repsonse_time + "\n");
                    timeJobsSystem = timeJobsSystem + time;
                    cpu_stat = new CPU(gui);
                } 
                cpu_stat.editQuantumClock();
                if (SystemTime == newJob.getArrivalTime()) 
                {
                    Thread.sleep(gui.jSlider1.getValue());
                    gui.queue1_model.addRow((new Object[] { newJob.getPID() }));
                    numJobs = numJobs + 1;
                    gui.console.append("Arrival\t\t" + SystemTime + "\t" + String.valueOf(newJob.getPID()) + "\t \t" + String.valueOf(newJob.getCpuTimeRequired() + "\t \t \t" + "-" + "\t \t \t" + "-"+ "\t \t" + "-" + "\n"));
                    System.out.println("Arrival\t\t" + SystemTime + "\t" + String.valueOf(newJob.getPID()) + "\t \t" + String.valueOf(newJob.getCpuTimeRequired() + "\t \t \t" + "-" + "\t \t \t" + "-"+ "\t \t" + "-"));
                    pw.println("Arrival\t\t" + SystemTime + "\t" + String.valueOf(newJob.getPID()) + "\t \t" + String.valueOf(newJob.getCpuTimeRequired()) + "\t \t \t" + "-" + "\t \t \t" + "-" + "\t \t" + "-" + "\n");
                    //Checks to see if there are any jobs running in CPU 
                    if (cpu_stat.get_remaining_time() > 0) 
                    {
                        Job reducedTimeJob = extract_job_info(cpu_stat, SystemTime);
                        //Move the reduced job to a different queue
                        move_job_different_level(cpu_stat, reducedTimeJob);
                    }
                    // queue1 gets 2 seconds for each new job
                    cpu_stat.newJob(newJob.getPID(), newJob.getCpuTimeRequired(), 2, newJob.getArrivalTime(), newJob.getCpuTimeRequired());
                    //extracts new job
                    if (!queueOfJobs.isEmpty()) 
                    {
                        newJob = (Job) queueOfJobs.remove();
                    }
                } 
                // jobs are moved to the appropriate level
                else if (cpu_stat.getQuantumClock() == 0) {

                    Job reducedTimeJob = extract_job_info(cpu_stat, SystemTime);
                    if (reducedTimeJob.getTimeRemaining() != 0) {
                        cpu_stat= move_job_different_level_and_continue(cpu_stat, reducedTimeJob);
                    } 
                    else {

                        if (!queue1.isEmpty()) 
                        {
                            Job nextJob = (Job) queue1.remove();
                            cpu_stat.start_next_level(1, nextJob);

                            gui.cpu_model.addRow((new Object[] { cpu_stat.getPID() }));
                        } 
                        else if  (!queue2.isEmpty()) 
                        {
                            Job nextJob = (Job) queue2.remove();
                            cpu_stat.start_next_level(2, nextJob);

                            gui.cpu_model.addRow((new Object[] { cpu_stat.getPID() }));
                        } 
                        else if  (!queue3.isEmpty()) 
                        {
                            Job nextJob = (Job) queue3.remove();
                            cpu_stat.start_next_level(3, nextJob);

                            gui.cpu_model.addRow((new Object[] { cpu_stat.getPID() }));
                        }  
                        else if  (!queue4.isEmpty()) 
                        {
                            Job nextJob = (Job) queue4.remove();
                            cpu_stat.start_next_level(4, nextJob);

                            gui.cpu_model.addRow((new Object[] { cpu_stat.getPID() }));

                        } 

                    }
                }
            }
        }
    }

    /**
     * Method that extracts info regarding the job running in the system
     * @param cpu_stat
     * @param SystemTime
     * @return Job
     */
    public Job extract_job_info(CPU cpu_stat, int SystemTime) {
        //Extract the pid, current level, and the remaining time for this job to complete and the total time in the system
        int pid = cpu_stat.getPID();
        int remainingTime = cpu_stat.get_remaining_time();
        int arrive_time = cpu_stat.get_arrival_time();
        //Create a reduced job
        Job reducedTimeJob = new Job(arrive_time, pid, remainingTime);
        return reducedTimeJob;
    }

    /**
     * Changes the level of the current running job
     * @param cpu_stat
     * @param reducedTimeJob
     */
    public void move_job_different_level(CPU cpu_stat, Job reducedTimeJob) {
        int currentQueue = cpu_stat.getLevel();
        if (currentQueue == 1) 
        {
            queue2.insert(reducedTimeJob);      
        } 
        else if (currentQueue == 2) 
        {
            queue3.insert(reducedTimeJob);
        } 
        else if (currentQueue == 3) 
        {
            queue4.insert(reducedTimeJob);
        } 
        else if (currentQueue == 4) 
        {
            queue4.insert(reducedTimeJob);
        }
    }

    /**
     * Changes the level of the current running job and starts the next job at the lowest level
     * @param cpu_stat
     * @param reducedTimeJob
     */
    public CPU move_job_different_level_and_continue(CPU cpu_stat, Job reducedTimeJob) {
        int currentQueue = cpu_stat.getLevel();
        if (currentQueue == 1) {
            queue2.insert(reducedTimeJob);
            Job nextJob = (Job) queue2.remove(); 
            cpu_stat.start_next_level(2, nextJob);
            gui.queue2_model.addRow((new Object[] { reducedTimeJob.getPID() }));
        } 
        else if (currentQueue == 2) 
        {
            queue3.insert(reducedTimeJob);
            if (queue2.isEmpty()) 
            {
                Job nextJob = (Job) queue3.remove(); 
                cpu_stat.start_next_level(3, nextJob);
                gui.queue3_model.addRow((new Object[] { reducedTimeJob.getPID() }));
            } 
            else 
            {
                Job nextJob = (Job) queue2.remove();
                cpu_stat.start_next_level(2, nextJob);
            }
        } else if (currentQueue == 3) {
            queue4.insert(reducedTimeJob);
            if (queue3.isEmpty()) {
                Job nextJob = (Job) queue4.remove(); 
                cpu_stat.start_next_level(4, nextJob);
            } else  {
                Job nextJob = (Job) queue3.remove();
                cpu_stat.start_next_level(3, nextJob);
            }
        } else if (currentQueue == 4) {
            queue4.insert(reducedTimeJob);
            Job nextJob = (Job) queue4.remove();
            cpu_stat.start_next_level(4, nextJob);
            gui.queue4_model.addRow((new Object[] { reducedTimeJob.getPID() }));
        }
        return cpu_stat;
    }

}