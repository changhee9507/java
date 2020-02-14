/**
 * 백준 17135 캐슬 디펜스 문제 풀이
 * 
 */

package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CastleDepense {

	static int rowSize;
	static int colSize;
	static int scope;
	static boolean[] used;
	static int[][] saveMap;
	static boolean[][] attackLocation;
	static int maxKill = 0;
	static Stack<boolean[]> archerLocations = new Stack<boolean[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		rowSize = scan.nextInt();
		colSize = scan.nextInt();
		scope = scan.nextInt();

		saveMap = new int[rowSize + 1][colSize];
		attackLocation = new boolean[rowSize][colSize];
		used = new boolean[colSize];

		/* 적 위치 정보 저장 */
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				int input = scan.nextInt();
				if (input == 1) {
					saveMap[i][j] = 1;
				}

			}
		}

		/* 궁수 3명을 배치 가능한 모든 경우의 수 구해서 스택에 저장 */
		combination(0, 0, 3);

		/* 조합 확인 */
		/*
		 * while(!archerLocations.isEmpty()) {
		 * System.out.println(Arrays.toString(archerLocations.pop())); }
		 */

		/* 조합 마다 */
		while (!archerLocations.isEmpty()) {
			/*System.out.println(" 새로운 조합 !!");*/
			int killCount = 0;
			/* 맵 표시 */
			int[][] map = new int[rowSize + 1][colSize];
			for (int i = 0; i < rowSize; i++) {
				for (int j = 0; j < colSize; j++) {
					map[i][j] = saveMap[i][j];
				}
			}

			/* 아처 맵에 표시 */
			boolean[] tmp = archerLocations.pop();
			for (int i = 0; i < colSize; i++) {
				if (tmp[i] == true) {
					map[rowSize][i] = 7;
				} else {
					map[rowSize][i] = 0;
				}
			}

			
			while (check(map)) {

				/* 확인용 맵 출력 */
				/*for (int i = 0; i < rowSize + 1; i++) {
					for (int j = 0; j < colSize; j++) {
						System.out.printf("%2s ", map[i][j]);
					}
					System.out.println();
				}
				System.out.println();*/

				/* 아처마다 공격 위치를 저장 */
				int[][] attackArray = new int[3][2];
				for (int i = 0; i < 3; i++) {
					Arrays.fill(attackArray[i], -1);
				}
				int archerCount = 0;

				for (int i = 0; i < colSize; i++) {
					if (map[rowSize][i] == 7) {

						int minDis = 99999;

						for (int col = 0; col < colSize; col++) {
							for (int row = 0; row < rowSize; row++) {
								if (map[row][col] == 0)
									continue;
								else {
									int curDis = rowSize - row + Math.abs(i - col);

									if (curDis <= scope && curDis < minDis) {
										minDis = curDis;
										attackArray[archerCount][0] = row;
										attackArray[archerCount][1] = col;
									}
								}
							}
						}

						archerCount++;

					}

				}
				
				/* 공격 위치 확인 */
				/*for(int i =0; i<3; i++) {
					System.out.println(Arrays.toString(attackArray[i]));
				}*/
				
				

				/* 공격 위치 확인해서 공격하고 카운트 */
				int attackRow = 0;
				int attackCol = 0;
				for (int i = 0; i < 3; i++) {
					attackRow = attackArray[i][0];
					attackCol = attackArray[i][1];

					if (attackRow < 0 || attackCol < 0) {
						continue;
					} else {
						if (map[attackRow][attackCol] > 0) {
							killCount++;
							map[attackRow][attackCol] = 0;
						}
					}
				}

				/* 확인용 맵 출력 */ 
				/*System.out.println(" 공격 이후 ");
				for (int i = 0; i < rowSize + 1; i++) {
					for (int j = 0; j < colSize; j++) {
						System.out.printf("%2s ", map[i][j]);
					}
					System.out.println();
				}
				System.out.println();*/

				/* 이동 */
				for(int i =0; i<colSize; i++) {
					map[rowSize-1][i] = 0;
				}
				
				for (int row = rowSize-1; row > 0; row--) {
					for (int col = 0; col < colSize; col++) {
						if (map[row-1][col] == 1) {
							map[row-1][col] = 0;
							map[row][col] = 1;
						}
					}
				}

				/* 확인용 맵 출력 */
				/*System.out.println(" 이동 이후 ");
				for (int i = 0; i < rowSize + 1; i++) {
					for (int j = 0; j < colSize; j++) {
						System.out.printf("%2s ", map[i][j]);
					}
					System.out.println();
				}
				System.out.println();*/

			}

			if (killCount > maxKill) {
				maxKill = killCount;
			}

		}

		System.out.println(maxKill);
	}

	static void combination(int index, int count, int choiceNum) {
		int newcount = count;
		int newindex = index;

		if (count == choiceNum) {
			archerLocations.push(Arrays.copyOf(used, used.length));
			return;
		}

		for (int i = index; i < colSize; i++) {
			if (used[i] == true)
				continue;
			used[i] = true;
			newindex++;
			newcount++;
			combination(newindex, newcount, choiceNum);
			used[i] = false;
			newcount--;
		}

	}

	static boolean check(int[][] map) {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (map[i][j] > 0) {
					/*System.out.println("True!!");*/
					return true;
				}

			}
		}
		return false;
	}
}
