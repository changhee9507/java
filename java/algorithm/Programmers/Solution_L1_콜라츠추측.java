/**
 * 콜라츠 추측
 * 
 * 메모: 숫자 계산에서 논리가 간단한데 값이 오차생기면 거의 대부분 오버플로우 문제이기 때문에 double이나 long을 활용한다.
 * 
 * @author Changhee Yoon
 */
package Programmers;

public class Solution_L1_콜라츠추측 {

	public static void main(String[] args) {
		int n = 16;
		System.out.println(solution(n));
	}

	public static int solution(int num) {
        long n = (long)num;
		int cnt = 0;
		
		while(n != 1) {
			if(cnt >= 500) {
				return -1;
			}
			
			if(n % 2 == 0) {
				n /= 2;
				cnt++;
			}else {
				n = n * 3 + 1;
				cnt++;
			}
		}
		
		return cnt;
    }
}