/**
 * 두 정수 사이의 합
 * 
 * @author Changhee Yoon
 */
package Programmers;

public class Solution_L1_Sum {

	public static void main(String[] args) {
		int a =3;
		int b =3;
		
		System.out.println(solution(a,b));
	}

	public static long solution(int a, int b) {
		long sum = 0;
		
		if(a <= b) {
			for(int i=a; i<=b; i++) {
				sum += i;
			}
		}else {
			for(int i=b; i<=a; i++) {
				sum += i;
			}
		}
		
        return sum;
    }
}