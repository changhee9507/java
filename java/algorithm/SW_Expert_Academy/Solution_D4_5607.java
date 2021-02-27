/**
 * 조합 
 * 
 * 요약: 페르마의 정리를 이용한 조합의 나머지 구하기 
 */
package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_5607 {

	static int DIVIDER = 1234567891;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		for(int test=1; test<=TESTCASE; test++) {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int R = Integer.parseInt(tmp[1]);
			
			/* nCr = (n! / (n-r)! * r! ) */
			long A = 1; /* 분자 */
			long B = 1; /* 분모 */
			
			/* A */
			for(int i=N; i>N-R; i--) {
				A *= i;
				A %= DIVIDER;
			}
			
			
			/* B */
			for(int i=1; i<=R; i++) {
				B *= i;
				B %= DIVIDER;
			}
			
			B= fermatPow(B, DIVIDER-2);
			long result = (A * B) % DIVIDER;
			
			
			System.out.printf("#%d %d\n",test , result);
		}
		
		
	}

	static long fermatPow(long B, int repeat ) {
		 
		long result = 1;
		long tmp = B;
		
		while(repeat > 0) {
			if(repeat % 2 == 1) {
				result *= tmp;
				repeat--;
				result %= DIVIDER;
			}else {
				tmp *= tmp;
				tmp %= DIVIDER;
				repeat /= 2;
			}
			
		}
		
		return result;
	}
}
