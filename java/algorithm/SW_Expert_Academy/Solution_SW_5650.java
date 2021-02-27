package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SW_5650 {

	static int[][] map;
	static int size;
	static int maxScore;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		for(int testcase=1; testcase<=TESTCASE; testcase++) {
			size = Integer.parseInt(br.readLine().trim());
			map = new int[size][size];
			maxScore = 0;
			
			for(int i=0; i<size; i++) {
			String[] tmp = br.readLine().split(" ");
				for(int j=0; j<size; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			/*입력 확인 */
//			for(int i=0; i<size; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			/* 모든 자리에서 */
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if(map[i][j] != 0) {
						continue;
					}
					
					for(int delta=0; delta<4; delta++) {
						pinball(i,j,delta);
					}
				}
			}
			
			
		}
		
	}
	
	/* 상하좌우 */
	public static int[] dRow = {-1, 1, 0, 0};
	public static int[] dCol = {0, 0, -1, 1};
	
	public static void pinball(int row, int col, int direction) {
		
	}
}
