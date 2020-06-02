/**
 * 시저 암호 
 * 
 * 메모 : 알파벳의 숫자가 26개인 것을 이용하면 대소문자의 계산을 할 수 있다.
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

public class Solution_L1_시저암호 {

	public static void main(String[] args) {
		
		String s = "z";
		int n = 1;
		System.out.println(solution(s, n));
	}

	public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
        	char tmp = s.charAt(i);
        	
        	if(tmp >= 'a' && tmp <= 'z') { /* 소문자인 경우 */
        		tmp += n;
        		if(tmp > 'z') {
        			tmp -= 26;
        		}
        	}else if(tmp >= 'A' && tmp <= 'Z'){
        		tmp += n;
        		if(tmp > 'Z') {
        			tmp -= 26;
        		}
        	}
        	
        	sb.append(tmp);
        }
		
		
        return sb.toString();
    }
}