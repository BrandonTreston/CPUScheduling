package cpuscheduling;

import java.io.IOException;

public class CSVTest {
	public static void main (String[] args) {
		CSVReader test = new CSVReader("C:/Users/brand/OneDrive/Desktop/project.csv");
		try {
			test.read();
			test.convertValues();
			test.getValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}
	}

