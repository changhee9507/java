/**
 * 현 순열의 사전적으로 다음단계 순열 생성 (가장 작은 순열을 초기조건으로 줘야한다)
 * 같은 수가 있어도 중복 순열이 없다.
 * 
 * 목표:가장 큰 순열 생성
 * 	1) 교환이 필요한 위치 (i-1)찾기
 *  2) 교환대상 찾기
 *  3) i-1위치값과 j위치값 교환
 *  
 */

package __101__permutationCombination;

import java.util.Arrays;

public class NextPermuation {

	static int totalCount;
	public static void main(String[] args) {
		
		int[] numbers = {1,2,3,4}; // 모르는 상황에서는 sort 돌린다.
		int[] pick = new int[numbers.length]; // 뽑는 숫자만큼 길이 지정
		pick[2] = pick[3] = 1; // {0,0,1,1}
		
		do {
			for(int i=0; i<pick.length; i++) {
				if(pick[i] == 1) System.out.print(numbers[i] + " ");
			}
			System.out.println();
		}while(np(pick));
		
		System.out.println(totalCount);
	}
	
	private static boolean np(int[] p) { /* next permutation */
		totalCount++;
		int N = p.length;
		int i = N-1;  
		while(i>0 && p[i-1]>=p[i]) --i; // 교환이 필요한 i-1위치 찾기
		if(i==0) return false; // 이미 가장 큰 순열이므로 다음순열 생성 불가
		
		/*j 위치 찾기*/
		int j = N -1;
		while(p[i-1] >= p[j]) --j;
		
		/* 교환 */
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		/* 오름차순 형태로 재조정 */
		int k = N - 1;
		while(i<k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++;
			k--;
		}
		
		return true; /* 순열을 만들수 있으면 true */
	}
}
