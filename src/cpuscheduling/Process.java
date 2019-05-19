package cpuscheduling;

public class Process {

	public Process(String processID, String arrivalTime, String burstTime) {
		pid = processID;
		arrival = Integer.parseInt(arrivalTime) * 1000;  //*1000 converts to milliseconds
		burst = Integer.parseInt(burstTime) * 1000;		//*1000 converts to milliseconds
		originalBurst = burst;
	}
	
	public Process(String pid2, int arrival2, int burst2) {
		pid = pid2;
		arrival = arrival2 * 1000;  //*1000 converts to milliseconds
		burst = burst2 * 1000;		//*1000 converts to milliseconds
	}

	public String getProcessInfo() {
		return "pid= " + pid + "\narrival time= " + arrival + "\nContext Switches: " + contextSwitch + "\nburst time remaining= " + burst;
	}
	
	public void update(int value) {   //value is the time quantum
		if (burst <= value) {
			burst = 0;
		}
		else if(burst > value) {
		burst = burst - value;
		}
	}
	
	public long getBurst() {
		return burst;
	}
	
	public void setCompletionTime() {
		completionTime = System.currentTimeMillis() - startTime;
	}
	
	public long getCompletionTime() {
		return completionTime;
	}
	
	public void setStartTime() {
		startTime = System.currentTimeMillis();
	}
	
	public long getStartTime() {
		return startTime;
	}
	
	public long calculateTurnaround() {
		turnaroundTime = completionTime - arrival;
		return turnaroundTime;
	}
	public long calculateWaitingTime() {
		waitingTime = turnaroundTime - originalBurst;
		return waitingTime;
	}
	public int getPid() {
		int pid_ = Integer.parseInt(pid);
		return pid_;
	}
	protected long turnaroundTime;
	protected long waitingTime;
	private long startTime;
	private long completionTime;
	protected String pid;
	protected long arrival;
	protected long burst;
	protected long originalBurst;
	protected int contextSwitch = 0;
}