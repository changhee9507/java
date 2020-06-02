/**
 * 다트 게임
 * 
 * 메모: 항상 모든 범위에서 에러없이 실행될 수 있는 알고리즘인지 확인하는 과정이 필요하다. 문제에서 인풋 조건이 주어졌을때 극단적인 몇개의 예시는 반드시 만둘어서 실행시켜 보는 것이 
 * 		실제 테스트해서는 꼭 필요한 것 같다.
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

import java.util.Arrays;

public class Solution_L1_다트게임 {

	public static void main(String[] args) {

		String input = "1D2S#10S";
		System.out.println(solution(input));
	}

	public static int solution(String dartResult) {

		int[] scores = new int[3];

		int index = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') { /* 해당 문자가 숫자인 경우 */
				if(dartResult.charAt(i) == '1' && dartResult.charAt(i+1) == '0') {
					scores[index] = 10;
					i++;
				}else {
					scores[index] = dartResult.charAt(i) - '0';
				}
				index++;
			} else {
				switch (dartResult.charAt(i)) {
				case 'S': break;
				case 'D':
					scores[index - 1] = (int)Math.pow(scores[index - 1], 2); break;
				case 'T':
					scores[index - 1] = (int)Math.pow(scores[index - 1], 3); break;
				case '*':
					scores[index - 1] *= 2;
					if (index - 2 >= 0) {
						scores[index - 2] *= 2;
					}
					break;
				case '#':
					scores[index - 1] *= -1;
					break;
				}
			}
		}
		
		int result = 0;
		
		for(int i=0; i<3; i++) {
			result += scores[i];
		}
		
		System.out.println(Arrays.toString(scores));

		return result;
	}
}