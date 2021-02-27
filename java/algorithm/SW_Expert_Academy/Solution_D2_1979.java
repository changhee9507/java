
/**
 * 어디에 단어가 들어갈 수 있을까
 * 
 * 요약: 단어의 길이가 주어지고 배열속에서 그 단어가 들어갈 수 있는 위치의 갯수를 카운트해서 출력
 * 
 * 메모: 초기화 철저하게 하자!
 * 
 * 		입력하는 for 안에 출력문을 넣으면 쉽게 저장 결과 확인 가능
 * 
 * @author Changhee Yoon
 */
package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1979 {

	static int mapSize;
	static int wordLength;
	static int[][] map;
	static int PossibleLocationCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		for(int testcase=1; testcase<=TESTCASE; testcase++) {
			String[] tmp = br.readLine().split(" ");
			mapSize = Integer.parseInt(tmp[0]);
			wordLength = Integer.parseInt(tmp[1]);
			map = new int[mapSize][mapSize];
			PossibleLocationCnt = 0;
			
			/* 인풋 저장 */
			for(int i=0; i<mapSize; i++) {
				tmp = br.readLine().split(" ");
				
				for(int j=0; j<mapSize; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
				
				//System.out.println(Arrays.toString(map[i])); /* 결과 확인 */
			}
			
			for(int i=0; i<mapSize; i++) {
				for(int j=0; j<mapSize; j++) {
					if(map[i][j] == 0) {
						continue;
					}
					ckeckHorizontal(i,j);
					checkVertical(i,j);
					
				}
			}
			
			System.out.printf("#%d %d\n", testcase, PossibleLocationCnt);
			
		}
		
	}
	
	static void ckeckHorizontal(int row, int col) {
		
		if(col > 0 && map[row][col-1] == 1) {
			return;
		}
		
		int length = 0;
		
		for(int i=col; i<mapSize; i++) {
			if(map[row][i] == 1) {
				length++;
			}else {
				break;
			}
		}
		
		if(length == wordLength) {
			PossibleLocationCnt++;
		}
	}
	
	static void checkVertical(int row, int col) {
		if(row > 0 && map[row-1][col] == 1) {
			return;
		}
		
		int length = 0;
		
		for(int i=row; i<mapSize; i++) {
			if(map[i][col] == 1) {
				length++;
			}else {
				break;
			}
		}
		
		if(length == wordLength) {
			PossibleLocationCnt++;
		}
	}
}
