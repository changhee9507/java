/**
 * 가운데 글자 가져오기
 * 
 * @author Changhee Yoon
 */

package __004__programmers;

public class Solution_L1_String {

	public static void main(String[] args) {
		
		String sample = "abcde";
		
		System.out.println(solution(sample));
	}

	public static  String solution(String s) {
		
		if(s.length() % 2 == 1) {
			return s.substring(s.length()/2 , s.length()/2 + 1);
		}else {
			return s.substring(s.length()/2-1 , s.length()/2 + 1);
		}
    }
}