/**
 * 1대1 가위바위보
 * 
 * 요약 : 숫자로 가위바위보 입력이 주어졌을 때 누가 이겼는지 결과 출력
 * 
 * @author Changhee Yoon
 * 문제 출처 : SW expert Academy 
 */
package SW_Expert_Academy;

import java.util.Scanner;

public class Solution_D1_1936 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int aInput = scan.nextInt();
		int bInput = scan.nextInt();
		char result = '?';
		
		switch(aInput) {
		case 1:
			if(bInput == 2) result = 'B';
			if(bInput == 3) result = 'A';
			break;
		case 2:
			if(bInput == 1) result = 'A';
			if(bInput == 3) result = 'B';
			break;
		case 3:
			if(bInput == 1) result = 'B';
			if(bInput == 2) result = 'A';
			break;
		}
		
		System.out.println(result);
		scan.close();
		
		
	}

}
