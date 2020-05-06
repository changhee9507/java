/**
 * 시각 덧셈
 * 
 * 요약 : 시와 분으로 이루어진 두개의 인풋이 주어지고 더해서 시와 분으로 출력
 * 
 * 메모 : 숫자의 범위가 0-9가 아니라면 % 연산을 적절하게 사용하면 된다.
 * 		n으로 %를 계산하면 n개의 선택권이 생기고 미리 - 이후 +를 해주면 그 범위 조절이 가능하다
 * 
 * @author Changhee Yoon
 */

package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1976 {


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine()); 
		
		for(int testcase=1; testcase<=TESTCASE; testcase++) {
			String[] tmp = br.readLine().split(" ");
			
			int firstHour = Integer.parseInt(tmp[0]);
			int firstMin = Integer.parseInt(tmp[1]);
			int secondHour = Integer.parseInt(tmp[2]);
			int secondMin = Integer.parseInt(tmp[3]);
			
			int resoulMin = (firstMin + secondMin) % 60;
			int resultHour = ((firstHour + secondHour + (firstMin + secondMin) / 60 ) -1) % 12 + 1;
			
			System.out.printf("#%d %d %d\n",testcase,resultHour,resoulMin);
			
			
		}
		
	}

}
