package sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		int[] inputs = new int[13];
		
		for(int i = 0; i <inputs.length; i++) {
			inputs[i] = random.nextInt(100);
		}
		
		System.out.println(Arrays.toString(inputs));
		MergeSort(inputs);
	}
	
	public static void MergeSort() {
		
		
		
		
	}
}
