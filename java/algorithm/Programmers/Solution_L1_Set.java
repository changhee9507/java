package Programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution_L1_Set {

	public static void main(String[] args) {
		
		int[] arr = {1,1,1,3,3,4,5,1,2,3,4,5,6,5};
		
		System.out.println(solution(arr));
	}

	public static int[] solution(int []arr) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		int pre = arr[0];
		list.addLast(pre);
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == pre) {
				continue;
			}else {
				list.addLast(arr[i]);
				pre = arr[i];
			}
		}
		
		int[] answer = new int[list.size()];
		int cnt = 0;
		while(!list.isEmpty()) {
			answer[cnt++] = list.removeFirst();
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
    }
}