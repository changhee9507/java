/**
 * 숫자를 정려하자
 * 
 * 요약: 정수 정렬
 * 
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D2_1966 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int test=1; test<=TESTCASE; test++) {
			int numAmount = Integer.parseInt(br.readLine());
			
			int[] inputs = new int[numAmount];
			
			String[] tmp = br.readLine().split(" ");
			
			for(int i=0; i<numAmount; i++) {
				inputs[i] = Integer.parseInt(tmp[i]);
			}
			
			Arrays.sort(inputs);
			
			sb.append("#" + test + " ");
			for(int i=0; i<numAmount; i++) {
				sb.append(inputs[i] + " ");
			}
			sb.append("\n");
			
		}
		
		System.out.print(sb.toString());
	}

}
