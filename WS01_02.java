package wsjava;

import java.util.Scanner;

public class WS01_02 {

	static int requiredWinNum = 0;
	static int comWinNum = 0;
	static int userWinNum = 0;
	static Scanner scanner = new Scanner(System.in); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요. ");
		
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
				System.out.println("### 컴퓨터 승리!");
				return;
			}
			else if(userWinNum == requiredWinNum) {
				System.out.println("### 유저 승리!");
				return;
			}
			else {
				continue;
			}
		}
		
	}

	private static void game() {
		// TODO Auto-generated method stub
		System.out.print("가위바위보 중 하나 입력: ");
		String userInput = scanner.next();
		
		int comRPS = (int) (Math.random() * 3) + 1;
		int userRPS = 0;
		
		switch(userInput) {
		case "가위": userRPS = 1; break;
		case "바위":
		case "주먹": userRPS = 2; break;
		case "보" : userRPS = 3; break;
		default:
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		if(comRPS == userRPS) {
			System.out.println("무승부입니다. ");
		}
		else if( ((comRPS == 1) && (userRPS == 2))||
				 ((comRPS == 2) && (userRPS == 3)) ||
				 ((comRPS == 3) && (userRPS == 1))) {
			System.out.println("이겼습니다! ");
			userWinNum++;
		}
		else {
			System.out.println("졌습니다! ");
			comWinNum++;	
		}
		return;
}
}