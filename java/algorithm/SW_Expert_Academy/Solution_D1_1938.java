/**
 * 아주 간단한 계산기
 * 
 * 요약: 두 자연수를 입력 받아 사칙연산 결과 출력
 * 
 * @author Changhee Yoon
 * 문제 출처 : SW expert Academy 
 */
package SW_Expert_Academy;

import java.util.Scanner;

public class Solution_D1_1938 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int operand1 = scan.nextInt();
		int operand2 = scan.nextInt();
		
		System.out.println(operand1+operand2);
		System.out.println(operand1-operand2);
		System.out.println(operand1*operand2);
		System.out.println(operand1/operand2);
		
		scan.close();
		
	}

}
