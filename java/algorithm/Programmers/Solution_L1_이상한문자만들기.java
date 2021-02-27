/**
 * 이상한 문자 만들기
 *  
 * 메모: 공백도 그대로 하나하나 바꿔주면 에러가 생길 가능성이 거의 없어진다. 
 * 
 * @author Changhee Yoon
 */
package Programmers;

public class Solution_L1_이상한문자만들기 {

	public static void main(String[] args) {

		String s = "try hello world";
		
		System.out.println(solution(s));
	}

	public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
		
        int index = 0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == ' ') {
        		index = 0;
        		sb.append(' ');
        		continue;
        	}else {
        		
        		if(index % 2 == 0) {
        			sb.append(Character.toUpperCase(s.charAt(i)));
        		}else {
        			sb.append(Character.toLowerCase(s.charAt(i)));
        		}
        		
        		index++;
        	}
        }
        
		return sb.toString();
    }
}