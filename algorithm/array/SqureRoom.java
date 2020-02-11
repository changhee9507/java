/**
 * swexpertacademy 1861 문제 풀이
 * 
 * @author Changhee Yoon
 */

package array;

import java.util.Scanner;

public class SqureRoom {

	static int[][] map;
	static int totalCount = -1;
	static int startNum;
	static int size;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		final int TESTCASE = scanner.nextInt();
		
		for(int tc = 1; tc <= TESTCASE; tc++) {
			
			totalCount = -1;
			startNum = 0;
			size= 0;
			size = scanner.nextInt();
			map = new int[size][size];
			
			/* 인풋 저장 */
			for(int i=0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					map[i][j] = scanner.nextInt();
				}
			}
			
			/* 맵 출력 */
			/*for(int i=0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					System.out.print(map[i][j]+ " ");
				}
				System.out.println();
			}*/
			
			/* 몇칸을 이동할 수 있는지 확인*/
			for(int i=0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					countMove(map[i][j],i,j,0);
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, startNum, totalCount);
		}	
	}

	/* 상 하 좌 우 */
	static byte[] dRow = { -1, 1, 0,0};
	static byte[] dCol = {  0, 0, -1, 1};
	
	static private void countMove(int start, int row, int col, int count) {
//		System.out.println(start + " " + row + " "+ col);
//		
		
		int localCount = count+1;
		if(localCount > totalCount) {
			totalCount = localCount;
			startNum = start;
		}
		else if(localCount == totalCount && start < startNum) {
			startNum = start;
		}
		
		for(int i = 0; i<4; i++){
			if((row+dRow[i] < 0) || (row+dRow[i] >= size) ||(col+dCol[i] < 0) ||(col+dCol[i] >= size)) continue;
			
			if(map[row + dRow[i]][col + dCol[i]] == map[row][col] +1) {	
				countMove(start, row + dRow[i],col + dCol[i], count+1);
			}
		}
	
	}
}
