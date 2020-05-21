/**
 * 타일링
 * 
 * 
 * 
 * @author Changhee Yoon
 */

package __002__baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11727 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] values = new long[1001];
		
		values[0] = 0;
		values[1] = 1;
		values[2] = 3;
		
		for(int i=3; i<= n; i++) {
			values[i] = values[i-1] + values[i-2] * 2;
			values[i] %= 10007;
		}
		
		//System.out.println(Arrays.toString(values));
		System.out.print(values[n]);
		
	}

}
