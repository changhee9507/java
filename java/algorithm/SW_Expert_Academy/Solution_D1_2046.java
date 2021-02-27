/**
 * 스탬프 찍기
 * 
 * 요약 : 입력 숫자 만큼 # 출력 
 * 
 * 메모 : 
 * 
 * @author Changhee Yoon
 */

package SW_Expert_Academy;

import java.util.Scanner;

public class Solution_D1_2046 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int StampNum = scan.nextInt();
		
		for(int i = 0; i<StampNum; i++) {
			System.out.print("#");
		}
		scan.close();
		
	}

}
