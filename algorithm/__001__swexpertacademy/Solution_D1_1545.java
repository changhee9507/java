/**
 * 거꾸로 출력해 보아요
 * 
 *  요약: 주어진 숫자부터 0까지 순서대로 출력
 * 
 * @author Changhee Yoon
 * 문제 출처 : SW expert Academy 
 */

package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_1545 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		
		for(int i=inputNum; i>= 0; i--) {
			System.out.print(i + " ");
		}
		scan.close();
		
	}

}
