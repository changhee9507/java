/**
 * 최대수 구하기
 * 
 * 요약 : 주어진 숫자들 중 가장 큰 수를 출력 
 * 
 * 메모 :
 * 
 * @author Changhee Yoon
 */

package SW_Expert_Academy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D1_2068 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int TESTCASE = scan.nextInt();
		
		for(int testcase=1; testcase<=TESTCASE; testcase++) {
			
			int[] input = new int[10];
			
			for(int j=0; j<10; j++) {
				input[j] = scan.nextInt();
			}
			
			/* 정렬이후 끝의 숫자가 가장 큰 수 */
			Arrays.sort(input);
			System.out.printf("#%d %d\n", testcase, input[9]);
		}
		
		scan.close();
	}

}
