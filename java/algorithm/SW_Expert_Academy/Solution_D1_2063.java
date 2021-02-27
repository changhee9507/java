/**
 * 중간값 찾기
 * 
 * 요약: 입력 값들 중에서 중간값을 찾아서 출력
 * 
 * @author Changhee Yoon
 */
package SW_Expert_Academy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D1_2063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int inputAmount = scan.nextInt();
		int[] inputArr = new int[inputAmount];
		
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = scan.nextInt();
		}
		
		Arrays.sort(inputArr);
		System.out.print(inputArr[inputAmount/2]);
		
		scan.close();
	}

}
