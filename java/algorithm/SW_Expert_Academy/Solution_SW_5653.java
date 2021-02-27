/**
 * 줄기세포배양
 * 
 * 메모: 세포 배양이 생명력이 높은것 부터 이루어진다고 했기 때문에 비교하기 보다는
 * 		실행순서를 애초에 생명력이 높은 것 순으로 정리해두고 실행시키는 것이 쉬울 수 있다.
 * 
 * 		new를 이용해서 초기화하는 것이 안전하다
 * 
 * @author Changhee Yoon 
 */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution_SW_5653 {

	static int N, M, K; /* 세로크기, 가로크기, 시간 */
	static int[][] map;; /* 800 * 800 -> 50 * 50 에다가 매초마다 옆으로 퍼진다고 생각하면 최소한 한변당 600이 커지므로 안전하게 800 설정 */
	static LinkedList<Cell>[] cells; /* 리스트의 배열, 생명력의 레벨 마다 담아서 우선순위를 반영할 수 있게 해준다. */
	static int cellCnt; /* 죽지 않은 세포의 수를 카운트 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TC = Integer.parseInt(br.readLine().trim());
		String[] tmp;

		for (int test = 1; test <= TC; test++) {
			/* 인풋 저장 */
			tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			K = Integer.parseInt(tmp[2]);

//			System.out.println(N + " " + M + " " + K + " " + cellCnt);

			/* 초기화 */
			map = new int[800][800]; /* 0으로 채우는 것보다 새로 만들어버리는 new가 안전한 초기화 */
			cellCnt = 0;
			cells = new LinkedList[11]; /* new로 안전한 초기화 */
			for (int i = 0; i < 11; i++) {
				cells[i] = new LinkedList<Cell>(); /* 각 리스트들의 객체를 만들어준다. */
			}

			/* 인풋 저장 */
			for (int i = 0; i < N; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					int vital = Integer.parseInt(tmp[j]);
					if (vital == 0) {
						continue;
					}
					map[i + 325][j + 325] = vital; /* (800 - 50) / 2 = 325 중간으로 보내준다.  */
					cellCnt++;
					cells[vital].addLast(new Cell(i + 325, j + 325, vital));
				}
			}

			//System.out.println("cnt " + cellCnt);
			
//			System.out.println(">>" + cellCnt);
//			for(int i=1; i<10; i++) {
//				System.out.println(cells[i].toString());
//			}

//			for(int i=0; i<200; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

			for (int k = 0; k < K; k++) { /* k번 반복*/
				for (int i = 10; i >= 1; i--) { /* 생명력이 큰 순서대로 접근*/
					int presentCellNum = cells[i].size();
					for (int j = 0; j < presentCellNum; j++) { /* 시뮬레이션 */
						cells[i].get(j).simulation();
					}

					int cnt = 0;
					while (cnt < cells[i].size()) { /* 죽은 세포는 삭제 */
						if (cells[i].get(cnt).died) {
							cells[i].remove(cnt);
						} else {
							cnt++;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", test, cellCnt);
		}

	}

	
	/* 델타 */
	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	static class Cell {

		/* 인위적인 멤버변수는 계산실수를 가져오고 복잡하게 만든다. 주어진 조건을 그대로 반영해서
		 * 직관적으로 이해되고 자연스러운 방식으로 설정한다. */
		int row;
		int col;
		int time;
		final int VITAL;
		boolean activated;
		boolean reproduced;
		boolean died;

		public Cell(int row, int col, int VITAL) {
			this.row = row;
			this.col = col;
			this.VITAL = VITAL;
		}

		
		/* 시간마다의 행동 문제의 경우 시간마다의 '결과'를 기준으로 코드를 짜면 된다. */
		public void simulation() {
			time++;
			if (time < VITAL) {
				return;
			} else {
				if (time == VITAL && !activated) {
					activated = true;
				} else {
					if (activated && !reproduced) {
						reproduce();
						reproduced = true;
					}
					if (!died && time == VITAL * 2) {
						died = true;
						cellCnt--;
					}
				}

			}

		}

		/* 델타를 이용한 4방향 접근 이후 조건에 해당하면 복제 */
		public void reproduce() {

			for (int i = 0; i < 4; i++) {
				int newRow = row + dRow[i];
				int newCol = col + dCol[i];

				if (newRow >= 0 && newRow < 800 && newCol >= 0 && newCol < 800 && map[newRow][newCol] == 0) {
					cellCnt++;
					map[newRow][newCol] = VITAL;
					cells[VITAL].addLast(new Cell(newRow, newCol, VITAL));
				}
			}
		}

		@Override
		public String toString() {
			return "Cell [row=" + row + ", col=" + col + ", VITAL=" + VITAL + "]";
		}

	}
}
