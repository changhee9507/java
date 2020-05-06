/**
 * 염라대왕의 이름 정렬
 * 
 * 요약 : 주어진 이름들을 우선 길이 순 오름차순으로 정렬하며 길이가 같다면 사전순이고 중복된 이름은 제거한다.
 * 
 * 메모 :	선택정렬을 하게 되면 n^2의 시간소요로 통과하지 못한다.
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_7701 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine().trim());
		
		for(int test=1; test<=TESTCASE; test++) {
			int NameAmount = Integer.parseInt(br.readLine().trim());
			
			String[] names = new String[NameAmount];
			for(int i=0; i<NameAmount; i++) {
				names[i] = br.readLine().trim();
			}
			
			System.out.println(Arrays.toString(names));
			
		}
		
	}
}
