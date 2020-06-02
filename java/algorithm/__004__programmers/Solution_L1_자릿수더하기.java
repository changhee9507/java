/**
 * 시저 암호 
 * 
 * 메모 : 알파벳의 숫자가 26개인 것을 이용하면 대소문자의 계산을 할 수 있다.
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

public class Solution_L1_자릿수더하기 {

	public static void main(String[] args) {
		
		int n = 123;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
        int answer = 0;

        while(n != 0) {
        	answer += n % 10;
        	n /= 10;
        }
        
        return answer;
    }
}