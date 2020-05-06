/**
 * 파스칼의 삼각형
 * 
 * 요약:파스칼의 삼각형을 출력
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D2_2005 {
	
	static int[][] pascal = new int[11][11];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		/* 배열에 파스칼 삼각형의 각 값을 계산해서 저장*/
		makePascal();
		
		/* 배열 출력 */
		/*
		 * for(int i=0; i<11; i++) { System.out.println(Arrays.toString(pascal[i])); }
		 */
		
		for(int testcase = 1; testcase <= TESTCASE; testcase++) {
			int size = Integer.parseInt(br.readLine().trim());
		
			System.out.println("#" + testcase);
			for(int i=0; i<size; i++) {
				for(int j=0; j<i+1; j++) {
					System.out.print(pascal[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
	}
	
	static void makePascal() {
		
		for(int i=0; i<11; i++) {
			for(int j=0; j<i+1; j++) {
				
				if(i == 0 || j == 0) {
					pascal[i][j] = 1;
				}else if(i == j) {
					pascal[i][j] = 1;
				}else {
					pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
				}	
			}
		}
		
	}
}
