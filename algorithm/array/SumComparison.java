package array;

import java.util.Scanner;

public class SumComparison {

	static int[][] input = new int[100][100];
	static int TESTCASE = 10;
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		for(int testCase =1; testCase <= TESTCASE; testCase++ ) {
			scanner.nextInt();
			int tmpSum = 0;
			int max = 0;
			
			/* save inputs to array */
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					
					input[i][j] = scanner.nextInt();
				}
			}
			
			/* printing */
			/*
			 * for(int i=0; i<100; i++) { for(int j=0; j<100; j++) {
			 * System.out.printf("%3d", input[i][j]); } System.out.println(); }
			 * 
			 */
			int rowSum = 0;
			int colSum = 0;
			int digSum1 = 0; /*left top to right bottom*/
			int digSum2 = 0; /*right top to left bottom*/
			
			for(int i=0; i<100; i++) {
				rowSum = 0;
				colSum = 0;
				for(int j=0; j<100; j++) {
					rowSum += input[i][j];
					colSum += input[j][i]; 
				}
				
				if(rowSum > max) max = rowSum;
				if(colSum > max) max = colSum;
				
				digSum1 = input[i][i];
				digSum2 = input[i][99-i];
				
			}
			
			if(digSum1 > max) max = digSum1;
			if(digSum2 > max) max = digSum2;
			
			System.out.printf("#%d %d\n", testCase, max);
			
		}
		
		
		
	}

}
