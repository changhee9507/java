/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.set4;

import java.util.Arrays;

public class Solution_p4 {

	static int[][] map;
	static int minCost = Integer.MAX_VALUE;
	static int[][] costs;

	public static int solution(int[][] board) {
		costs = new int[board.length][board.length];

		map = board;
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(costs[i], Integer.MAX_VALUE);
		}

		dfs(0, 0, -1, 0);

		return costs[board.length - 1][board.length - 1];
	}

	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	public static void dfs(int row, int col, int preDir, int cost) {
		// System.out.println(">> [" + row + ", " + col + "] " + cost);

		if (costs[row][col] >= cost) {
			costs[row][col] = cost;
		} else {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];

			if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map.length|| map[nextRow][nextCol] == 1) {
				continue;
			} else {
				if (preDir == -1) {
					dfs(nextRow, nextCol, i, cost + 100);
				} else {
					if (i == preDir) {
						dfs(nextRow, nextCol, i, cost + 100);
					} else {
						dfs(nextRow, nextCol, i, cost + 600);
					}
				}
			}
		}

	}
}