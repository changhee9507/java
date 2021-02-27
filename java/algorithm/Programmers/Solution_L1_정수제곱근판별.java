/**
 * 정수 제곱근 판별
 * 
 * 메모: 각 내장함수의 설명을 잘 읽어보고 어떤 리턴을 주는 것인지 확인이 되면 그것을 이용한 알고리즘 생성이 가능하다
 * 		여기서도 Math.sqrt가 rounded된 값으로 준다는 것을 알았기 때문에 -1, 0, 1,이렇게 세가지를 더해서 제곱근 판단을 할 수 있었다.
 * 
 * @author Changhee Yoon
 */
package Programmers;

public class Solution_L1_정수제곱근판별 {

	public static void main(String[] args) {
		long n = 121;
		
		System.out.println(solution(n));
	}

	public static long solution(long n) {
        
		long roundedSqrt = (long)Math.sqrt(n);
		
		System.out.println(roundedSqrt);
		
		for(int i=-1; i<=1; i++) {
			roundedSqrt += i;
			if(n == roundedSqrt * roundedSqrt) {
				return (roundedSqrt+1) * (roundedSqrt+1);
			}
		}
		
		
        return -1;
    }
}