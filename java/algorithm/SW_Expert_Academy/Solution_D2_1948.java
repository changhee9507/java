/**
 * 날짜 계산기
 * 
 * 요약 : 두 날짜의 사이 계산
 * 
 * 메모 :
 * 
 * @author Changhee Yoon
 * 
 * 문제 출처 : SW expert Academy  
 */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1948 {

	static int startMonth, startDate, endMonth, endDate;
	static int[] dateForEachMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TESTCASE; test++) {
			cnt = 0;
			
			String[] tmp = br.readLine().split(" ");
			
			
			startMonth = Integer.parseInt(tmp[0]);
			startDate = Integer.parseInt(tmp[1]);
			endMonth = Integer.parseInt(tmp[2]);
			endDate = Integer.parseInt(tmp[3]);
			
			if(startMonth == endMonth) { /* 같은 달 이라면 그냥 날짜의 차이 */
				cnt = endDate - startDate + 1;
			}else { /* 달이 다르다면 3단계로 진행*/
				
				/* 시작 달의 끝 날부터 시작 날짜까지의 일 수 누적*/
				cnt += dateForEachMonth[startMonth] - startDate + 1;
				
				/* 시작 달과 끝 달 사이의 모든 달 날짜 누적 */
				for(int i=startMonth+1; i<endMonth; i++) {
					cnt += dateForEachMonth[i];
				}
				
				/* 끝 달의 날짜 누적*/
				cnt += endDate;
			}
			
			System.out.printf("#%d %d\n", test, cnt);
		}
		
		
		
	}
}
