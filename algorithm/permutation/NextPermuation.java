/**
 * 현 순열의 사전적으로 바로 다음단계 순열 생성 (가장 작은 순열을 초기조건으로 줘야한다)
 * 같은 수가 있어도 중복 순열이 없다.
 * 
 * 목표:가장 큰 순열 생성
 * 	1) 교환이 필요한 위치 (i-1)찾기
 *  2) 교환대상 찾기
 *  3) i-1위치값과 j위치값 교환
 *  
 */

package permutation;

import java.util.Arrays;

public class NextPermuation {

	static int totalCount;
	public static void main(String[] args) {
		
		int[] numbers = {1,2,3,4}; // 모르는 상황에서는 sort 돌린다.
		do {
			System.out.println(Arrays.toString(numbers));
		}while(np(numbers)); // np가  
		
		System.out.println(totalCount);
	}
	
	
	private static boolean np(int[] p) { /* next permutation */
		totalCount++;
		int N = p.length;
		
		int i = N-1;  
		while(i>0 && p[i-1]>=p[i]) --i; /* i의 위치는 가장 오른쪽에서부터 왼쪽보다 작으면 옆으로 간다 */
		System.out.println("i : " + i);
		if(i==0) return false; /*가장 왼쪽부터 큰 숫자로 정렬된 상태 */
		
		
		int j = N -1;/* 맨뒤에서 부터 */
		while(p[i-1] >= p[j]) --j; /* j는 i의 옆보다 크도록(작으면 바꾼다.) */
		System.out.println("j : " + j);
		
		/* 교환 - 왼쪽이 오른쪽보다 작은 첫 위치를 잡아두고 오른쪽부터 오면서 오른쪽의 j위치가 더 작으면 스왑 */ 
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		/* 오름차순 형태로 재조정 */
		int k = N - 1;
		
		
		while(i<k) {
			System.out.println("k : " + k);
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++;
			k--;
		}	
		return true; /* 순열을 만들수 있으면 true */
	}
	
}
