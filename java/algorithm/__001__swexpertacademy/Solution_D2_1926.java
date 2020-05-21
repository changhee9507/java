/**
 * 간단한 369게임
 * 
 * 요약: 369가 들어간 숫자는 숫자 대신 -를 갯수에 맞게 출력
 * 
 * 메모: charAt을 이용하면 스트링 자체를 char의 배열처럼 활용 가능
 * 
 * 		숫자의 각 자릿수를 활용하는 경우 나는 스트링을 배열로 생각해서 하나씩 접근했는데
 * 		10으로 나눈 다음 10의 나머지를 활용하면 한자릿수씩 확인 할 수 있다.
 * 
 * 		3,6,9를 확인하는 것도 3으로 나눈 나머지로 확인하면 간소화 할 수 있다. 
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D2_1926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		
		
		for(int i=1; i<= inputNum; i++) {
			check(i); /*1부터 주어진 숫자까지 함수에 대입*/
		}
		scan.close();
	
	}
	
	/* 해당 숫자에 3,6,9가 포함되는지 확인하고 조건에 맞게 출력*/
	private static void check(int num) {
		// TODO Auto-generated method stub
		String checkingNum = String.valueOf(num); /* 주어진 숫자를 스트링으로 변환 */
		int count = 0; /* 3,6,9의 숫자 */
		
		/* 각 자릿수에 3,6,9가 있는지 확인하고 카운트 */
		for(int i=0; i<checkingNum.length(); i++) {
			char c = checkingNum.charAt(i);
			if(c == '3' || c == '6' || c=='9') {
				count++;
			}
		}
		
		if(count == 0) { /*3,6,9가 포함되지 않은 경우에는 그냥 숫자 출력*/
			System.out.print(num + " ");
		}else { /* 카운트가 1이상인 경우에는 카운트 만큼 - 출력*/
			for(int i = 0; i<count; i++) {
				System.out.print('-');
			}
			System.out.print(" ");
		}
		
	}

}
