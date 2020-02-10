package javauitil.scanner;

import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("|"+scanner.next()+"|"); /* next, nextInt는 공백이 포함되지 않는다*/
		System.out.println("|"+scanner.nextLine() +"|"); /* 공백을 포함한다. */
	}

}
