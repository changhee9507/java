/**
 * JungAl 1828 solution
 * 
 * @author Changhee Yoon
 */

package etc;

import java.util.Scanner;

public class Refrigerator {

	static int refNum = 0;
	static int[][] chemicalInfo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		final int chemicalNum = scanner.nextInt();
		
		chemicalInfo = new int[chemicalNum][3];
		
		/* 화학약품 온도 정보 저장*/
		for(int i =0; i<chemicalNum; i++) {
			chemicalInfo[i][0] = scanner.nextInt(); // 시작점
			chemicalInfo[i][1] = scanner.nextInt(); // 끝점
		}
		
				
		
		
		

	}

}
