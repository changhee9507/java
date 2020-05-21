package __002__baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2468 {

	static int N;
	static int[][] map;
	static boolean[][] flooded;
	static int max = Integer.MIN_VALUE;
	static int maxHeight = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		flooded = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
			//System.out.println(Arrays.toString(map[i]));
		}

		for (int height = 0; height <= maxHeight; height++) {

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= height) {
						flooded[i][j] = true; /* 잠긴곳은 true*/
					} else {
						flooded[i][j] = false;
					}
				}
			}

			simulation();
		}
		
		System.out.println(max);

	}

	static void simulation() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!flooded[i][j]) {
					cnt++;					
					dfs(i, j);
				}
			}
		}
		
		//System.out.println("area count :" + cnt);
		
		if(cnt > max) {
			max = cnt;
		}
	}

	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	static void dfs(int row, int col) {
		flooded[row][col] = true;
		
		for(int i=0; i<4; i++) {
			
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			
			if(nextRow >=0 && nextRow < N && nextCol >= 0 && nextCol < N) {
				if(!flooded[nextRow][nextCol]) {
					dfs(nextRow, nextCol);
				}
			}
		}
	}
}
