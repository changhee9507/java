/**
 * 추억의 2048게임
 * 
 * @author Changhee Yoon
 */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_6109 {

	static int mapSize;
	static String direction;
	static int[][] map;
	static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TC = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TC; test++) {
			/* 인풋 저장 */
			String[] tmp = br.readLine().split(" ");

			mapSize = Integer.parseInt(tmp[0]);
			direction = tmp[1];

			map = new int[mapSize][mapSize];
			checked = new boolean[mapSize][mapSize];
			
			for (int i = 0; i < mapSize; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 0; j < mapSize; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			
			/* 시뮬레이션 */
			simulation(direction);
			
			
			System.out.printf("#%d\n", test);
			/*확인*/
			for(int i=0; i<mapSize; i++) {
				for(int j=0; j<mapSize; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}

	/* 상하좌우 */
	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	public static void simulation(String dir) {

		/* 방향에 따라서 처리 순서가 빠뀌기 때문에 switch로 방향에 따라서 다르게 움직인다. */
		switch (dir) {
		case "up":
			for (int row = 1; row < mapSize; row++) {
				for (int col = 0; col < mapSize; col++) {
					if (map[row][col] == 0) {
						continue;
					}
					move(row, col, 0);
				}
			}
			break;
		case "down":
			for (int row = mapSize - 1; row >= 0; row--) {
				for (int col = 0; col < mapSize; col++) {
					if (map[row][col] == 0) {
						continue;
					}
					move(row, col, 1);
				}
			}
			break;
		case "left":
			for (int col = 1; col < mapSize; col++) {
				for (int row = 0; row < mapSize; row++) {
					if (map[row][col] == 0) {
						continue;
					}
					move(row, col, 2);
				}
			}
			break;
		case "right":
			for (int col = mapSize - 1; col >= 0; col--) {
				for (int row = 0; row < mapSize; row++) {
					if (map[row][col] == 0) {
						continue;
					}
					move(row, col, 3);
					;
				}
			}
			break;
		}

	}

	/* 델타를 이용해서 일반화된 움직임을 가지도록 코딩한다. */
	/* check를 이용해서 한번 합쳐진 곳은 더이상 합쳐지 않도록 만든다. */
	public static void move(int row, int col, int delta) {

		while (row + dRow[delta] >= 0 && row + dRow[delta] < mapSize && col + dCol[delta] >= 0 && col + dCol[delta] < mapSize) {
			if(checked[row + dRow[delta]][col + dCol[delta]]) {
				return;
			}
			if (map[row][col] == map[row + dRow[delta]][col + dCol[delta]]) {
				map[row + dRow[delta]][col + dCol[delta]] *= 2;
				checked[row + dRow[delta]][col + dCol[delta]] = true;
				map[row][col] = 0;
				break;
			} else if (map[row + dRow[delta]][col + dCol[delta]] == 0) {
				map[row + dRow[delta]][col + dCol[delta]] = map[row][col];
				map[row][col] = 0;
				row = row + dRow[delta];
				col = col + dCol[delta];
			} else {
				break;
			}
		}
	}
}
