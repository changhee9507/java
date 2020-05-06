/**
 * 연월일 달력
 * 
 * 요약: 연월일순으로 8자리 숫자가 붙여진 입력이 주어질때 유효한 날짜인지 판단해서 출력
 * 
 * 메모: Scanner의 next()와 nextInt()는 똑같이 공백을 무시하고 다음 것을 받기 때문에 같이
 * 		사용할 수 있다. nextLine()은 뛰어쓰기와 줄바꿈도 포함하기 때문에 혼용하지 않는것이 좋다.
 * 
 * 		String.format{}은 printf처럼 사용할 수 있어서 문자열을 원하는 형식으로 생성할 때 유용하다.
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D1_2056 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int TESTCASE = scan.nextInt();
		
		for(int testcase = 1; testcase<= TESTCASE; testcase++) {
			
			String input = scan.next();
			int year = Integer.parseInt(input.substring(0,4));
			int month = Integer.parseInt(input.substring(4,6));
			int day = Integer.parseInt(input.substring(6,8));
			
			String result = String.format("%04d/%02d/%02d", year, month, day);
			
			if(month < 1 || month > 12) result = "-1";
			switch(month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if(day <1 || day > 31) {
						result = "-1";
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if(day <1 || day > 30) {
						result = "-1";
					}
					break;
				case 2:
					if(day <1 || day >28) {
						result = "-1";
					}
					break;
			}
			
			System.out.printf("#%d %s\n", testcase, result);
		}
		
		scan.close();
	}

}
