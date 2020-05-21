/**
 * 서랍의 비밀번호
 * 
 * 요약 : 주어진 두 수의 차이를 출력
 * 
 */
package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2043 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int password = scan.nextInt();
		int start = scan.nextInt();
		
		System.out.print(password - start + 1);
		scan.close();
	}

}
