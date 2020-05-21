/**
 * 중간 평균값 구하기
 * 
 * 요약 : 가장 큰수와 작은 수를 제외한 나머지 들의 평균값을 출력
 * 
 *@author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D2_1984 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		for(int testcase=1; testcase<=TESTCASE; testcase++) {
			String[] tmp = br.readLine().split(" ");
			int[] inputs = new int[10];
			for(int i=0; i<10; i++) {
				inputs[i] = Integer.parseInt(tmp[i]);
			}
			
			//System.out.println(Arrays.toString(inputs));
			Arrays.sort(inputs);
			
			double sum = 0;
			for(int i=1; i<9; i++) {
				sum += inputs[i];
			}
			sum /= 8;
			int avg = (int)Math.round(sum);
			
			System.out.printf("#%d %d\n",testcase, avg);
		}
		
	}

}
