/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.set5;

import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {

		int p = 1987;
		
		System.out.println(solution(p));
	}

	public static int solution(int p) {
        
		HashSet<Character> set = new HashSet<>();
		p++;
		while(true) {
			set.clear();
			String input = String.valueOf(p);
			
			for(int i=0; i<input.length(); i++) {
				set.add(input.charAt(i));
			}
				
			if(set.size() == input.length()) {
				return p;
			}else {
				p++;
			}
		}
    }
}