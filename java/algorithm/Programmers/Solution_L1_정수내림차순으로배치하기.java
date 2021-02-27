/**
 * 정수 내림차순으로 배치하기 
 * 
 * 메모: 1. split("")을 이욯하면 붙어있는 스트링도 배열로 나눠서 담을 수 있다.
 * 		2.  Arrays.sort(input, Collections.reverseOrder()); 을 이용하면 역순으로 정렬할 수 있지만 rapper 클래스(Integer, Long, Character) 같은 것을 써야 되서 불편한다
 * 			그래서 여기서도 String배열을 이용해서 좀 편리했다. (숫자도 일반 스트링과 정렬 순서가 같기 때문에 ) 
 * 
 * @author Changhee Yoon
 */
package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class Solution_L1_정수내림차순으로배치하기 {

	public static void main(String[] args) {
				
		long n = 11827369;
				
		System.out.println(solution(n));
	}

	public static long solution(long n) {
		
		String[] input = String.valueOf(n).split("");
        
        Arrays.sort(input, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<input.length; i++) {
        	sb.append(input[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}