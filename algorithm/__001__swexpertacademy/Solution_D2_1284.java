/**
 * 수도 요금 경쟁
 * 
 * 요약:
 * 
 * 메모: compare함수는 boolean이 아닌 정수 값을 리턴한다.
 * 
 * @author Changhee Yoon;
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1284 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TESTCASE; test++) {
			String[] tmp = br.readLine().split(" ");
			int P = Integer.parseInt(tmp[0]);
			int Q = Integer.parseInt(tmp[1]);
			int R = Integer.parseInt(tmp[2]);
			int S = Integer.parseInt(tmp[3]);
			int W = Integer.parseInt(tmp[4]);
			
			long totalCost_A = (long)W * (long)P;
			long totalCost_B = (W <= R)? Q : (long)(W - R) * (long)S + (long)Q;
			
			long result;
			if(Long.compare(totalCost_A, totalCost_B) >= 0) {
				result = totalCost_B;
			}else {				
				result = totalCost_A;
			}
			
			System.out.printf("#%d %s\n", test, String.valueOf(result));
			
		}
		
	}

}
