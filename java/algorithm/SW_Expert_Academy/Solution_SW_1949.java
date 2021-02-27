/**
 * 등산로 조성
 * 
 * @author Changhee Yoon
 */
package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_SW_1949 {

	static int N, K; /* N 맵 사이즈, K 공사 가능 깊이 */
	static int[][] map; /* 맵 */
	static boolean[][] visited; /* visit관리 */
	static LinkedList<int[]> peeks = new LinkedList<>(); /* 가장 높은 곳 저장 */
	static int max; /* 최대 높이 */
	static int max_length; /* 등산로 길이 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TC = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TC; test++) {
			/* 초기화 */
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			K = Integer.parseInt(tmp[1]);
			max = Integer.MIN_VALUE;
			max_length = Integer.MIN_VALUE;

			map = new int[N][N]; 

			for (int i = 0; i < N; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
					/* 값을 맵에 저장하면서 최대값을 저장해둔다. */
					if (max < map[i][j]) {
						max = map[i][j];
						peeks.clear();
						peeks.addLast(new int[] { i, j });
					} else if (max == map[i][j]) {
						peeks.addLast(new int[] { i, j });
					}
				}
				 //System.out.println(Arrays.toString(map[i]));
			}
			 //ystem.out.println();
			
			/* 하나씩 접근 */
			for (int[] peek : peeks) {
				//System.out.println(Arrays.toString(peek));
				visited = new boolean[N][N];
				visited[peek[0]][peek[1]] = true;
				simulation(peek[0], peek[1], 1, map[peek[0]][peek[1]],false);
			}
			
			System.out.printf("#%d %d\n",test, max_length);

			
		}

	}

	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = {0,0,-1,1};

	public static void simulation(int row, int col, int len, int height, boolean kUsed) {
		//System.out.println(">>>> [" + row + ", " + col + "] " + height + " " + kUsed + " " + len );
		
		/* 최대값 갱신 */
		if (max_length < len) {
			max_length = len;
		}
		
		/* */
		for(int i=0; i<4; i++) {
			int newRow = row + dRow[i];
			int newCol = col + dCol[i];
			
			if(newRow<0 || newCol <0 || newRow >= N || newCol >= N || visited[newRow][newCol]) {
				continue;
			}
			
			int requiredDepth = map[newRow][newCol] - height + 1;
			
			if(map[newRow][newCol] < height) {
				visited[newRow][newCol] = true;
				simulation(newRow, newCol, len+1, map[newRow][newCol] , kUsed);
				visited[newRow][newCol] = false;
			}else if(!kUsed && requiredDepth <= K) {
				visited[newRow][newCol] = true;
				simulation(newRow, newCol, len+1, height -1 ,true);
				visited[newRow][newCol] = false;
			}
		}

	}

}
