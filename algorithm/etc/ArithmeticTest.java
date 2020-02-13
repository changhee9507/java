package etc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArithmeticTest {

	final static int TESTCASE = 10;
	static char[] nodes;
	static int result = 1;
	static int inputNum;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= TESTCASE; testCase++) {
			inputNum = Integer.parseInt(scan.nextLine());
			nodes = new char[inputNum+1];
			
			for(int i=1 ; i<= inputNum; i++) {
				String input = scan.nextLine();
				nodes[i] = input.split(" ")[1].charAt(0);
			}
			
			System.out.println(Arrays.toString(nodes));
			
			check(1, false);
		}

	}
	
	static void check(int index, boolean preIsDigit) {
		
		if(index >= inputNum) {
			return;
		}
		
		
		
	}

}
