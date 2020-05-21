package __101__permutationCombination;

import java.util.Arrays;

public class Swap {

	static int N, R, totalCount;
	static int[] numbers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numbers = new int[] { 1, 2, 3, 4 };
		N = numbers.length;
		R = 4;
		permutation(0);
		System.out.println("총 경우의 수 : " + totalCount);
	}
	
	private static void permutation(int index) {
		if(index == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i= index; i< N; i++) {
			swap(index, i);
			permutation(index+1);
			swap(index, i);
		}
	}
	
	private static void swap(int index1, int index2) {
		int temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}
}
