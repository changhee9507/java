/**
 * 지그재그 숫자
 * 
 * 요약: 1 - 2 + 3 ..... 의 순서로 계산해서 출력
 * 
 * @author Changhee Yoon
 */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1986 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		for(int testcase=1; testcase<=TESTCASE; testcase++) {
			int num = Integer.parseInt(br.readLine().trim());
			
			int result = 0;
			
			for(int i=1; i<=num; i++) {
				if(i%2 == 0) {
					result -= i;
				}else {
					result += i;
				}
			}
			
			System.out.printf("#%d %d\n", testcase, result);
			
		}
	}

}
