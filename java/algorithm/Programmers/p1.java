package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p1 {

	public static void main(String[] args) {
		String[] purchase = { "2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000" };

		Solution s = new Solution();

		System.out.println(s.solution(purchase));
	}

///////////////////////////////////////////////////////////////
	static class Solution {

		public int[] solution(String[] purchase) {
			int[] money = new int[366];
			int[] sum = new int[366];
			int[] dateNum = new int[13];
			int[] answer = new int[5];
			dateNum[0] = 0;
			dateNum[1] = 31;
			dateNum[2] = 28;
			dateNum[3] = 31;
			dateNum[4] = 30;
			dateNum[5] = 31;
			dateNum[6] = 30;
			dateNum[7] = 31;
			dateNum[8] = 31;
			dateNum[9] = 30;
			dateNum[10] = 31;
			dateNum[11] = 30;
			dateNum[12] = 31;

			for (int i = 0; i < purchase.length; i++) {
				int month = Integer.parseInt(purchase[i].substring(5, 7));
				int date = Integer.parseInt(purchase[i].substring(8, 10));
				int pay = Integer.parseInt(purchase[i].substring(11));
				int period = 0;

				/* 날짜 계산 */
				for (int j = 0; j < month; j++) {
					period += dateNum[j];
				}
				period += date;

				/* 30일간의 누적 결제액 계산 */
				for (int j = period; j < period + 30; j++) {

					if (j > 365) {
						break;
					} else {
						money[j] += pay;
					}
				}
			}
			
			for(int i=1; i<=365; i++) {
				if(money[i] < 10000) {
					answer[0]++;
				}else if(money[i] < 20000) {
					answer[1]++;
				}else if(money[i] < 50000) {
					answer[2]++;
				}else if(money[i] < 100000) {
					answer[3]++;
				}else {
					answer[4]++;
				}
			}

			System.out.println(Arrays.toString(money));
			System.out.println(Arrays.toString(answer));
			
			return answer;
		}
///////////////////////////////////////////////////////////////
	}
}