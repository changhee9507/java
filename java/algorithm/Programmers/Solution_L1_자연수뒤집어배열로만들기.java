/**
 * 자연수 뒤집어 배열로 만들기
 * 
 * 메모: 관련된 내장함수가 있다면 그것을 이용하는 것이 맞을 확률이 높다
 * 		데이터 구조 이용하다보면 특이 경우에서 오차가 자주 발생한다. 
 * 
 * @author Changhee Yoon
 */
package Programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution_L1_자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		int n = 12345;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(long n) {
		String input = String.valueOf(n);

		int[] answer = new int[input.length()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(input.substring(answer.length - 1 - i, answer.length - i));
		}

		return answer;
	}
}