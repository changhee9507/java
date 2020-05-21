/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.set4;

public class Solution_p2 {

	public static void main(String[] args) {
		
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}

	static long answer = Long.MIN_VALUE;
	
	public static long solution(String expression) {
        long tmp = Math.abs(Long.parseLong(expression));
        if(tmp > answer) {
        	answer = tmp;
        }
        return answer;
    }
}
