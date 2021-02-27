/**
 * 간단한 N의 약수
 * 
 * 요약 : 정수 N의 약수를 오름차순으로 출력
 * 
 * @author Changhee Yoon
 * 문제 출처 : SW expert Academy 
 */
package SW_Expert_Academy;

import java.util.Scanner;

public class Solution_D1_1933 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int Num = scan.nextInt();
		
		for (int i = 1; i <= Num; i++) {
			if(Num % i == 0) {
				System.out.print(i + " ");
			}
		}
		scan.close();
	}

}
