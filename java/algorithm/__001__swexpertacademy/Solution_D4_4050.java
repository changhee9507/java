package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution_D4_4050 {

	static int N; /* 옷의 갯수 */
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TC = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TC; test++) {
			
			N = Integer.parseInt(br.readLine());
			
			String[] tmp = br.readLine().split(" ");
			Integer[] prices = new Integer[N];
			
			for(int i=0; i<N; i++) {
				prices[i] = Integer.parseInt(tmp[i]);
				
			}
			
			
			Arrays.sort(prices, Collections.reverseOrder());
			//System.out.println(Arrays.toString(prices));
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(i%3 == 2) {
					continue;
				}else {
					sum += (long)prices[i];
				}
			}
			
			System.out.printf("#%d %d\n", test, sum);
		}
	
		
	}

}
