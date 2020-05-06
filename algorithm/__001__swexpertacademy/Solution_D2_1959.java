/**
 * 두 개의 숫자열
 * 
 * 요약: 두 숫자열의 위치가 바뀌는데 곱의 최댓값 구하기 
 * 
 * 메모: 숫자배열을 스트링으로 담은 다음에 split을 하는 경우 +,-가 포함되어 있으면 split(구분자, 총 갯수)처럼 
 * 		총 갯수를 반드시 포함시켜줘야 원하는 결과를 얻을 수 있다.
 * 
 * @author Changhee Yoon 
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_1959 {

	static int[] inputFirst;
	static int[] inputSecond;
	static int max;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int TC = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TC; test++) {
			max = 0;

			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);

			inputFirst = new int[N];
			inputSecond = new int[M];

			tmp = br.readLine().split(" ", N);

			for (int i = 0; i < N; i++) {
				inputFirst[i] = Integer.parseInt(tmp[i]);
			}

			tmp = br.readLine().split(" ", M);

			for (int i = 0; i < M; i++) {
				inputSecond[i] = Integer.parseInt(tmp[i]);
			}

			if (N > M) {

				for (int i = 0; i <= N - M; i++) {
					int sum = 0;

					for (int j = 0; j < M; j++) {
						sum += inputFirst[j + i] * inputSecond[j];

					}

					if (max < sum) {
						max = sum;
					}
				}
			} else {

				for (int i = 0; i <= M - N; i++) {
					int sum = 0;

					for (int j = 0; j < N; j++) {
						sum += inputFirst[j] * inputSecond[j + i];

					}

					if (max < sum) {
						max = sum;
					}
				}
			}

			System.out.printf("#%d %d\n", test, max);

		}
	}

}
