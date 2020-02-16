/**
 * 백준 3109 빵집 
 * 
 */

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
		
		/* 맵 출력 */
		/*
		 * for (int i =0; i< rowSize; i++) { for(int j =0; j < colSize; j++) {
		 * System.out.print(map[i][j] + " " ); } System.out.println(); }
		 */
		
		for(int row = 0; row < rowSize; row++) {
			reachEnd = false;
			dfs(row, 0);
		}
		
		System.out.println(count);
		
		
	}

	/* 우상, 우, 우하 */
	static int[] dRow = {-1, 0, 1};
	static int[] dCol = {1, 1, 1};
	
	static void dfs(int row, int col) {
		boolean called = false;
		/* 출력 */
		
		  for(int i = 0; i< rowSize; i++) { for(int j=0; j< colSize; j++) {
		  System.out.print(map[i][j] + " "); } System.out.println(); }
		  System.out.println();
		 
		if( col == colSize -2) { /* 기저 조건 */
			map[row][col] = '#';
			count++;
			reachEnd = true;
			return;
		}
		
		for(int i=0; i<3 && !reachEnd; i++) {
			int newRow = row + dRow[i];
			int newCol = col + dCol[i];
			if(newRow < 0 || newCol <0 || newRow >= rowSize || newCol >= colSize) {
				continue;
			}
			
			if(map[newRow][newCol] == 'x' || map[newRow][newCol] == '#'){
				continue;
			}
			dfs(newRow, newCol);
			called = true;
		}
		
		if(called) {
			map[row][col] = '.';
		}
		
	}
	
}
