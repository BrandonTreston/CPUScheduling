package cpuscheduling;

import queue.ArrayBoundedQueue;

public class CPU {
	
	public CPU(int time) { //in milliseconds
		quantum = time;
	}
	
	public void addProcess(Process input) {
		ready.enqueue(input);
		input.setStartTime();
	}
							
	//executes a process for a specified time quantum.
	public void execute() throws InterruptedException {
		while(ready.isEmpty() != true) {
		Process currentProcess = ready.dequeue();
		System.out.println(currentProcess.getProcessInfo());
		
		Thread.sleep(quantum); //simulates the process running for the specified time quantum
		currentProcess.update(quantum);	
		
			System.out.println("\nQuantum Done!");
			System.out.println("Process " + currentProcess.pid + " Remaing burst: " + currentProcess.burst + " milliseconds");
		if( currentProcess.burst <= 0) {
				terminated.enqueue(currentProcess);
				currentProcess.setCompletionTime();
				System.out.println("Process Service Time: " + currentProcess.getCompletionTime() + "\n");
		}
		else{
			ready.enqueue(currentProcess);
			currentProcess.contextSwitch++;
			System.out.print("\n");
			}
		}
	}
	
	public void pulseClock() throws InterruptedException {
		while(ready.isEmpty() != true) {
		clock = System.currentTimeMillis();
		Thread.sleep(1000);
		System.out.println("~~pulse~~");
		}
	}
	public long getClock() {
		return clock;
	}
	public long getRunTime() {    // how long cpu has been running
		return System.currentTimeMillis() - cpuStart;
		 
	}
	public void startCPU() {
		cpuStart = System.currentTimeMillis();
	}
	public long averageTurnaround() {
		long temp = 0;
		for(int i = 0; i <= terminated.size()-1; i++) {
		 temp = temp + terminated.get(i).calculateTurnaround();
	}
		return (temp/terminated.size());
	}
	public long averageWaitingTime() {
		long temp = 0;
		for(int i = 0; i <= terminated.size()-1; i++) {
			 temp = temp + terminated.get(i).calculateWaitingTime();
		}
		return (temp/terminated.size());
	}
	public int calculateUtilization() {
		double temp = 0;
		for(int i = 0; i <= terminated.size()-1; i++) {
			temp = temp + terminated.get(i).originalBurst;
		}
		int temp1 = (int) ((100 * temp) / (double)this.getRunTime());
		return temp1;
	}
	public double calculateThroughput() {
		double temp = -1;
		for(int i = 0; i <= terminated.size()-1; i++) {
		if (Integer.parseInt(terminated.get(i).pid) > temp) {
			temp = (terminated.get(i).getPid());
			}
		}
		return (temp / (terminated.get((int) (temp-1)).turnaroundTime / 1000));
	}
	private long clock;
	private long cpuStart;
	private int quantum;
	protected ArrayBoundedQueue<Process> ready = new ArrayBoundedQueue<Process>();
	protected ArrayBoundedQueue<Process> terminated = new ArrayBoundedQueue<Process>();

	
	
}
