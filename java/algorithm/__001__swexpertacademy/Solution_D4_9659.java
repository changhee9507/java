/**
 * 다항식 계산 
 * 
 * 요약: 조건에 따라 다르게 주어지는 다항식의 값 계산하여 출력
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_9659 {

	static polynomial[] polynomials;
	static long[] values;
	static int N,M;
	static long DIVIDER = 998244353;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int TESTCASE = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TESTCASE; test++) {
			N = Integer.parseInt(br.readLine());
			polynomials = new polynomial[N+1];
			
			
			for (int i = 2; i <= N; i++) {
				String[] tmp = br.readLine().split(" ");
				int t = Integer.parseInt(tmp[0]);
				int a = Integer.parseInt(tmp[1]);
				int b = Integer.parseInt(tmp[2]);

				polynomials[i] = new polynomial(t, a, b);
			}
			
			
			M = Integer.parseInt(br.readLine());
			values = new long[M];
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<M; i++) {	
				long x = Long.parseLong(tmp[i]);
				values[i] = calculate(x);
			}
			
			sb.append("#" + test + " ");
			for(int i=0; i<M; i++) {
				sb.append(values[i] );
				
				if(i != M-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
	
	static long calculate(long x) {
		double[] tmpValues = new double[N+1];
		
		for(int i=0; i<=N; i++) {
			if(i == 0) {
				tmpValues[i] = 1;
			}else if(i == 1) {
				tmpValues[i] = x;
			}else {
				switch(polynomials[i].t) {
				case 1: tmpValues[i] = tmpValues[polynomials[i].a] + tmpValues[polynomials[i].b]; break;
				case 2: tmpValues[i] = polynomials[i].a *  tmpValues[polynomials[i].b]; break;
				case 3: tmpValues[i] = tmpValues[polynomials[i].a] * tmpValues[polynomials[i].b]; break;
				}
			}
		}
		
		return (long)(tmpValues[N] % DIVIDER);
	}
	
}

class polynomial {
	int t;
	int a;
	int b;
	
	polynomial(int t, int a, int b) {
		this.t = t;
		this.a = a;
		this.b = b;
	}
}