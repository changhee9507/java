/**
 * swexpertacademy 1258 문제 풀이
 * 
 * 
 */

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MatrixFinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		final int TESTCASE = scanner.nextInt();

		for (int tc = 1; tc <= TESTCASE; tc++) {

			int size = scanner.nextInt();
			ArrayList<int[]> arrayList = new ArrayList<>();
			int[][] map = new int[size][size];
			int subNum = 0;

			/* 인풋저장 */
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[i][j] = scanner.nextInt();
				}
			}

			/* 맵 확인 */

			/*for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}*/

			/* 행과 열 체크 */
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (map[i][j] == 0)
						continue;

					subNum++;
					int rowCount = 1;
					int colCount = 1;

					int rowIndex = i + 1;
					int colIndex = j + 1;

					/* row count */
					while (rowIndex < size && map[rowIndex][j] != 0) {
						rowCount++;
						rowIndex++;
					}

					/* col count */
					while (colIndex < size && map[i][colIndex] != 0) {
						colCount++;
						colIndex++;
					}

					/* check 표시 */
					for (int row = 0; row < rowCount; row++) {
						for (int col = 0; col < colCount; col++) {
							map[i + row][j + col] = 0;
						}
					}
					
					/* 리스트에 옮기기 */
					arrayList.add(new int[] { rowCount, colCount, rowCount * colCount });
				}
			}
			
			/* 배열로 이동 */
			int[][] result = new int[subNum][3];
			for (int i = 0; i < subNum; i++) {
				result[i][0] = arrayList.get(i)[0];
				result[i][1] = arrayList.get(i)[1];
				result[i][2] = arrayList.get(i)[2];
			}
			
			/* 기준에 맞게 sort */
			Arrays.sort(result, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] o1, int[] o2) {   	
	            	if(o1[2] == o2[2]) {
	            		return o1[0] - o2[0];
	            	}
	            	
	            	return o1[2] - o2[2];
	            }
	        });
			
			System.out.printf("#%d %d ",tc, subNum);
			
			/* Info check */
			for (int i = 0; i < subNum; i++) {
				System.out.printf("%d %d ", result[i][0], result[i][1]);
			}
			System.out.println();

	}
	}
	
}
