package wsjava;

import java.util.Scanner;

public class WS01_02 {

	static int requiredWinNum = 0;
	static int comWinNum = 0;
	static int userWinNum = 0;
	static Scanner scanner = new Scanner(System.in); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println(">>���������� ������ �����մϴ�. �Ʒ� ���� �� �ϳ��� ������.");
		System.out.println("1. 5�� 3��");
		System.out.println("2. 3�� 2��");
		System.out.println("3. 1�� 1��");
		System.out.print("��ȣ�� �Է��ϼ���. ");
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1: requiredWinNum = 3; break;
		case 2: requiredWinNum = 2; break;
		case 3: requiredWinNum = 1; break;
		default: break;
		}
		
		while(true){
			game();
			if(comWinNum == requiredWinNum) {
				System.out.println("### ��ǻ�� �¸�!");
				return;
			}
			else if(userWinNum == requiredWinNum) {
				System.out.println("### ���� �¸�!");
				return;
			}
			else {
				continue;
			}
		}
		
	}

	private static void game() {
		// TODO Auto-generated method stub
		System.out.print("���������� �� �ϳ� �Է�: ");
		String userInput = scanner.next();
		
		int comRPS = (int) (Math.random() * 3) + 1;
		int userRPS = 0;
		
		switch(userInput) {
		case "����": userRPS = 1; break;
		case "����":
		case "�ָ�": userRPS = 2; break;
		case "��" : userRPS = 3; break;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		
		if(comRPS == userRPS) {
			System.out.println("���º��Դϴ�. ");
		}
		else if( ((comRPS == 1) && (userRPS == 2))||
				 ((comRPS == 2) && (userRPS == 3)) ||
				 ((comRPS == 3) && (userRPS == 1))) {
			System.out.println("�̰���ϴ�! ");
			userWinNum++;
		}
		else {
			System.out.println("�����ϴ�! ");
			comWinNum++;	
		}
		return;
}
}