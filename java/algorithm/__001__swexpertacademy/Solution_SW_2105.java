/**
 * 디저트 카페
 * 
 * 요약: 주어진 배열속에서 규칙에 따라 움직일 수 있는 칸의 최댓값을 찾아 출력
 * 
 * 메모: visited나 움직인 횟수를 저장하는 배열 같은 것을 dfs방식으로 쓸 때는 더하는 것 뿐만아니라 빼는 경우도 같이 생각해줘야한다. 
 * 
 * 		떠올린 알고리즘이 정말 딱 그 경우만 해당하는 경우가 맞는지 다른 것도 포함되는 것은 아닌지 손으로 확인 하는 것이 중요하다
 * 
 * 		스택을 이용해서 과정속에서 쓰인 것을 확인 하면 디버깅에 유용하다
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_SW_2105 {

	static boolean[] visited;
	static int[][] map;
	static int mapSize;
	static int maxDepth;
	static Stack<String> path = new Stack<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());

		for (int testcase = 1; testcase <= TESTCASE; testcase++) {
			mapSize = Integer.parseInt(br.readLine().trim());
			map = new int[mapSize][mapSize];
			visited = new boolean[101];
			maxDepth = 0;
			/* 인풋 저장 */
			for (int i = 0; i < mapSize; i++) {
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < mapSize; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			/* 저장값 확인 */
//			for(int i=0; i<mapSize; i++) {
//				for(int j=0; j<mapSize; j++) {
//					System.out.printf("%3s", map[i][j]);
//				}
//				System.out.println();
//			}

			/* 각 위치마다 최대 경로 찾기 */
			for (int i = 0; i < mapSize; i++) {
				for (int j = 0; j < mapSize; j++) {
					// System.out.println("Starting at " + i + " " + j);
					for (int k = 0; k < 4; k++) {
						moveCount[k] = 0;
					}
					dfs(i, j, i, j, 0, 0);
				}
			}

			int result = (maxDepth == 0) ? -1 : maxDepth;
			System.out.printf("#%d %d\n", testcase, result);
		}

	}

	/* 좌하 우하 우상 좌상 */
	static public int[] dRow = { 1, 1, -1, -1 };
	static public int[] dCol = { -1, 1, 1, -1 };
	/* 움직였던 방향에 카운트 업 */
	static public int[] moveCount = new int[4];
	static public int[] direction = { 0, 1, 2, 3, 0 };

	static public void dfs(int row, int col, int startRow, int startCol, int depth, int preDirection) {

		if (row < 0 || row >= mapSize || col < 0 || col >= mapSize) {/* 맵 범위를 벋어나면 리턴 */
			return;
		} else if (depth != 0 && row == startRow && col == startCol) {/* depth가 0이 아니면서 처음으로 돌아온 경우 */

			/* 안 움직인 방향이 있다면 종료 */
			for (int i = 0; i < 4; i++) {
				if (moveCount[i] == 0) {
					return;
				}
			}

			/* 최댓값 갱신 */
			if (maxDepth < depth) { /* 최대 깊이를 확인하고 갱신 */
				maxDepth = depth;
			}

		} else if (visited[map[row][col]]) { /* 이미 들렸던 번호에 들어온 경우 */
			return;
		} else if (moveCount[2] > moveCount[0] || moveCount[3] > moveCount[1]) { /* 사각형 모양을 그리지 않는다면 종료 */
			return;
		} else { /* 다음의 경우를 찾기 */
			visited[map[row][col]] = true;

			for (int i = preDirection; i < preDirection + 2; i++) {
				moveCount[direction[i]]++;
				dfs(row + dRow[direction[i]], col + dCol[direction[i]], startRow, startCol, depth + 1, direction[i]);
				moveCount[direction[i]]--;
			}

			visited[map[row][col]] = false;

		}
	}

}
