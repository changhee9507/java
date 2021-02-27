/**
 * visited배열과 재귀를 이용한 순열과 조합
 * 
 * 메모 : 
 * 	순열은 몇개가 선택되었는지 확인하는 count와 선택 갯수 R을 매개 변수로 준다.
 * 	조합은 순열에서 시작 인덱스를 추가해서 i의 범위를 축소시킨다.
 * 
 * 
 * 
 * @author Changhee Yoon
 */

package PermutationCombination;

import java.util.Stack;

public class VisitedArray {

	public static int cnt;
	public static boolean[] visited = new boolean[6]; /* 해당 인덱스의 input이 사용되었는지 체크하는 배열*/ 
	public static Stack<Character> result = new Stack<Character>();	
	public static char[] input;
	
	 public static void main(String[] args) {
	 
		 input = new char[]{'A', 'B','C', 'D', 'E', 'F'};
		 
		 int N = input.length;
		 int R = 3; /* 2개를 뽑아서 순열을 만든다 */
		 
		 //permutation(0,R);
		 combination(0,0,R);
		 
		 System.out.println("Cnt : " + cnt);
	}

	 public static void permutation(int count, int R) {
		 if(count == R) { /* 원하는 만큼 뽑았기 때문에 출력하는 기저조건*/
			 System.out.println(result.toString()); /* 자료 구조의 */
		 }else {
			 for(int i=0; i<input.length; i++) {
				 if(visited[i] == true) { /* 이미 쓰였다면 넘어간다 */
					 continue;
				 }else {
					 visited[i] = true; /* 이제 쓸 것이기 때문에 true를 만들어준다.*/
					 result.push(input[i]); /* */
					 permutation(count+1,R);
					 visited[i] = false;
					 result.pop();
				 }
			 }		 
		 }
	 }
	 
	public static void combination(int count, int startIndex, int R) {
	
		if(count == R) { /* 원하는 만큼 뽑았기 때문에 출력하는 기저조건*/
			 System.out.println(result.toString()); /* 자료 구조의 */
		 }else {
			 for(int i=startIndex; i<input.length; i++) {
					 result.push(input[i]); /* */
					 combination(count+1, i+1, R);
					 result.pop();
			 }		 
		 }
	}
}
