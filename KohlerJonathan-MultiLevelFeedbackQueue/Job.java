/**
 * this is my Job class for PID, arrival time, and CPU time.
 * 
 * @author Jonathan Kohler
 * @version 7/22/2019
 *
 */
public class Job {

	private int pid;
	private int arrivalTime;
	private int cpuTimeRequired;
	private int cpuTimeRemaining;

	
	/**
	 * Class constructor for class Job
	 * @param ArrivalTime
	 * @param Pid
	 * @param CpuTimeRequired
	 */
	public Job( int ArrivalTime, int Pid, int CpuTimeRequired) {
		this.arrivalTime = ArrivalTime;
		this.pid = Pid;
		this.cpuTimeRequired = CpuTimeRequired;
		this.cpuTimeRemaining = CpuTimeRequired;
		
	}
	
	/**
	 * Extracts the time when this job arrived in the queue/level
	 * @return arrivalTime
	 */
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	/**
	 * Extracts the job ID
	 * @return
	 */
	public int getPID() {
		return this.pid;
	}
	
	/**
	 * Returns the cpu time required for the current job
	 * @return cpuTimeRequired
	 */
	public int getCpuTimeRequired() {
		return this.cpuTimeRequired;
	}

	/**
	 * Returns the number of seconds needed to finish this job
	 * @return cpuTimeRemaining
	 */
	public int getTimeRemaining() {
		return this.cpuTimeRemaining;
	}
}