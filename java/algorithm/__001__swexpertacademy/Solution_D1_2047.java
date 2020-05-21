/**
 * 신문 헤드라인
 * 
 * 요약 : 입력의 소문자를 모두 대문자로 바꿔주는 프로그램
 * 
 * 메모 : 아스키코드 값을 이용 ( 'A' - 'a' )
 * 
 * 		char도 연산과정에서는 int형으로 되기 때문에 char에 마지막에 저장할 때는 명시적인 형변환이 필요.
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<input.length(); i++) {
			char tmp = input.charAt(i);
			
			/* 각 캐릭터 마다 소문자이면 대문자로 변환 */
			if( tmp >= 'a' && tmp <= 'z') {
				tmp = (char)(tmp + ('A' - 'a'));
			}
			
			/* 스트링 빌더로 변환 */
			sb.append(tmp);
		}
		
		/* 출력 */
		System.out.println(sb.toString());
		scan.close();
	}

}
