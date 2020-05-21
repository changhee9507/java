/**
 * 백만장자 프로젝트
 * 
 * 요약 : 주가를 예측한 값이 주어졌을때 얻을 수 있는 최대 수익을 구하기 
 *   
 * @author changhee Yoon
 */

package __001__swexpertacademy;

import java.util.Scanner;

public class Solution_D2_1859 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int TESTCASE = scan.nextInt();
		
		for(int testcase = 1; testcase<= TESTCASE; testcase++) {
			
			/* 날 수를 받고 그만큼 주가를 저장할 배열을 생성*/
			int period = scan.nextInt();
			int[] stockPrice = new int[period]; 
			
			/* 주가 데이터 저장*/
			for(int i=0; i<stockPrice.length; i++) {
				stockPrice[i] = scan.nextInt();
			}
			
			long result = getTotalRevenue(stockPrice);
			
			System.out.printf("#%d %d\n",testcase, result);
			
		}
		
		scan.close();
	}
	
	/* 알고리즘
	 * 1.배열 뒤에서 앞으로 순회하면서 최대 가격을 설정
	 * 2.최대가격을 갱신하고 최대가격에서 현재 가격을 뺀 값을 누적으로 합 */
	public static long getTotalRevenue(int[] prices) {
		
		int maxPrice = -999; /* 현재까지 최대 주가*/
		long totalRevenue = 0; /* 누적 이익 */
		for(int i= prices.length-1; i>=0; i--) {
			/* 최대 주가 갱신*/
			if(prices[i] > maxPrice) {
				maxPrice = prices[i];
			}
			
			/* 이익 누적 */
			totalRevenue += (maxPrice - prices[i]);
		}
		
		return totalRevenue;
	}
}
