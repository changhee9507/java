/**
 * 새로운 불면증 치료법
 * 
 * 요약: 
 * 
 * 메모: 중복을 허용하지 않는 포함을 알고 싶을때는 set 개념을 이용한다.
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_D2_1288 {

	static Set<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TESTCASE; test++) {
			set.clear();
			int N = Integer.parseInt(br.readLine()); 
			int cnt = 0;
			int present_N = N;
			
			while(set.size() < 10) {
				cnt++;
				String str_N = String.valueOf(present_N);
				
				//System.out.println(str_N);
				
				for(int i=0; i<str_N.length(); i++) {
					int num = (str_N.charAt(i) - '0');
					set.add(num);
				}
				
				//System.out.println(set.toString());
				present_N += N;
				
			}
			
			System.out.printf("#%d %d\n", test, N * cnt);
		}
	}

}
