package PermutationCombination;

import java.util.Arrays;

public class Recursive {
	static int N,R;
	static int[] numbers, pick;
	static int totalCount;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numbers = new int[] {1,2,3,4,5}; /* 주어진 숫자들 */
		N = numbers.length;
		R = 2;
		pick = new int[R];
		
		combination(0,0);
		
		System.out.println("총 경우의 수 : " + totalCount);
		
	}
	
	private static void combination(int index, int count) {
		if(count==R) {
			totalCount++;
			System.out.println(Arrays.toString(pick));
			return;
		}
		for(int i = index ; i < N ; i++) {
			pick[count] = numbers[i];
			combination(i+1, count+1);
		}
	}
}
