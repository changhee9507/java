/**
 * Swap the value of two variables.
 * 
 * @author Changhee yoon
 */

package variable;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 7;
		int y = 24;
		int tmp = 0;
		
		/*변수 선언에서는 초기화가 필수
		System.out.println(tmp);
		*/
		System.out.println("x : " + x +" y : " + y);
		
		tmp = x;
		x = y;
		y = tmp;
		
		System.out.println("x : " + x +" y : " + y);
		
	}

}
