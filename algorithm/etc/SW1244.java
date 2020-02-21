package etc;

import java.util.Arrays;
import java.util.Scanner;

public class SW1244 {

	static char[] inputArr;
	static int max=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt();
		for(int testCase = 1; testCase <= TESTCASE; testCase++) {
			
			int input = scan.nextInt();
			int changeNum = scan.nextInt();
			/* 인풋을 배열에 저장 */
			inputArr = String.valueOf(input).toCharArray();
			exchange(0,changeNum);
		}
		
	}

	public static void exchange(int count,int changeNum) {
		if(inputArr.length == 1) {
			return inputArr[0] - '0'; 
		}
		
		for(int i=0; i<inputArr.length-1; i++) {
			for(int j=i+1; j<inputArr.length; j++) {
				char[] tmpArr = Arrays.copyOf(inputArr, inputArr.length);
				char tmp = tmpArr[i];
				tmpArr[i] = tmpArr[j];
				tmpArr[j] = tmp;
				
				int pow = 0;
				int num = 0;
				for(int k = tmpArr.length-1; k>=0; k--) {
					num += (tmpArr[k] - '0') * (int)Math.pow(10, pow);
					pow++;
				}
				
				if(num > max) {
					max = num;
				}
			}
		}
		
		inputArr = String.valueOf(max).toCharArray();
	}
}
