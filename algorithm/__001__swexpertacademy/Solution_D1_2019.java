/**
 * 더블더블
 * 
 * 요약: 1부터 주어진 숫자만큼 2를 곱한 값들을 출력
 * 
 * @author Changhee Yoon
 * 문제 출처 : SW expert Academy 
 */
package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		
		for (int i = 0; i <= inputNum; i++) {
			System.out.print((1<<i) + " ");
		}
		
		scan.close();
		
	}

}
