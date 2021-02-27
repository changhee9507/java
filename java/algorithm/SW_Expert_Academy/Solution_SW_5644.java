/**
 * 무선 충전
 * 
 * @author Changhee Yoon
 */
package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_SW_5644 {

	static int moveNum, batteryNum;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TC = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TC; test++) {
			String[] tmp = br.readLine().split(" ");
			
			moveNum = Integer.parseInt(tmp[0]);
			batteryNum = Integer.parseInt(tmp[1]);
			
			Battery[] BatteryArr = new Battery[batteryNum];
			
			LinkedList<Integer> aList = new LinkedList<>(); 
			LinkedList<Integer> bList = new LinkedList<>(); 
			
			tmp = br.readLine().split(" ");
			for(int i=0; i<tmp.length; i++) {
				aList.addLast(Integer.parseInt(tmp[i]));
			}
			
			tmp = br.readLine().split(" ");
			for(int i=0; i<tmp.length; i++) {
				bList.addLast(Integer.parseInt(tmp[i]));
			}
			
			for(int i=0; i<batteryNum; i++) {
				tmp = br.readLine().split(" ");
				int row = Integer.parseInt(tmp[1]);
				int col = Integer.parseInt(tmp[0]);
				int C = Integer.parseInt(tmp[2]);
				int P = Integer.parseInt(tmp[3]);
				
				BatteryArr[i] = new Battery(row, col, C, P);
				System.out.println(BatteryArr[i]);
			}
			
			/* 배터리 정보를 맵에 옮김 */
			map = new int[11][11];
			for(int i=0; i<batteryNum; i++) {
				drow(BatteryArr[i].row, BatteryArr[i].col, BatteryArr[i].C, BatteryArr[i].P); /* 맵에 P를 범위만큼 새겨넣는다 */
			}
			
			/* 출력 */
			for(int i=0; i<11; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			
			/* 시뮬레이션 */
			int sum = simulation(1,1,aList);
			System.out.println(sum);
			sum += simulation(10,10,bList);
			System.out.println(sum);
			
		}
		
	}
	
	static class Battery {
		int row;
		int col;
		int C;
		int P;
		
		public Battery(int r, int c, int C, int P) {
			this.row = r;
			this.col = c;
			this.C = C;
			this.P = P;
		}

		@Override
		public String toString() {
			return "Battery [row=" + row + ", col=" + col + ", C=" + C + ", P=" + P + "]";
		}
		
		
	}

	static int[] dRow = {0,-1, 0, 1, 0};
	static int[] dCol = {0, 0, 1, 0,-1};
	
	static void drow(int row, int col, int C, int P) {
		
		if(map[row][col] < P) {
			map[row][col] = P;
		}
		
		if(C == 0) {
			return;
		}
		
		for(int i=1; i<=4; i++) {
			int nextRow = row + dRow[i];
			int nextCol = col + dCol[i];
			if(nextRow >= 1 && nextCol >= 1 && nextRow <=10 && nextCol<=10) {
				drow(nextRow, nextCol, C-1, P);
			}
		
		}
	}
	
	static int simulation(int row, int col, LinkedList<Integer> list) {
		int count = 0;
		
		int sum = map[row][col]; 
		System.out.println(sum + " count : " + count++ + " row " + row + " col " + col);
		while(!list.isEmpty()) {
			int dir = list.removeFirst();
			row += dRow[dir];
			col += dCol[dir];
			sum += map[row][col];
			System.out.println(sum + " count : " + count++ + " row " + row + " col " + col);
		}
		
		return sum;
	}
}
