/**
 * 가장 간단한 형태의 조합
 * 
 * @author Changhee Yoon
 */

package __101__permutationCombination;

import java.util.Arrays;
import java.util.Stack;

public class Combination__Simple {
	
	static int N; /* 총 숫자 */
	static int R; /* 뽑는 숫자 */
	static int[] combinationResult; /* 조합의 결과가 담기는 배열 */
	static int cnt; /* 연산 횟수 */
	
	public static void main(String[] args) {
		
		 N = 7; /* 0부터 6까지 총 7개에서 뽑는다고 가정 */
		 R = 3; /* 2개를 뽑아서 순열을 만든다 */
		 combinationResult = new int[R];
		 
		 combination(0,0);
		 System.out.println("함수 실행 횟수 : " + cnt);
	}
	
	public static void combination(int count, int startIndex) {
		cnt++;
		
		if(count == R) { /* 원하는 만큼 뽑았기 때문에 출력하는 기저조건*/
			 System.out.println(Arrays.toString(combinationResult)); /* 출력 */
		 }else {
			 for(int i=startIndex; i<= N-R+count; i++) { /* i는 뽑히는 것을 의미한다 */
				 combinationResult[count] = i;
				 combination(count+1, i+1);
			 }		 
		 }
	}
}
