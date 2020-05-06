/**
 * 자릿수 더하기
 * 
 * 요약 : 정수 입력을 받아서 각 자릿수를 합친 값을 출력
 * 
 * 메모 :
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int inputNum = scan.nextInt();
		
		int sum = 0;
		
		/*반복*/
		
		/* 뒷자리부터 구하면서 10자리씩 줄여나간다 */
		while(inputNum != 0) {
		sum += (inputNum % 10);
		inputNum /= 10;
		}
		
		System.out.println(sum);
		
		scan.close();
	}
}
