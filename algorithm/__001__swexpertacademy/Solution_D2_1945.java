/**
 * 간단한 소인수분해
 *
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D2_1945 {

	static int[] quotients = {2,3,5,7,11};
	static int[] results = new int[5];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		for(int test=1; test<=TESTCASE; test++) {
			Arrays.fill(results, 0);
			
			int num = Integer.parseInt(br.readLine().trim());
			
			for(int i=0; i<quotients.length; i++) {
				int tmp = num;
				while(true) {
					if(tmp % quotients[i] == 0) {
						tmp /= quotients[i];
						results[i]++;
					}else {
						break;
					}
				}
				
			}
			
			System.out.printf("#%d %d %d %d %d %d\n",test, results[0], results[1], results[2], results[3], results[4]);
		}
		
	}

}
