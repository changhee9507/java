/**
 * 홀수만 더하기
 * 
 * 요약: 입력값들중 홀수만 더해서 출력
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt();
		
		for(int testcase = 1; testcase<= TESTCASE; testcase++) {
			int sum = 0;
			
			for (int i = 0; i < 10; i++){ /* 테스트 케이스 마다 인풋 값을 10개 */
				int input = scan.nextInt();
				if(input % 2 != 0) {
					sum += input;
				}
			}
			
			System.out.printf("#%d %d\n", testcase, sum);
				
		}	
		scan.close();
	}
}
