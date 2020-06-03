package __002__baekjoon.step1_IO;

import java.util.Scanner;

public class Main_2588_곱셈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		String num1 = scanner.next();
		String num2 = scanner.next();
		
		System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2.substring(2,3)));
		System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2.substring(1,2)));
		System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2.substring(0,1)));
		System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2));
	}

}
