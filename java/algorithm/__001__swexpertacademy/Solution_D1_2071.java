/**
 * 평균값 구하기
 * 
 * 요약 : 입력받는 숫자들의 평균을 출력 
 * 		 - 반올림
 * 
 * 메모 : 
 * 	1.Math.round()
 * 
 * 	첫번째 소수에서 반올림해서 실수를 반환
 * 	System.out.println((int) Math.round(31.14 * 10 ) / 10.0);
 * 	이와 같은 방법으로 몇번째 자리수에서 반올림을 할 지 조절할 수 있음  
 * 	
 * 	
 * 
 * @author changhee Yoon
 */

package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2071 {

	static int INPUT_NUM = 10; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt();
		
		for(int testcase =1; testcase<= TESTCASE; testcase++) {
			
			double sum = 0;
			
			/* 인풋을 받아서 누적 */
			for(int i = 0; i<INPUT_NUM; i++) {
				sum += scan.nextInt();
			}
			
			/* 첫번째 소수에서 반올림 */
			int avg = (int) Math.round(sum / INPUT_NUM);
			
			System.out.printf("#%d %d\n", testcase, avg);
				
		}
		scan.close();
	}
}
