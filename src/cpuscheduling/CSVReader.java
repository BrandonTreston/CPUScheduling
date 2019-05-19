package cpuscheduling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVReader {

	public CSVReader(String inCSVFile) {
		csvFile = inCSVFile;

	}
	 
	public void read() throws IOException {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine())!= null) {
			values.add(line);
		}			
	}
	public void getValues() {
		for (int i = 0; i<= values.size() -1; i++) {
			System.out.println(values.get(i));
		}
	}
	public void convertValues() {	//converts the string of values from the arraylist into values of an array. will be used to initialize values of the process
		for (int j = 0; j<=values.size()-1;j++) {	
		String temp = values.get(j);
			for(int i = 0; i<=5; i++) {
				if (i%2 == 0 || i==0) {
					String finalTemp = temp.substring(i,i+1);
					convertedValues.add(finalTemp);
				}
			}
		}
	}
	public void addToTempArray() {
		int count = 0;
		String temp;
		int i = 0;
		int j = 0;
		for (i = 0; i <= convertedValues.size()-1; i++) {
		if (count == 0) {
			temp = convertedValues.get(i);
			pids[j] = temp;
			count++;
		}
		else if (count == 1) {
			temp = convertedValues.get(i);
			arrivals[j] = temp;
			count++;
		}
		else {
			temp = convertedValues.get(i);
			bursts[j] = temp;
			j++;
			count = 0;
			}
		}
	}
	
	public String getPid(int index) {
		return pids[index];
	}
	public String getArrival(int index) {
		return arrivals[index];
	}
	public String getBurst(int index) {
		return bursts[index];
	}
	public void printConv() {	//prints the converted numbers
	System.out.println(convertedValues);

}
	
	ArrayList <String> values = new ArrayList <String>();
	BufferedReader br = null;
	String line = "";
	String csvSplit = ",";
	String csvFile;
	ArrayList<String> convertedValues = new ArrayList<String>();
	protected String[] pids = new String[4];
	protected String[] arrivals= new String[4];
	protected String[] bursts= new String[4];

	
}
