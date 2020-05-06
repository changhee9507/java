/**
 * 2016년
 * 
 * 메모: 날짜 관련된 계산은 LocalDate라는 api를 이용하는 것이 이상적이다
 * 		년도가 다르면 해당 계산이 맞지 않다.
 * 
 * @author Changhee Yoon
 */

package __004__programmers;

import java.time.LocalDate;

public class Solution_L1_Date {

	public static void main(String[] args) {
		int month = 1;
		int date = 1;
		
		System.out.println(solution(month, date));
	}

	public static String solution(int a, int b) {
		LocalDate date = LocalDate.of(2016,a,b);
		
		System.out.println(date.toString() + " "  + date.getDayOfWeek());
		
	    return date.getDayOfWeek().toString().substring(0,3);
	  }
}