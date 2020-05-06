/**
 * 가랏! RC카!
 * 
 * 요약: 속도 변화를 적용해서 이동거리 계산
 * 
 * 
 * @author Changhee Yoon
 * 문제 출처 : SW Expert Academy
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1940 {

	static int velocity;
	static int distance;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());		
		
		for(int test=1; test<= TESTCASE; test++) {
			velocity=0;
			distance=0;
			
			int num = Integer.parseInt(br.readLine());
			for(int i=0; i<num; i++) {
				String[] tmp = br.readLine().split(" ");
				
				if(tmp[0].equals("0")) {
					distance += velocity;
				}else if(tmp[0].equals("1")) {
					velocity += Integer.parseInt(tmp[1]);
					distance += velocity;
				}else {
					if(Integer.parseInt(tmp[1]) > velocity) {
						velocity = 0;
					}else {
						velocity -= Integer.parseInt(tmp[1]);
					}
					
					distance += velocity;
				}
			}
			
			System.out.printf("#%d %d\n", test, distance);
		}
	}

}
