/*
 * 벌꿀 채취
 * 
 * 요약 : 벌꿀을 채취한다는 가정으로 배열의 주어진 조건속에서 최댓값을 찾아 출력
 * 
 * 메모 : 
 */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_SW_2115 {

	static int N, M, C; /* N은 배열 크기, M은 벌통 수, C는 채취 제한량 */
	static int[][] map; /* 벌통판 배열 */
	static int[][] maxRevenue; /* 얻을 수 있는 이익을 저장하는 배열 */

	static int localMax;
	static Stack<Integer> cmb = new Stack<Integer>();
	static boolean[] visited;
	static int[] tmp;
	static int totalMax;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= TESTCASE; testcase++) {

			/* 입력 저장 */
			String[] tmp = br.readLine().trim().split(" "); /* split은 String의 배열로 나눠서 리턴 */
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			C = Integer.parseInt(tmp[2]);

			totalMax = 0;
			map = new int[N][N];
			maxRevenue = new int[N][N];
			for (int i = 0; i < N; i++) {
				tmp = br.readLine().trim().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			/* 입력 확인 */
//			System.out.println(N + " " + M + " " + C);
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) { /* N과 M를 생각홰서 j값 설정 */
					maxRevenue[i][j] = getRevenue(i, j); /* 각 일꾼의 상황에서 얻을 수 있는 최대 이익을 저장해둔다. */
				}
			}

			/* 각 위치에서 최대 이익 결과 확인 */
//			System.out.println(N + " " + M + " " + C);
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(maxRevenue[i]));
//			}

			/* 최대 이익 들중 겹치지 않는 두개의 합이 최대가 되는 곳을 찾기 */
			
			getMax();
			
			System.out.printf("#%d %d\n", testcase, totalMax);
		}
	}

	public static int getRevenue(int row, int col) { /* 여기서 조합으로 모든 경우를 구해야 C안에 포함되는지 알수 있지 않을까? */

		localMax = 0;
		visited = new boolean[M];
		tmp = new int[M];
		/* */
		for (int i = 0; i < M; i++) {
			tmp[i] = map[row][col + i];
		}

//		System.out.println(Arrays.toString(tmp));

		/* 이 배열에서 조합을 구해서 최대값 저장 */
		combination(0, 0, 0);

		return localMax;
	}

	
	/* 모든 조합을 만들어서 주어진 범위에서 최대 수익을 계산한다 */
	public static void combination(int count, int startIndex, int sum) {
		if (sum > C) { /*이미 합을 넘었으므로 그냥 종료 */
			return;
		} else if (count < M) { 
			// System.out.println(cmb.toString());

			int localSum = 0;
			/* 해당 위치에서 수익 계산 */
			for (int i = 0; i < cmb.size(); i++) {
				localSum += Math.pow(cmb.get(i), 2);
			}

			if (localSum > localMax) {
				localMax = localSum;
			}

			/* 조합 생성 */
			for (int i = startIndex; i < tmp.length; i++) {
				if (visited[i] == true) {
					continue;
				} else {
					visited[i] = true;
					cmb.push(tmp[i]);
					combination(count + 1, startIndex + 1, sum + tmp[i]);
					cmb.pop();
					visited[i] = false;
				}
			}

		} else {
			// System.out.println(cmb.toString());

			int localSum = 0;
			/* 해당 위치에서 수익 계산 */
			for (int i = 0; i < cmb.size(); i++) {
				localSum += Math.pow(cmb.get(i), 2);
			}

			if (localSum > localMax) {
				localMax = localSum;
			}
		}

	}
	
	public static void getMax(){
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {

				for (int x = 0; x < N; x++) {
					if (x == i) { /* 같은 열에서는 열의 범위가 제한된다. */
						for (int y = j + M; y < N; y++) {
							if (y >= N) {
								break;
							}
							int sumOfTwo = maxRevenue[i][j] + maxRevenue[x][y];
							if (totalMax < sumOfTwo) {
								totalMax = sumOfTwo;
							}
						}
					}else { /* 다른 열에서는 열의 범위가 처음부터 끝으로 제한 없다. */
						for(int y = 0; y<N; y++) {
							
							if (y >= N) {
								break;
							}
							int sumOfTwo = maxRevenue[i][j] + maxRevenue[x][y];
							if (totalMax < sumOfTwo) {
								totalMax = sumOfTwo;
							}
							
						}
					}
				}

			}
		}
	}
}