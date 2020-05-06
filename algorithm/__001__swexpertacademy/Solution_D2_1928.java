/**
 * Base64 Decoder
 * 
 * 요약: 인코딩 과정 되돌리기 
 * 
 * 메모: parseInt는 이진법형태로 받아들이는 것도 가능
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1928 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		
		final int TESTCASE = Integer.parseInt(br.readLine());
		for (int test = 1; test <= TESTCASE; test++) {
			sb.delete(0, sb.length());
			result.delete(0, result.length());
			String input = br.readLine().trim();
			for (int i = 0; i < input.length(); i++) {
				int tmp = input.charAt(i);
				if(65 <= tmp && tmp <= 90 ) {
					tmp -= 65;
				}else if(97<= tmp && tmp <= 122) {
					tmp -= 71;
				}else if(48<= tmp && tmp <= 57) {
					tmp += 4;
				}else if(tmp == 43) {
					tmp = 62;
				}else {
					tmp = 63;
				}
				
				sb.append(String.format("%6s", Integer.toBinaryString(tmp)).replace(' ', '0'));
			}

			for(int i=0; i<sb.length(); i = i+8) {
				char c = (char)Integer.parseInt(sb.substring(i, i+8), 2);
				result.append(c);
			}
			
			System.out.printf("#%d %s\n", test, result.toString());
		}
	}
}
