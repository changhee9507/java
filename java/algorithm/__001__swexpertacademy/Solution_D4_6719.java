/*
 * 성수의  프로그래밍 강좌 시청
 * 
 * 요약 : 수학적인 문제 상황 최적화
 * 
 * 
 * 
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_6719 {

	static int[] inputs;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TESTCASE; test++) {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);/* 인풋 갯수*/
			int K = Integer.parseInt(tmp[1]);/* 선택할 갯수*/
			
			inputs= new int[N];
			
			tmp = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				inputs[i] = Integer.parseInt(tmp[i]);
			}
			
			Arrays.sort(inputs);
			
			
			double result = 0;
			for(int i= N-K ; i<N; i++) {
				result = (result + inputs[i]) / 2;
			}
			
			System.out.printf("#%d %f\n", test, result);
		}
	}

}
