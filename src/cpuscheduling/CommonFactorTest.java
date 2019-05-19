package cpuscheduling;

import java.util.Scanner;

public class CommonFactorTest {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("enter two integer values to find their common factors: ");
		CommonFactors calculator = new CommonFactors(in.nextInt(), in.nextInt());
		try {
			calculator.findCommonFactors();
		} catch (ConstraintError e) {
			System.out.println(e.getMessage());
		}
		in.close();
	}
}
