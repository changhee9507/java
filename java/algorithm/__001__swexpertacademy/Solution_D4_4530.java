package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4530 {
	
	static long result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= TESTCASE; test++) {
			String[] tmp = br.readLine().split(" ");
			
			long A = Long.parseLong(tmp[0]); /* 시작 층*/
			long B = Long.parseLong(tmp[1]); /* 끝 층 */

			if ((A > 0 && B > 0) || (A < 0 && B < 0)) { /* AB가 같은 지하나 지상인 경우 */
				 result = Math.abs(calculate(A) - calculate(B));
			} else { /* A B가 지상 지하로 나눠진 경우  (0층을 제외 시키기 위해 )*/
				result = calculate(A) + calculate(B) - 1;
			}
			
			System.out.printf("#%d %d\n", test, result);
		}
		
	}

	/* 몇층인지 계산 */
	static long calculate(long floor) {
		/* 음수이면 반전 */
		if (floor < 0) {
			floor = -floor;
		}
	
		long temp = floor;
		long sum = 0;
		
		/* 자릿수 계산 */
		int N = 0; /* 자릿수 */
		while (temp != 0) {
			temp = temp / 10;
			N++;
		}
		
		while (N != 0) {
			long x = (long) (floor / Math.pow(10, N - 1)); /* 가장 큰 자릿 수 */
			floor = (long) (floor % Math.pow(10, N - 1)); /* 가장 큰 자릿 수 제거 */
			
			if (x > 4) { /* 4보다 크다면 1개를 제외 시킨다음 9진수로 생각해서 계산 */
				sum += (x - 1) * Math.pow(9, N - 1);
			} else { /* 4보다작다면 그냥 9진수로 생각해서 계산 */
				sum += x * Math.pow(9, N - 1);
			}
			N--;
		}
		return sum;
	}
}
