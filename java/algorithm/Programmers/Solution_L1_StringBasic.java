/**
 * 문자열 다루기 기본
 * 
 * 메모: 문자열이 숫자인지 문자인지 확인하는 것은 우선 아스키코드의 대소비교로 가능하고
 * 
 * 		split함수에도 관련된 기능을 제공하는 것 같으며
 * 
 * 		정규표현식을 이용할 수 도 있다.
 * 
 * @author Changhee Yoon
 */
package Programmers;

public class Solution_L1_StringBasic {

	public static void main(String[] args) {

		String s = "1234";
		
		System.out.println(solution(s));
	}

	public static boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) {
        	return false;
        }
		
		for(int i=0; i<s.length(); i++) {
			if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				return false;
			}
		}
		
        return true;
    }
}