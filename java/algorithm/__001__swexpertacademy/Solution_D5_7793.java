/**
 * 오! 나의 여신님 *
 * 
 * 요약: 배열에서 상황 시뮬레이션
 * 
 * 메모:
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D5_7793 {

	private static int rowSize, colSize;
	private static char[][] map;
	private static Queue<Location> playerLoc, devilLoc; // 수연이
	private static boolean[][] visited;
	private static int minDepth;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());

		for (int test = 1; test <= TESTCASE; test++) {

			String[] tmp = br.readLine().split(" ");
			rowSize = Integer.parseInt(tmp[0]);
			colSize = Integer.parseInt(tmp[1]);

			map = new char[rowSize][colSize];
			visited = new boolean[rowSize][colSize];

			minDepth = Integer.MAX_VALUE;

			playerLoc = new LinkedList<Location>();
			devilLoc = new LinkedList<Location>();

			/* 인풋 저장 */
			for (int i = 0; i < rowSize; i++) {
				String input = br.readLine();
				for (int j = 0; j < colSize; j++) {
					map[i][j] = input.charAt(j);
					/* 플레이어 위치 저장 */
					if (map[i][j] == 'S') {
						visited[i][j] = true;
						playerLoc.add(new Location(i, j));
						/* 악마 위치 저장 */
					} else if (map[i][j] == '*') {
						devilLoc.add(new Location(i, j));
					}
				}
			}

			go();
			String result = (minDepth == Integer.MAX_VALUE) ? "GAME OVER" : String.valueOf(minDepth);
			System.out.printf("#%d %s\n", test, result);
		}
	}

	/* 상하좌우 */
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	private static void go() {
		int depth = 0;

		while (!playerLoc.isEmpty()) {
			

			/* 악마 스킬 사용 */
			devilSkill();
			depth++;

			/* 플레이어 이동 */
			int size = playerLoc.size();
			for(int i=0; i<size; i++) {
				// 수연이 이동
				Location player = playerLoc.poll();

				for (int d = 0; d < 4; d++) {
					int newRow = player.row + di[d];
					int newCol = player.col + dj[d];
					
					/* 범위 벗어나면 패스 */
					if (newRow < 0 || newRow >= rowSize || newCol < 0 || newCol >= colSize)
						continue;

					/* 이동 불가능하면 패스 */
					if (map[newRow][newCol] == 'X' || map[newRow][newCol] == '*')
						continue;

					/* 들렸던 곳이면 패스 */
					if (visited[newRow][newCol])
						continue;

					/* 여신에게 도착한 경우 종료 */
					if (map[newRow][newCol] == 'D') {
						minDepth = depth;
						return;
					}
				
					/* 이동했다면 새로운 위치를 저장하고 visit 갱신 */
					playerLoc.add(new Location(newRow, newCol));
					visited[newRow][newCol] = true;
				}

			}
			// result++;
		}
	}

	private static void devilSkill() {
		int size = devilLoc.size();
	
		/* 현재의 저장된 갯수만큼만 실행 */
		for(int i=0; i<size; i++) {
			
			Location devil = devilLoc.poll();
			for (int d = 0; d < 4; d++) {
				int newRow = devil.row + di[d];
				int newCol = devil.col + dj[d];
				
				/* 범위를 벗어나는 위치 생략 */
				if (newRow < 0 || newRow >= rowSize || newCol < 0 || newCol >= colSize) {
					continue;
				}else if(map[newRow][newCol] != '.' && map[newRow][newCol] != 'S') {
					continue;
				}

				map[newRow][newCol] = '*';
				devilLoc.add(new Location(newRow, newCol));
			}
			
		}
	}
}

class Location {
	int row, col;

	Location(int i, int j) {
		this.row = i;
		this.col = j;
	}
}