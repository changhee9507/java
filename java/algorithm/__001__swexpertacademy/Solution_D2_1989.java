/**
 * 초심자의 회문 검사
 * 
 * 요약 : 주어진 String이 회문인지 검사
 * 
 * 메모: 회문(level처럼 대칭을 이루는 단어)
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		for(int testcase =1; testcase<=TESTCASE; testcase++) {
			String input = br.readLine().trim();
			int result = 1;
			
			/* 대칭 위치의 char을 비교한다 */
			for(int i=0; i< input.length()/2; i++){
				if(input.charAt(i) != input.charAt(input.length() - i -1)) {
					result = 0;
				}
			}
			
			System.out.printf("#%d %d\n",testcase, result);
		}
		
	}

}
