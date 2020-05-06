package __005__subsideproblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Constellation {

	static boolean[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TESTCASE; test++) {
			/* 초기화 */
			cnt = 0;
			
			/* 맵 정보 입력 */
			map = new boolean[10][10];
			visited = new boolean[10][10];

			String[] tmp;
			for (int i = 0; i < 10; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 0; j < 10; j++) {
					if (tmp[j].equals("1")) {
						map[i][j] = true;
					}
				}
				
				//System.out.println(Arrays.toString(map[i]));
			}
			
			

			/* 전체 점에서 bfs */
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (visited[i][j]) {
						continue;
					} else {
						if (!map[i][j]) {
							visited[i][j] = true;
						} else {
							queue.offer(new int[] { i, j });
							cnt ++;
							bfs();
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", test, cnt);

		}

	}

	/* 북에서부터 시계 방향 델타 */
	static int[] dRow = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dCol = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static void bfs() {

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int n = 0; n < size; n++) {
				int[] loc = queue.poll();
				int row = loc[0];
				int col = loc[1];
				visited[row][col] = true;

				for (int i = 0; i < 8; i++) {
					int tmpRow = row + dRow[i];
					int tmpCol = col + dCol[i];
								
					if (tmpRow <0 || tmpCol <0 || tmpRow >= 10 || tmpCol >= 10 || visited[tmpRow][tmpCol]) {
						continue;
					} else {
						visited[tmpRow][tmpCol] = true;
						if (map[tmpRow][tmpCol]) {
							queue.offer(new int[] { tmpRow, tmpCol });
						}
					}

				}
			}
		}
	}

}
