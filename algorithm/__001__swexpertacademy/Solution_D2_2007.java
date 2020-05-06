/**
 * 패턴 마디의 길이
 * 
 * 요약 : 주어진 문자열에서 패턴 마디의 길이를 계산하여 출력
 * 
 * 메모 :
 * 
 * 해결 전력 :	1. 마디길이이가 1~10까지의 범위로 작기 때문에 이것들을 순차적으로 마디 길이라고 가정한다 
 * 			2. 만약 마디 길이가 3이라면 모든 문자열의 i번째 문자는 i%3(3으로 나눈 나머지) 번째 문자와 같을 것이다.
 *  		3. 처음 조건은 true로 해두고 2 조건이 틀리면 false를 만드는 방식으로 확인한 다음 마디를 찾아 출력한다. 
 * 
 * 다른 사람 코드 리뷰 : 	어떤 사람은 1~10까지의 마디 길이를 차례대로 순회하면서 
 * 				 	subString(0, answer)가 subString(answer, answer * 2)와 같아지는 것을 패턴으로 인식한다
 * 				  
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D2_2007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt();
		
		for(int testcase = 1; testcase <= TESTCASE; testcase++) {
			String input = scan.next();
			
			for(int patternLength = 1; patternLength<= 10; patternLength++) { /*마디 길이는 1~10 사이 */
				/* 초기조건은 true */
				boolean allMatch = true;
				
				/* i번째 문자와 (마디길이로 나눈 나머지)번째 문자가 틀리면 false를 만든다 (패턴길이가 맞다면 틀릴수 없다) */
				for(int i=0; i<input.length(); i++) {
					if(input.charAt(i%patternLength) != input.charAt(i)) {
						allMatch = false;
					}
				}
				
				/* false로 바뀌지 않았다면 패턴 길이가 맞다는 것을 의마하기 때문에 출력하고 다음 테스트 케이스로 간다 */
				if(allMatch) {
					System.out.printf("#%d %d\n",testcase, patternLength);
					break;
				}
			}
		}
	}
}
