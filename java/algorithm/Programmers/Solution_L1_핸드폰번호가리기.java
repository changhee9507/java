/**
 * 
 * 
 * @author Changhee Yoon
 */
package Programmers;

public class Solution_L1_핸드폰번호가리기 {

	public static void main(String[] args) {
		
		String num = "01033334444";
		System.out.println(solution(num));
	}

	public static String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
		
        for(int i=0; i<phone_number.length(); i++) {
        	if(i < phone_number.length() - 4) {
        		sb.append('*');
        	}else {
        		sb.append(phone_number.charAt(i));
        	}
        }
	
        return sb.toString();
    }
}