/**
 * 계단오르기
 * 
 * 요약:
 * 
 * 메모: 동적 프로그래밍(메모이제이션)을 이용한다.
 * 		그리디 적으로 해결하는 것과 착각하면 안된다.
 * 
 * 		점화식과 같은 형태로 현재의 답을 구하는 조건을 구하는 것이 핵심이다.
 * 
 * 		만약 N이 1,2라면 조금 다르게 처리가 필요하다
 * 		
 * 
 * @author Changhee Yoon
 */

package __002__baekjoon;

import java.util.Scanner;

public class Main_2579 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
	
		int[] scores = new int[N + 1];
		int[] max = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			scores[i] = sc.nextInt();
		}

		if(N == 1) {
			System.out.println(scores[N]);
			return;
		}else if (N == 2) {
			System.out.println(scores[N] + scores[N-1]);
			return;
		}
		
		max[1] = scores[1];
		max[2] = scores[1] + scores[2];
		
		for(int i=3; i<=N; i++) {
			int option1 = max[i-3] + scores[i-1] + scores[i];
			int option2 = max[i-2] + scores[i];
			
			max[i] = ( option1 > option2)? option1 : option2; 
		}
	
		System.out.print(max[N]);
		sc.close();
	}
}