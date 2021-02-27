/**
 * N줄덧셈
 * 
 * 요약 : 1부터 주어진 숫자까지의 덧셈을 출력
 * 
 * 메모 : 1부터 n까지 자연수의 합 = (1+n)/2 * n   
 * 
 * @author Changhee Yoon
 */

package SW_Expert_Academy;

import java.util.Scanner;

public class Solution_D1_2025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		double sum = (1 + num)/2.0 * num;
		System.out.println((int)sum);
		scan.close();
		
	}

}
