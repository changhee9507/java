/**
 * 수영장
 * 
 * 메모: 동적 프로그래밍의 핵심은 dp[n]의 점화식을 찾는 것이다
 * 		그래서 그 순간순간 최적 해를 찾아가면서 다음 해를 구한다.
 * 
 * 		단위가 같은것은 단순 비교하면 된다. 예를들어서 1일 이용권과 1달 이용권은
 * 		1달로 단위가 같기 때문에 dp없이 단순 비교할 수 있다.
 * 
 * 		배열의 크기를 늘리는 것도 고려해볼수 있다
 * 		예를들어 이 문제의 경우 11월이나 12월에도 3달권을 살 수 있기 때문에 2월까지
 * 		배열을 추가로 만들어서 값을 계산하였다.
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SW_1952 {

	static int[] cost;
	static int[] plan;
	static int[] minCost;
	static int[] monthlyCosts;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			cost = new int[4];
			plan = new int[15];
			monthlyCosts = new int[15];
			minCost = new int[15];

			String[] tmp = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(tmp[i]);
			}

			tmp = br.readLine().split(" ");
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(tmp[i-1]);
			}
			
			//System.out.println("Cost" + Arrays.toString(cost));
			//System.out.println("Plan" + Arrays.toString(plan));
			
			for(int i = 1; i<= 14; i++) { /* 1일권이나 한달 이용권을 사용한 경우 */
				int monthCost =  Math.min(cost[1], cost[0] * plan[i]);
				monthlyCosts[i] = monthCost;  
			}
			
			//System.out.println(Arrays.toString(monthlyCosts));
			
			minCost[1] = monthlyCosts[1];
			minCost[2] = minCost[1] + monthlyCosts[2];
			for(int i = 3; i<= 14; i++) { /* 3달 권도 고려한 경우 */
				minCost[i] = Math.min(minCost[i-1] + monthlyCosts[i], minCost[i-3] + cost[2]);
			}
			

			//System.out.println(Arrays.toString(minCost));
			/* 1년권과 비교해서 출력 */
			System.out.printf("#%d %d\n", test, (minCost[14] > cost[3])? cost[3]: minCost[14]);
			
 
		}
	}

}
