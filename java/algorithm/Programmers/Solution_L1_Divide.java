/**
 * 나누어 떨어지는 숫자 배열 
 * 
 * 메모 : toArray의 함수는 int같은 타입을 사용할 수 없다 Integer같은 wrapper 클래스를 이용해야 한다. 왜냐면 각 원소를 클래스 객체로 보기 때문
 * 
 * @author Changhee Yoon
 */
package Programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution_L1_Divide {

	public static void main(String[] args) {
		
		int[] arr = {5,9,7,10};
		int divisor = 5;
		
		System.out.println(solution(arr, divisor));
	}

	public static int[] solution(int[] arr, int divisor) {
        
		int cnt = 0;
		Arrays.sort(arr);
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % divisor == 0) {
				list.addLast(arr[i]);
			}
		}
		
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return (answer.length == 0)? new int[]{-1} : answer;
    }
}