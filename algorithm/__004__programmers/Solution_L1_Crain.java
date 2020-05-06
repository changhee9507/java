package __004__programmers;

import java.util.Arrays;

public class Solution_L1_Crain {

	static int[] tops;
	static int[] basket = new int[1000];
	static int basketTop;
	static int score;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(solution(board, moves));
	}

	static public int solution(int[][] board, int[] moves) {

		tops = new int[board.length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (j == board.length - 1 && board[j][i] == 0) {
					tops[i] = -1;
				} else {
					if (board[j][i] != 0) {
						tops[i] = j;
						break;
					}
				}
			}
		}

		for(int loc : moves) {
			putIn(pick(loc - 1, board));
		}
		
		System.out.println(Arrays.toString(tops));

		return score;
	}
	
	static public int pick(int loc, int[][] board) {
		if(tops[loc] == -1) {
			return -1;
		}else {
			int item = board[tops[loc]][loc];
			board[tops[loc]][loc] = 0;
			tops[loc]++;
			if(tops[loc] == board.length) {
				tops[loc] = -1;
			}
			return item;
		}
	}
	
	static public void putIn(int item) {
		if(item == -1) {
			return;
		}else {
			if(basketTop == 0){
				basket[basketTop] = item;
				basketTop++;
			}else {
				if(item == basket[basketTop-1]) {
					score = score +2;
					basket[--basketTop] = 0;
				}else {
					basket[basketTop] = item;
					basketTop++;
				}
			}
			
			
		}
		
	}
}
