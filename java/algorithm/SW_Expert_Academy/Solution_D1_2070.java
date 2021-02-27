/**
 * 큰 놈, 작은 놈, 같은 놈
 * 
 * 요약 : 두 정수의 크기 상태에 따른 부등호 출력
 * 
 * 메모 :
 * 
 * @author changhee Yoon
 */

package SW_Expert_Academy;

import java.util.Scanner;

public class Solution_D1_2070 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt();
		
		for(int testcase =1; testcase <= TESTCASE; testcase++) {
			
			int firstNum = scan.nextInt();
			int secondNum = scan.nextInt();
			char result;
			
			if(firstNum > secondNum) {
				result = '>';
			}else if(firstNum == secondNum) {
				result = '=';
			}else {
				result = '<';
			}
			
			System.out.printf("#%d %c\n", testcase, result);
		}
		
		
		scan.close();
	}

}
