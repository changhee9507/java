/**
 * 벽돌깨기
 * 
 * 요약 : 배열에서 시뮬레이션
 * 
 * 메모 : 중복순열 
 * 
 * @author Changhee Yoon
 */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_SW_5656 {

	static int N, W, H; /* N 구슬사용 가능 횟수, W 맵의 가로 길이, H 맵의 세로 길이 */
	static int[][] map;
	static int[][] savedMap;
	static int[] locations; /* 구슬이 떨어질 위치의 중복 순열 */
	static Stack<BreakLocation> targets = new Stack<BreakLocation>();
	static int maxBreakCnt;
	static int breakCnt;
	static int brickCnt;
	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TESTCASE; test++) {
			String[] tmp = br.readLine().split(" ");

			N = Integer.parseInt(tmp[0]);
			W = Integer.parseInt(tmp[1]);
			H = Integer.parseInt(tmp[2]);

			map = new int[H][W];
			savedMap = new int[H][W];
			locations = new int[N];

			maxBreakCnt = Integer.MIN_VALUE;
			brickCnt = 0;
			
			/* 인풋 저장 및 확인 */
			for (int i = 0; i < H; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					savedMap[i][j] = Integer.parseInt(tmp[j]);
					
					if(savedMap[i][j] != 0) {
						brickCnt++;
					}
				}

				 //System.out.println(Arrays.toString(savedMap[i]) + " origin");
			}
			//System.out.println();
			
			simulation(0, 0);
			
			System.out.printf("#%d %d\n", test, brickCnt - maxBreakCnt);

		}

	}

	static void simulation(int count, int arrayIndex) {
		if (count == N) {
			
			breakCnt = 0;
			
			/* 맵 원상복귀 */
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = savedMap[i][j];
				}
			}
			
			for (int i = 0; i < N; i++) {
				
				breakbrick(i);
				drop();	
				
			}
			
			if(breakCnt > maxBreakCnt) {
				maxBreakCnt = breakCnt;
			}
			
		} else {
			/* 중복 순열을 생성 */
			for (int i = 0; i < W; i++) {
				locations[arrayIndex] = i;
				simulation(count + 1, arrayIndex + 1);
			}
		}
	}

	/* 상하좌우 델타 */
	static int[] dRow = { -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, -1, 1 };

	static void breakbrick(int index) {

			int tagetCol = locations[index];

			/* 해당 위치의 위에서 부터 구슬이 떨어질 곳을 차장서 tagets에 집어 넣는다. */
			for (int j = 0; j < H; j++) {
				if (map[j][tagetCol] != 0) {
					targets.push(new BreakLocation(j, tagetCol, map[j][tagetCol]));
					break;
				}
			}

			/* 자신의 위치를 0으로 만든이후 해당 영역 만큼 움직이면서 0은 그대로, 1이면 0으로, 1이상이면 targets에 저장 */
			while (!targets.isEmpty()) {
				BreakLocation bl = targets.pop();
				int row = bl.row;
				int col = bl.col;
				int scope = bl.scope;

				for (int d = 0; d < 4; d++) {
					for (int length = 0; length < scope; length++) {
						int newRow = row + (dRow[d] * length);
						int newCol = col + (dCol[d] * length);

						if (newRow < 0 || newCol < 0 || newRow >= H || newCol >= W) { /* 범위 벗어 났다면 break */
							break;
						} else {
							if(map[newRow][newCol] == 0) {
								continue;
							}else if(map[newRow][newCol] ==1 ) {
								map[newRow][newCol] = 0;
								breakCnt++;
							}else {
								targets.push(new BreakLocation(newRow, newCol, map[newRow][newCol]));
								map[newRow][newCol] = 0;
								breakCnt++;
							}
						}

					}
				}

			}

		
	}

	static void drop() {
		
		for(int i=0; i<W; i++) {
			for(int j=H-1; j>0; j--) {
				if(map[j][i] == 0) {
					int tmpJ = j;
					
					boolean reachEnd = false;
					while(tmpJ >= 0 && map[tmpJ][i] == 0) {
						if(tmpJ == 0) {
							reachEnd = true;
							break;
						}
						tmpJ--;
					}
					if(reachEnd) {
						break;
					}else {
						map[j][i] = map[tmpJ][i];
						map[tmpJ][i] = 0;
					}
					
				}
			}
		}
	}
}

class BreakLocation {
	int row;
	int col;
	int scope;

	BreakLocation(int r, int c, int s) {
		this.row = r;
		this.col = c;
		this.scope = s;
	}
}
