/**
 * 스도쿠 검증
 * 
 * 요약: 인풋이 스도쿠 룰을 만족하는지 확인
 * 
 * 메모: 스트링 빌더를 사용하는 것 보다 그냥 printf를 잘 이용하는 것이 더 실행시간적으로 이득이다.
 * 
 * @author Changhee Yoon
 */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D2_1974 {

	static int[][] sudoku = new int[9][9];
	static boolean[] existCheck = new boolean[10];
	static boolean result;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TESTCASE; test++) {
			/* 초기화 */
			result = true;
			
			
			/* 입력 저장 및 확인 */
			for(int i=0; i<9; i++) {
				String[] tmp = br.readLine().split(" ");
				for(int j=0; j<9; j++) {
					sudoku[i][j] = Integer.parseInt(tmp[j]);
				}
				
				//System.out.println(Arrays.toString(sudoku[i]));
			}
			//System.out.println();
			
			/* 확인 */
			for(int i=0; i<9; i++) {
				checkRow(i);
				checkCol(i);
			}
			for(int i=0; i<9; i += 3) {
				for(int j=0; j<9; j += 3) {
					checkPart(i,j);
				}
			}
			
			int resultNum = (result)? 1:0;
			System.out.printf("#%d %d\n", test, resultNum);
		}
	}

	static void checkRow(int checkingRow) {
		Arrays.fill(existCheck, false);
		
		for(int i=0; i<9; i++) {
			existCheck[sudoku[checkingRow][i]] = true;
		}
		
		for(int i=1; i<10; i++) {
			if(existCheck[i] == false) {
				result = false;
				return;
			}
		}
	}
	
	static void checkCol(int checkingCol) {
		Arrays.fill(existCheck, false);
		
		for(int i=0; i<9; i++) {
			existCheck[sudoku[i][checkingCol]] = true;
		}
		
		for(int i=1; i<10; i++) {
			if(existCheck[i] == false) {
				result = false;
				return;
			}
		}
	}
	
	static void checkPart(int checkingRow, int checkingCol) {
		Arrays.fill(existCheck, false);
		
		for(int i=checkingRow; i<checkingRow +3; i++) {
			for(int j=checkingCol; j<checkingCol+3; j++) {
				existCheck[sudoku[i][j]] = true;
			}
		}
		
		for(int i=1; i<10; i++) {
			if(existCheck[i] == false) {
				result = false;
				return;
			}
		}
	}
}
