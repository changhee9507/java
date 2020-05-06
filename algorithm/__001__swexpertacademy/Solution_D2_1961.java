/**
 * 숫자 배열 회전 
 * 
 * 요약:숫자 배열을 90도 180도 270도 회전시킨 결과를 출력
 *
 * 메모: 인덱스를 써보면 생각보다 쉽게 규칙을 찾을 수 있다.
 *	
 * @author Changhee Yoon 
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1961 {

	static int[][] map;
	static int[][] rotatedMap;
	static StringBuilder[] results;
	static int size;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TESTCASE; test++) {
			size = Integer.parseInt(br.readLine());

			map = new int[size][size];
			rotatedMap = new int[size][size];
			results = new StringBuilder[size];

			for (int i = 0; i < size; i++) {
				results[i] = new StringBuilder();
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			for (int i = 0; i < 3; i++) {
				rotation();
			}
			
			System.out.println("#" + test);
			for (int i = 0; i < size; i++) {
				System.out.println(results[i].toString());
			}

		}
	}

	/* 시계방향 90도 회전 및 결과 저장 */
	static void rotation() {

		/* 회전 */
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				rotatedMap[j][size - 1 - i] = map[i][j];
			}
		}

		/* 결과 저장 */
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				results[i].append(rotatedMap[i][j]);
			}
			results[i].append(" ");
		}

		/* map을 rotatedMap으로 깊은 복사 */
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = rotatedMap[i][j];
			}
		}

	}

}
