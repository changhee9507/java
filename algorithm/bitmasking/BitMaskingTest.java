/**
 * selected라는 숫자를 boolean visited 배열 대용으로 사용
 * 
 * 
 */

package bitmasking;

import java.util.Arrays;

public class BitMaskingTest {

	static int N,R;
	static int[] numbers, pick;
	static int totalCount;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numbers = new int[] {1,2,3,4}; /* 주어진 숫자들 */
		N = numbers.length; /* 주어진 숫자의 수 */
		R = 3; /* 뽑는 숫자 */
		pick = new int[R];
		permutation(0,0); /* 순열을 생성해서 pick에 저장*/
		System.out.println("총 경우의 수 : " + totalCount);
	}
	
	
	private static void permutation(int index, int selected) {
		if(index == R) {
			totalCount++;
			System.out.println(Arrays.toString(pick));
			return;
		}
		
		for(int i =0; i< N; i++) {
			if((selected & 1<<i) == 0)
			pick[index] = numbers[i];
			permutation(index+1, selected | 1<<i);
		
		}
		
		
	}

}
