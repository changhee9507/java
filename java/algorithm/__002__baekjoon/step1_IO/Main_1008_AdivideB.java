/**
 * A/B
 * 
 * 메모: 큰 숫자이거나 오차와 관련되어 있다면 double의 활용을 고려해보자
 */
package __002__baekjoon.step1_IO;

import java.util.Scanner;

public class Main_1008_AdivideB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double num1 = scan.nextInt();
		double num2 = scan.nextInt();
		
		System.out.print(num1/num2);
	}

}
