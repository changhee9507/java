/**
 * 쉬운 거스름돈
 * 
 * 요약: 돈의 종류가 주어지고 돈의 갯수가 가장 작도록 거스름돈을 돌려준다.
 * 
 * 메모: 그리디알고리즘이 가능한 경우는 선택지들 사이의 관계와 관련이 있다
 * 
 * 		예를 들어 잔돈의 종류가 500원과 100원이 있다고 해보자
 * 		이런경우 500원은 100원의 배수이기 때문에 일단 무조건 500원을
 * 		많이 쓰는 것이 숫자를 줄일 수 있다.
 * 
 * 		만약 700원과 600원 500원,100원이 있다면 이들은 서로 배수나 약수 관계가 아니기 때문에
 * 		그리디를 쓰면 안된다 예를 들어 1000원이 있다면 500원 두개가 최소이고 700원 짜리를 쓰면
 * 		필요한 돈의 숫자가 오히려 늘어난다.
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1970 {

	static int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	static int[] cnts = new int[moneys.length];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		
		for(int test=1; test<= TESTCASE; test++) {
			int change = Integer.parseInt(br.readLine());
			
			/* 그리디 알고리즘으로 돈 갯수 계산 및 저장 */
			for(int i=0; i<moneys.length; i++) {
				cnts[i] = change / moneys[i];
				change = change % moneys[i];
			}
			
			/* 출력 */
			System.out.printf("#%d\n",test);
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<cnts.length; i++) {
				sb.append(cnts[i] + " ");
			}
			System.out.println(sb.toString().trim());
		}
		
	}

}
