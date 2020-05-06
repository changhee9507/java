/*
 * 월드컵
 * 
 */
package __002__baekjoon;

import java.util.Scanner;

public class Main_6987 {

	static int[][] results = new int[6][3];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] answer = new int[4];

		for (int test = 0; test < 4; test++) {
			for (int i = 0; i < 6; i++) {
				results[i][0] = sc.nextInt();
				results[i][1] = sc.nextInt();
				results[i][2] = sc.nextInt();
				// System.out.println(Arrays.toString(results[i]));
			}
			// System.out.println();

			answer[test] = check(results);
		}

		System.out.printf("%d %d %d %d", answer[0], answer[1], answer[2], answer[3]);

	}

	static int[] pairNum = { 0, 0, 1, 3, 6, 10, 15 };

	private static int check(int[][] results) {

		int drawCnt = 0;
		int winCnt = 0;
		int loseCnt = 0;
		int drawTeamCnt = 0;
		int winTeamCnt = 0;
		int loseTeamCnt = 0;

		int maxWin = -1;
		int maxLose = -1;

		for (int i = 0; i < 6; i++) {
			winCnt += results[i][0];
			if (results[i][0] != 0) {
				winTeamCnt++;
			}
			if (results[i][0] > maxWin) {
				maxWin = results[i][0];
			}

			drawCnt += results[i][1];
			if (results[i][1] != 0) {
				drawTeamCnt++;
			}

			loseCnt += results[i][2];
			if (results[i][2] != 0) {
				loseTeamCnt++;
			}
			if (results[i][2] > maxLose) {
				maxLose = results[i][2];
			}

			if (results[i][0] + results[i][1] + results[i][2] != 5) {
				return 0;
			}
		}
//
//		System.out.println("win: " + winCnt);
//		System.out.println("lose: " + loseCnt);
//		System.out.println("draw: " + drawCnt);
//		
//		System.out.println("winTeamCnt: " + winTeamCnt);
//		System.out.println("loseTeamCnt: " + loseTeamCnt);
//		System.out.println("drawTeamCnt: " + drawTeamCnt);
//		
//		System.out.println("maxWin: " + maxWin);
//		System.out.println("maxLose: " + maxLose);

		if (winCnt + drawCnt + loseCnt != 30) {
			return 0;
		} else if (winCnt != loseCnt) {
			return 0;
		} else if (pairNum[drawTeamCnt] < drawCnt / 2) {
			return 0;
		} else {
			return 1;
		}
		
	}

}
