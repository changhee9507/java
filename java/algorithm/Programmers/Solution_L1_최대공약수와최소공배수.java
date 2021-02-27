/**
 * 최대공약수와 최소공배수
 * 
 * 메모: for이 종료될때 마지막 조건 i++이 실행되기 때문에 i를 조절할때는 이것을 고려해야 된다. 
 * 
 * @author Changhee Yoon
 */
package Programmers;

import java.util.LinkedList;

public class Solution_L1_최대공약수와최소공배수 {

	public static void main(String[] args) {

		int n = 16;
		int m = 20;

		System.out.println(solution(n, m));
	}

	public static int[] solution(int n, int m) {
		int first = (n <= m) ? n : m;
		int second = (n <= m) ? m : n;

		LinkedList<Integer> dividers = new LinkedList<>();

		for (int i = 1; i <= first; i++) {
			System.out.println("i " + i);
			if (first % i == 0 && second % i == 0) {
				dividers.addLast(i);
				first /= i;
				second /= i;
				i = 1;
			}
		}

		// System.out.println(dividers.toString());
		// System.out.println("first " + first + " second " + second);

		int GCD = 1;
		int LCM = 1;

		while (!dividers.isEmpty()) {
			GCD *= dividers.removeFirst();
		}

		LCM = GCD * first * second;

		int[] answer = { GCD, LCM };
		return answer;
	}
}