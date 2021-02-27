/**
 * 
 * 
 * @author Changhee Yoon
 */
package Programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution_L1_제일작은수제거하기 {

	public static void main(String[] args) {

		int[] arr = { 9 , 5, 3 , 6 ,7};

		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		LinkedList<Integer> list = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		int minIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}

			list.addLast(arr[i]);
		}

		list.remove(minIndex);

		if (list.size() == 0) {
			return new int[] { -1 };
		} else {
			int[] answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}

	}
}