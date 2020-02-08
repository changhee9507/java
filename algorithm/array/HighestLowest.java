/**
 * get the height of boxs and get the number of dumps
 * one dump means that we move one from highest one to lowest one.
 * After we finish the movement, print the difference between highest and lowest.
 * 
 * @author Changhee Yoon
 */

package array;

import java.util.Arrays;
import java.util.Scanner;

public class HighestLowest {
	
	static int TESTCASE = 10;
	static int[] height = new int[100];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		for(int testCase = 1; testCase <= TESTCASE; testCase++) {
			
			int dumpNum = scanner.nextInt();
			
			/* save the height of the buildings */
			for(int i = 0; i<100; i++) {
				height[i] = scanner.nextInt();
			}
			
			/* printing */
			/* System.out.println(Arrays.toString(input)); */
			 			
			for(int i =0; i<dumpNum; i++) {
				Arrays.sort(height);
				
				if(height[0] == height[99]) {
					break;
				}
				else {
					height[0]++;
					height[99]--;
				}
				
				/* System.out.println(Arrays.toString(height)); */
			}
			
			Arrays.sort(height);
			
			System.out.printf("#%d %d\n", testCase, height[99]-height[0]);
		
		}
		
		
		
	}

}
