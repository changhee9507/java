package PermutationCombination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW1244 {

	static char[] input;
	static int inputLength;
	static int changeNum;
	static int max;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt();
		for(int testCase=1; testCase <= TESTCASE; testCase++) {
			
			input = String.valueOf(scan.nextInt()).toCharArray();
			inputLength = input.length;
			max = 0;
			changeNum = scan.nextInt();
			//System.out.println(changeNum);
			int preNum = charArrToInt();
			permutation(0, preNum);
			System.out.println("#"+testCase + " " + max);
		}		
	}
	
	/* */
	private static int charArrToInt() {
		int num = 0;
		int pow = 0;
		for(int i=inputLength-1; i>= 0; i--) {
			num += (input[i] - '0') * (int)Math.pow(10, pow++); 
		}
		
		return num; 
	}
	
	private static void permutation(int count, int preNum) {
		//System.out.println(count + " " + Arrays.toString(input));
		
		if(count == changeNum) {
			int num = charArrToInt();
			if(num > max) {
				max = num;
			}
			return;
		}
		
		
		for(int i = 0; i<inputLength-1; i++) {
			int jMax = -1;
			int preI = i;
			int indexLength = 0;
			
			Queue<Integer> indexs = new LinkedList<Integer>();
			
			/* 바꿀 후보를 큐에 집어 넣는다 */
			for(int j = preI+1; j<inputLength; j++) {
				/* j중에 i보다 큰 숫자가 있다면 다음 i는 돌 필요가 없다*/
				if(input[preI] < input[j]) {
					i = inputLength;
				}
				
				if(input[j] > jMax) {
					indexs.clear();
					jMax = input[j];
					indexs.offer(j);
					
				}else if(input[j] == jMax) {
					indexs.offer(j);
					
				}
				
				indexLength = indexs.size();
				
				/* swap 넣어진 숫자만큼 스왑해서 permutation */
				for(int k = 0; k < indexLength; k++) {
					//System.out.println("k " + k);
					int swapIndex = indexs.poll();
					swap(preI, swapIndex);
					permutation(count+1, charArrToInt());
					swap(preI, swapIndex);
				}
				
			}
		}	
	}
	
	private static void swap(int index1, int index2) {
		char temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
}
