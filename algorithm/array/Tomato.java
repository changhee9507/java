package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
	
	static boolean s;
	static int[][] map;
	static boolean[][] visited;
	static int rowSize;
	static int colSize;
	static Queue<int[]> tmtLoc = new LinkedList<int[]>();
	static boolean changed = false;
	static int days=0;
	static boolean zeroExist = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		colSize = scan.nextInt();
		rowSize = scan.nextInt();
		
		map = new int[rowSize+2][colSize+2];
		visited = new boolean[rowSize+2][colSize+2];
		for(int i=0; i<rowSize+2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		/* 토마토 정보 입력*/
		for(int i=1; i<= rowSize; i++) {
			for(int j=1; j<= colSize; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 1) {
					tmtLoc.offer(new int[] {i,j,0});
				}
				if(map[i][j] == 0) {
					zeroExist = true;
				}
			}
		}
		if(!zeroExist) {
			System.out.println(0);
			return;
		}
		
		/* 맵 출력 */
		/*
		 * for(int i=0; i< rowSize+2; i++) { for(int j=0; j< colSize+2; j++) {
		 * System.out.printf("%3s ", map[i][j]); } System.out.println(); }
		 */
			
		/* 이전의 맵과 차이가 없으면 스톱 */
		while(!tmtLoc.isEmpty()) {
			
			/*
			 * for(int i=0; i< rowSize+2; i++) { for(int j=0; j< colSize+2; j++) {
			 * System.out.printf("%3s ", map[i][j]); } System.out.println(); }
			 * System.out.println("days : " + days);
			 */
			for(int i=0; i<tmtLoc.size(); i++) {
				process();
			}
		}
		
		/* 0이 남아있으면 -1 아니면 days 출력*/
		zeroExist= false;
		for(int i=1; i <= rowSize; i++) {
			for(int j=1; j<= colSize; j++) {
				if(map[i][j] == 0) {
					zeroExist = true;
				}
			}
		}
		if(zeroExist) {
			System.out.println(-1);
		}else {
			System.out.println(days);			
		}
		
	}
	
	/* 상하좌우*/
	static int[] dRow = {-1, 1, 0 , 0};
	static int[] dCol = {0, 0, -1, 1};
	
	static void process() {
		int[] loc = tmtLoc.poll();
		visited[loc[0]][loc[1]] = true;
		
		if(days < loc[2]) {
			days= loc[2];
		}
		
		/* 상하좌우에 토마토를 확인 */
		for(int i =0; i<4; i++) {
			int row = loc[0] + dRow[i];
			int col = loc[1] + dCol[i];
			if(visited[row][col] == true) continue;
			visited[row][col] = true;
	
			if(map[row][col] == 0) {
				map[row][col] = 1;
				int count = loc[2]+1;
				tmtLoc.offer(new int[]{row,col,count});
			}
		}
		
	}
	
}
