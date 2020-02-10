/**
 * 
 * 
 * @author changhee Yoon
 */

package etc;

import java.util.Arrays;
import java.util.Scanner;

public class GoBackRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		final int TESTCASE = scanner.nextInt();

		for (int testCase = 1; testCase <= TESTCASE; testCase++) {

			int studentNum = scanner.nextInt();

			int[][] moveInfo = new int[studentNum][2];

			/* save the present room and destination */
			for (int i = 0; i < studentNum; i++) {
				moveInfo[i][0] = scanner.nextInt();
				moveInfo[i][1] = scanner.nextInt();
			}

			int[] roomRoute = new int[401];

			for (int i = 0; i < studentNum; i++) {
				int from = 0;
				int to = 0;

				/* 방 번호가 작은 곳에서 작은 곳으로 이동 */
				if (moveInfo[i][0] < moveInfo[i][1]) {
					/* set starting point */
					if (moveInfo[i][0] % 2 == 0) {
						from = moveInfo[i][0] - 1;
					} else {
						from = moveInfo[i][0];
					}

					/* set end point */
					if (moveInfo[i][1] % 2 == 0) {
						to = moveInfo[i][1];
					} else {
						to = moveInfo[i][1] + 1;
					}

					/* count */
					for (int j = from; j <= to; j++) {
						roomRoute[j]++;
					}
				}
				/* 방 번호가 큰 곳에서 작은 곳으로 이동 */
				else {
					
					/* set starting point */
					if (moveInfo[i][0] % 2 == 0) {
						from = moveInfo[i][0];
					} else {
						from = moveInfo[i][0]+1;
					}

					/* set end point */
					if (moveInfo[i][1] % 2 == 0) {
						to = moveInfo[i][1] - 1;
					} else {
						to = moveInfo[i][1];
					}
					
					/* count*/
					for (int j = from; j >= to; j--) {
						roomRoute[j]++;
					}
					
				}				
			}
			/* print roomRoute */
			
			int max = -1;
			for(int i=0; i<401; i++) {
				if(roomRoute[i] > max) {
					max = roomRoute[i];
				}
			}

			//System.out.println(Arrays.toString(roomRoute));
			System.out.printf("#%d %d\n", testCase, max);

		}
	}
}
