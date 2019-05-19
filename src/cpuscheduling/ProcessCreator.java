package cpuscheduling;

import java.util.ArrayList;

public class ProcessCreator {
	//constructor for process creator object. initializes default values
	public ProcessCreator() {
		process=null;
		
	}
	public void createProcess(String pid, String arrival, String burst) {
		process = new Process(pid, arrival, burst);
		processes.add(process);
	}
	
	protected ArrayList<Process> processes = new ArrayList <Process>();
	private Process process;
}
