/**
 * 간단한 압축 풀기
 * 
 * 요약: 문자열의 압축 값을 받아서 원래의 문자열로 되돌려 출력
 * 
 * 메모:
 * 
 * @author Changhee Yoon
 * 문제 출처 : SW Expert Academy 
 *  */

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1946 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());

		for (int test = 1; test <= TESTCASE; test++) {
			StringBuilder sb = new StringBuilder();
			int charNum = Integer.parseInt(br.readLine());
			for (int i = 0; i < charNum; i++) {
				String[] tmp = br.readLine().split(" ");

				for (int j = 0; j < Integer.parseInt(tmp[1]); j++) {
					sb.append(tmp[0]);
				}
			}

			System.out.printf("#%d\n", test);
			
			for (int i = 0; i < (sb.length() / 10) + 1; i++) {
				if (i == (sb.length() / 10)) {
					System.out.println(sb.substring(i * 10));
				} else {
					System.out.println(sb.substring(i * 10, i * 10 + 10));
				}
			}

		}

	}

}
