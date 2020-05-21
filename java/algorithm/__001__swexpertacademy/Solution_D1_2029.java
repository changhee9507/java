/**
 * 몫과 나머지 출력하기
 * 
 * 요약 : 목과 나머지 출력
 * 
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt(); 
		
		for(int testcase = 1; testcase <= TESTCASE; testcase++) {
		int dividend = scan.nextInt();
		int divisor = scan.nextInt();
		
		/* 몫 */
		int quotient = dividend / divisor;
		int remainder = dividend % divisor;
		
		System.out.printf("#%d %d %d\n", testcase, quotient, remainder);
		}
		
		scan.close();
	}

}
