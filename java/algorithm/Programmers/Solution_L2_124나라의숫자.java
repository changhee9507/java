/**
 * 124나라의 숫자
 * 
 * 메모: 엑셀 등을 이용해서 문제 상황을 제대로 이해하는 것이 수학적인 알고리즘 문제의 핵심
 * 
 * @author Changhee Yoon
 */
package Programmers;

import java.util.LinkedList;

public class Solution_L2_124나라의숫자 {

	public static void main(String[] args) {

		int n = 13;
		System.out.println(solution(n));
	}

	public static String solution(int n) {

		LinkedList<Integer> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		while (n != 0) {
			switch (n % 3) {
			case 1: list.addFirst(1); break;
			case 2: list.addFirst(2); break;
			case 0:
				list.addFirst(4);
				n--;
				break;
			}
			
			n /= 3;
		}

		System.out.println(list);

		for (int i : list) {
			sb.append(i);
		}

		return sb.toString();
	}
}