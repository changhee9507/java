/**
 * 달팽이 숫자
 * 
 * @author Changhee Yoon
 */
package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1954 {

	static int[][] map;
	static int size;
	static int cnt = 1;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TESTCASE; test++) {
			size = Integer.parseInt(br.readLine());

			if (size == 1) {
				System.out.printf("#%d\n1\n", test);
				continue;
			} else {

				map = new int[size][size];
				cnt = 1;

				fillOut(0, 0, 0);

				System.out.printf("#%d\n", test);
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
			}
		}

	}

	/* 우, 하, 좌, 상 */
	static int[] dRow = { 0, 1, 0, -1 };
	static int[] dCol = { 1, 0, -1, 0 };

	static void fillOut(int row, int col, int dir) {

		if (map[row][col] != 0) {
			return;
		}

		map[row][col] = cnt;
		cnt++;

		int nextRow = row + dRow[dir];
		int nextCol = col + dCol[dir];
		int nextDir = (dir + 1) % 4;

		if (nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size) {
			fillOut(row + dRow[nextDir], col + dCol[nextDir], nextDir);
		} else if (map[nextRow][nextCol] != 0) {
			fillOut(row + dRow[nextDir], col + dCol[nextDir], nextDir);
		} else {
			fillOut(row + dRow[dir], col + dCol[dir], dir);
		}
	}

}
