package array;

import java.util.Arrays;
import java.util.Scanner;

public class Bakery {

	static boolean reachEnd = false;
	static int count = 0;
	static int rowSize;
	static int colSize;
	static char[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		rowSize = scan.nextInt();
		colSize = scan.nextInt();

		map = new char[rowSize][colSize];

		/* 맵 저장 */
		for (int i = 0; i < rowSize; i++) {
			String input = scan.next();
			for (int j = 0; j < colSize; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		

		/* 처음부터 시작 */
		for (int row = 0; row < rowSize; row++) {
			reachEnd = false;
			findRoot(row, 0);
			
			
		}

	}

	/* 우상, 우, 우하 */
	static int[] dRow = {-1, 0, 1};
	static int[] dCol = {1, 1, 1};
	static void findRoot(int row, int col) {
		
		/* 맵 출력 */
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		if(reachEnd == true) {
			return;
		}
		
		map[row][col] = '#';
		
		if(col == colSize-1) {
			count++;
			reachEnd = true;
			return;
		}
		
		for(int i=0; i<3; i++) {
			int newRow = row + dRow[i];
			int newCol = col + dRow[i];
			
			if(newRow < 0|| newCol <0 || newRow >= rowSize || newCol > colSize) {
				continue;
			}
			else if(map[newRow][newCol] == 'x' || map[newRow][newCol] == '#' ){
				continue;
			}
			else {
				findRoot(newRow, newCol);
			}
		}
		
		map[row][col] = '.';
}
}
