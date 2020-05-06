/**
 * 알파벳을 숫자로 변환
 * 
 * 요약 : 이어진 알파벳으로 주어진 입력을 숫자로 변환해서 출력
 * 
 * 메모 : char 형태의 변수를 불러서 다른 캐릭터와 연산 가능하다 (기본적으로 char도 유니코드의 숫자로 저장)
 * 		 String과 연산을 하면 모든 타입들이 String으로 변환된다. 
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		for(int i=0; i<input.length(); i++) {
			char alphabet = input.charAt(i);
			System.out.print((alphabet - 'A' + 1) + " ");
		}
		
		scan.close();
	}
}
