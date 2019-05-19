package cpuscheduling;

import java.io.IOException;
import queue.ArrayBoundedQueue;

public class Test {
	
	public static void main (String [] args) {
		CSVReader reader = new CSVReader("C:/Users/brand/OneDrive/Desktop/project.csv");	//change this to the file path of the csv in the ZIP file
		try {
			reader.read();
			reader.convertValues();
			reader.addToTempArray();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayBoundedQueue <Process> wait = new ArrayBoundedQueue<Process>();    //wait queue, to hold processes until their arrival time.		 
		CPU cpu = new CPU(100);   //THIS IS THE TIME QUANTUM
		cpu.startCPU();
		ProcessCreator pc = new ProcessCreator();
		
		for (int i = 0; i <= reader.pids.length -1; i++) {
			pc.createProcess(reader.getPid(i), reader.getArrival(i), reader.getBurst(i));
			wait.enqueue(pc.processes.get(i));
		}
		
			while(wait.isEmpty() != true) {		//add process to the cpu at its arrival time.  FIX THIS!
			if(wait.getFront().arrival <= cpu.getRunTime()) {
				cpu.addProcess(wait.dequeue());
			}
		}	
			
		Thread thread1 = new Thread() {
			public void run() {
				try {
					cpu.pulseClock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				try {
					cpu.execute();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("average turnaround time (in ms) : " + cpu.averageTurnaround()) ;
		System.out.println("average waiting time (in ms) : " + cpu.averageWaitingTime());
		System.out.println("CPU Utilazation : " + cpu.calculateUtilization() + "%"); 
		System.out.println("Throughput : " + cpu.calculateThroughput()); 

		}
}