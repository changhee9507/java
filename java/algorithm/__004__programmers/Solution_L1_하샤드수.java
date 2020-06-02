/**
 * 하샤드 수
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

public class Solution_L1_하샤드수 {

	public static void main(String[] args) {

		int arr = 11;
		System.out.println(solution(arr));
	}

	public static boolean solution(int x) {
        int num = x;
		int sum = 0;
        
		while(num != 0) {
			sum += num % 10;
			num /= 10;
		}
        
		if(x % sum == 0) {
			return true;
		}else {
			return false;
		}
    }
}