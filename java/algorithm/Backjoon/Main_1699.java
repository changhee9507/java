/**
 * 제곱수의 합
 * 
 * @author Changhee Yoon
 */

package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1699 {

	static long min;
	static long[] minSquare;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		min = Integer.MAX_VALUE;
		int input = Integer.parseInt(br.readLine());
		
		
		minSquare = new long[input+1];
		
		for(int i=1; i<input+1; i++) {
			minSquare[i] = i;
		}
		for(int i=2; i<input+1; i++) {
			for(int j=0; j*j <= i; j++) {
				minSquare[i] = Math.min(minSquare[i], minSquare[i - j*j] + 1);
			}
		}
		
		System.out.println(minSquare[input]);
	}

}
