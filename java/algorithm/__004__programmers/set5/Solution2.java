/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.set5;

import java.util.HashSet;

public class Solution2 {

	public static void main(String[] args) {

		int n = 11;
		System.out.println("result " + solution(n));
	}

	
	public static long solution(long n) {
        
		int cnt = 0;
        
		long result = 0;
		
		while(n != 0) {
			
			if( (long)Math.pow(2, cnt) == n) {
				result += (long)Math.pow(3, cnt);
				break;
			}else if((long)Math.pow(2, cnt) > n){
				cnt--;
				result += (long)Math.pow(3, cnt);
				n -= (long)Math.pow(2, cnt);
				cnt = 0;
			}else {
				cnt++;
			}
		}
        
		System.out.println(" > " + cnt);
		
		return result;
		
    }
}