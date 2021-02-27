/**
 * 비밀지도
 * 
 * 메모: 
 * 
 * @author Changhee Yoon
 */
package Programmers;

import java.util.Arrays;

public class Solution_L1_비밀지도 {

	public static void main(String[] args) {

		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		
		System.out.println(solution(n,arr1,arr2));
	}
	
	static int[][] map1;
	static int[][] map2;

	public static String[] solution(int n, int[] arr1, int[] arr2) {
        
		map1 = new int[n][n];
		map2 = new int[n][n];
		
		/* 두개의 맵을 int배열로 만들고 빈칸을 0, 벽을 1로 해서 채워넣는다. */
		for(int i=0; i<n; i++) {
			int num1 = arr1[i];
			int num2 = arr2[i];
			int index = n-1;
			while(num1 > 0) {
				int remain = num1 % 2;
				num1 /= 2;
				
				map1[i][index] = remain;
				index--;
			}
			
			index = n-1;
			while(num2 != 0) {
				int remain = num2 % 2;
				num2 /= 2;
				
				map2[i][index] = remain;
				index--;
			}
		}
		
		String[] resultMap = new String[n];
		
		for(int i=0; i<n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<n; j++) {
				if(map1[i][j] == 1 || map2[i][j] == 1) {
					sb.append("#");
				}else {
					sb.append(" ");
				}
			}
			
			resultMap[i] = sb.toString();
		}
		
        return resultMap;
    }
}