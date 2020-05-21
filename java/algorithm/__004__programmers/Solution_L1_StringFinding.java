/**
 * 서울에서 김서방 찾기
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

public class Solution_L1_StringFinding {

	public static void main(String[] args) {
		
		String[] seoul = {"Jane", "Kim"};
		System.out.println(solution(seoul));
	}

	public static String solution(String[] seoul) {
		
		for(int i=0; i<seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				return String.format("김서방은 %d에 있다", i);
			}
			
		}
		return null;
    }
}