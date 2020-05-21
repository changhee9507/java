/**
 * 소수 찾기
 * 
 * 소수인지 확인
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

import java.util.Arrays;

public class Solution_L1_PrimeNumber {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(solution(n));
	}

	public static int solution(int n) {

		int primeCnt = 1;
	
		for(int i=3; i<=n; i = i+2) {	/* 짝수는 배제 */
				if(checkPrime(i) == 1) { /* 소수이면 카운트 업*/
					primeCnt++;
				}
		}
		
		return primeCnt;

	}
	
	public static int checkPrime(int num) {
		
		
		for(int i=2; i<=Math.sqrt(num); i++) { /* 제곱근까지 나눠지는 것이 있는지 확인 나눠지는 것이 있으면 바로 -1 리턴 */
			if(num % i == 0) {
				return -1;
			}
		}
		return 1;
	}
}