package game;

import java.util.Scanner;

public class Tank {

	static char[][] map;
	static int tackRow = 0;
	static int tackCol = 0;
	static int height = 0;
	static int width = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		final int TESTCASE = scanner.nextInt();

		for (int testCase = 1; testCase <= TESTCASE; testCase++) {
			height = scanner.nextInt();
			width = scanner.nextInt();

			map = new char[height][width];

			/* 맵 정보 저장 */
			for (int i = 0; i < height; i++) {
				String inputString = scanner.next();
				for (int j = 0; j < width; j++) {
					map[i][j] = inputString.charAt(j);
					if (inputString.charAt(j) == '^' || inputString.charAt(j) == 'v' || inputString.charAt(j) == '<'
							|| inputString.charAt(j) == '>') {
						tackRow = i;
						tackCol = j;
					}

				}
			}

			/* 맵 출력 */
			/*
			 * for(int i = 0; i<height; i++) { for(int j = 0; j<width; j++) {
			 * System.out.print(map[i][j]); } System.out.println(); }
			 */

			int userControlNum = scanner.nextInt();
			String uerControl = scanner.next();

			for (int i = 0; i < userControlNum; i++) {
				action(uerControl.charAt(i));
			}

			System.out.printf("#%d ", testCase);
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

	}

	/* 상하좌우 */
	static int[] dRow = new int[] { -1, 1, 0, 0 };
	static int[] dCol = new int[] { 0, 0, -1, 1 };

	static void action(char c) {
		/*System.out.println(c);*/

		int newRow = 0;
		int newCol = 0;

		switch (c) {
		case 'U':
			newRow = tackRow + dRow[0];
			newCol = tackCol + dCol[0];

			if (newRow < 0 || map[newRow][newCol] != '.') {
				map[tackRow][tackCol] = '^';
			} else {
				map[newRow][newCol] = '^';
				map[tackRow][tackCol] = '.';
				tackRow = newRow;
				tackCol = newCol;
			}
			break;
		case 'D':
			newRow = tackRow + dRow[1];
			newCol = tackCol + dCol[1];

			if (newRow >= height || map[newRow][newCol] != '.') {
				map[tackRow][tackCol] = 'v';
			} else {
				map[newRow][newCol] = 'v';
				map[tackRow][tackCol] = '.';
				tackRow = newRow;
				tackCol = newCol;
			}
			break;
		case 'L':
			newRow = tackRow + dRow[2];
			newCol = tackCol + dCol[2];

			if (newCol < 0 || map[newRow][newCol] != '.') {
				map[tackRow][tackCol] = '<';
			} else {
				map[newRow][newCol] = '<';
				map[tackRow][tackCol] = '.';
				tackRow = newRow;
				tackCol = newCol;
			}
			break;
		case 'R':
			newRow = tackRow + dRow[3];
			newCol = tackCol + dCol[3];

			if (newCol >= width || map[newRow][newCol] != '.') {
				map[tackRow][tackCol] = '>';
			} else {
				map[newRow][newCol] = '>';
				map[tackRow][tackCol] = '.';
				tackRow = newRow;
				tackCol = newCol;
			}
			break;
		case 'S':
			switch (map[tackRow][tackCol]) {
			case '^':
				newRow = tackRow + dRow[0];
				newCol = tackCol + dCol[0];
				while (true) {
					if (newRow < 0)
						break;
					else if (map[newRow][newCol] == '.' || map[newRow][newCol] == '-')
						newRow = newRow + dRow[0];
					else if (map[newRow][newCol] == '*') {
						map[newRow][newCol] = '.';
						break;
					} else {
						break;
					}
				}
				break;
			case 'v':
				newRow = tackRow + dRow[1];
				newCol = tackCol + dCol[1];
				while (true) {
					if (newRow >= height)
						break;
					else if (map[newRow][newCol] == '.'|| map[newRow][newCol] == '-')
						newRow = newRow + dRow[1];
					else if (map[newRow][newCol] == '*') {
						map[newRow][newCol] = '.';
						break;
					} else {
						break;
					}
				}
				break;
			case '<':
				newRow = tackRow + dRow[2];
				newCol = tackCol + dCol[2];
				while (true) {
					if (newCol < 0)
						break;
					else if (map[newRow][newCol] == '.'|| map[newRow][newCol] == '-')
						newCol = newCol + dCol[2];
					else if (map[newRow][newCol] == '*') {
						map[newRow][newCol] = '.';
						break;
					} else {
						break;
					}
				}
				break;
			case '>':
				newRow = tackRow + dRow[3];
				newCol = tackCol + dCol[3];
				while (true) {
					if (newCol >= width)
						break;
					else if (map[newRow][newCol] == '.'|| map[newRow][newCol] == '-')
						newCol = newCol + dCol[3];
					else if (map[newRow][newCol] == '*') {
						map[newRow][newCol] = '.';
						break;
					} else {
						break;
					}
				}
				break;
			}
			break;
		}
		
		/* 맵 출력 */
		/*for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
		
	}
}
