/**
 * 파리 퇴치
 * 
 * 요약 : 배열속 M*M 칸 원소들의 합중 최댓값을 구해 줓력
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_2001 {

	static int N,M; // N배열 크기, M 파리채 크기
	static int[][] map;
	static int MAX; // 최대로 잡는 파리의 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		for(int testcase=1;testcase<=TESTCASE;testcase++) {
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			MAX = 0;
			
			map = new int[N][N];
			
			/* map정보 입력 */
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			/* 입력 확인 */
			/*
			 * System.out.println(N + " " + M);
			 * 
			 * for(int i =0; i<N; i++) { System.out.println(Arrays.toString(map[i])); }
			 */
			
			int flyNum = 0;
			
			for(int i=0; i <= N-M; i++) {
				for(int j=0; j<= N-M; j++) {
					flyNum = getFlyNum(i,j);
					
					if(flyNum > MAX) {
						MAX = flyNum;
					}
				}
				
			}
			
			System.out.printf("#%d %d\n",testcase, MAX);
		}
	}
	
	static public int getFlyNum(int startRow, int StartCol) {
		//System.out.println(startRow + " " + StartCol);
		
		int sum = 0;
		
		for(int i= startRow; i<startRow+M; i++) {
			for(int j= StartCol; j<StartCol+M; j++) {
				sum += map[i][j];
			}
		}
		
		return sum;
	}
}
