package PermutationCombination;

import java.util.Arrays;

public class Com {
	
	/* nCr */
	static int N; /* 총 갯수 */ 
	static int R; /* 선택 할 갯수 */
	
	static int[] numbers; /* 뽑을 숫자들이 담긴 배열 */
	static int[] pick; /* 뽑힌 숫자들을 담는 배열 */
	static int totalCount; /* 조합 경우의 수 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numbers = new int[] {1,2,3,4,5}; /* 주어진 숫자들 */
		N = numbers.length;
		R = 2;
		pick = new int[R];
		
		combination(N,R);
		
		System.out.println("총 경우의 수 : " + totalCount);
	}

	/* 뒤에서부터 뽑을 지 안 뽑을지 고르고 뒤로 넘기는 방식 */
	private static void combination(int n, int r) {
		if(r==0) { /* r은 뽑을 때마다 감소하기 때문에 0이면 필요한 수 만큼 뽑았음을 의미 */
			totalCount++; 
			System.out.println(Arrays.toString(pick));
			return;
		}
		
		if(n<r) return; /* 계속 뽑지않고 다음으로 넘어가다가 발생되고 n<r이 되는 경우는 없애야 한다. */
	
		pick[r-1] = numbers[n-1]; // 뒤에서 부터 뽑아서 넣는다.
		combination(n-1, r-1); // r-1을 리턴하기 때문에 지금 현재 r-1자리는 뽑아진 것을 의미
		combination(n-1, r); // r을 그대로 리턴하기 때문에 다음 함수에서 r-1자리를 다시 뽑는다(뽑아지지 않음을 의미)
	}
}
