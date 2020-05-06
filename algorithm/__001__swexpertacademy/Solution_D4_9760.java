/**
 * Poker Game
 *  
 * 
 * @author Changhee Yoon
 */
package __001__swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_9760 {

	static String result;
	static Card[] deck;
	static int[] suitCounts;
	static int[] rankCounts;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TESTCASE = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=TESTCASE; test++) {
			suitCounts = new int[4];
			rankCounts = new int[13];
			
			String[] tmp = br.readLine().split(" ");
			
			deck = new Card[5];
			
			/* 인풋 저장 */
			for(int i=0; i<5; i++) {
				deck[i] = new Card(tmp[i].charAt(0), tmp[i].charAt(1));
			}
	
			switch(checkDeck()) {
			case 1: result = "Straight Flush"; break;
			case 2: result = "Four of a Kind"; break;
			case 3: result = "Full House"; break;
			case 4: result = "Flush"; break;
			case 5: result = "Straight"; break;
			case 6: result = "Three of a kind"; break;
			case 7: result = "Two pair"; break;
			case 8: result = "One pair"; break;
			case 9: result = "High card"; break;
			}
			
			System.out.printf("#%d %s\n",test, result);
			
			
		}
		
	}

	
	static int checkDeck() {
		
		/* suit, rank counting */
		for(int i=0; i<5; i++) {
			switch(deck[i].suit) {
			case 'S': suitCounts[0]++; break;
			case 'D': suitCounts[1]++; break;
			case 'H': suitCounts[2]++; break;
			case 'C': suitCounts[3]++; break;			
			}
			
			switch(deck[i].rank) {
			case 'A': rankCounts[0]++; break;
			case '2': rankCounts[1]++; break;
			case '3': rankCounts[2]++; break;
			case '4': rankCounts[3]++; break;
			case '5': rankCounts[4]++; break;
			case '6': rankCounts[5]++; break;
			case '7': rankCounts[6]++; break;
			case '8': rankCounts[7]++; break;
			case '9': rankCounts[8]++; break;
			case 'T': rankCounts[9]++; break;
			case 'J': rankCounts[10]++; break;
			case 'Q': rankCounts[11]++; break;
			case 'K': rankCounts[12]++; break;
			}
			
		}
		
		int maxSuitCount = 0;
		int maxSerialCount = 0;
		int maxRankCount = 0;
		
		/* 같은 수트에 속한 카드 최대 수 계산 */
		for(int i=0; i<4; i++) {
			if(suitCounts[i] > maxSuitCount) {
				maxSuitCount = suitCounts[i];
			}
		}
		
		/* 같은 랭크에 속한 카드 최대 수 계산*/
		for(int i=0; i<13; i++) {
			if(maxRankCount < rankCounts[i]) {
				maxRankCount = rankCounts[i];
			}
		}
		
		/* 연속적인 카드 숫자 계산 */
		for(int i=0; i<9; i++) {
			if(rankCounts[i] == 0) {
				continue;
			}else {
				int count = 0;
				for(int j=i; j<i+5; j++) {
					if(rankCounts[j] == 1) {
						count++;
					}else {
						if(maxSerialCount < count) {
							maxSerialCount = count;
						}
						break;
					}
				}
				if(maxSerialCount < count) {
					maxSerialCount = count;
				}
			}
		}
		
		
		/* Straight Flush */
		if(maxSuitCount == 5) {
			if(maxSerialCount == 5) {
				return 1;
			}else if(rankCounts[0] == 1 && rankCounts[9] == 1 && rankCounts[10] == 1 && rankCounts[11] == 1 && rankCounts[12] == 1) {
				return 1;
			}
		}
		
		/* Four of a Kind*/
		if (maxRankCount == 4) {
			return 2;
		}
		
		/* Full of House */
		if(maxRankCount == 3) {
			for(int i=0; i<13; i++) {
				if(rankCounts[i] == 2) {
					return 3;
				}
			}
		}
		
		/* Flush */
		if(maxSuitCount == 5) {
			return 4;
		}
		
		/* Straight */
		if(maxSerialCount == 5) {
			return 5;
		}
		
		/* Three of a kind*/
		if(maxRankCount == 3) {
			return 6;
		}
		
		
		if(maxRankCount == 2) {
			int pairCount = 0;
			for(int i=0; i<13; i++) {
				if(rankCounts[i] == 2) {
					pairCount++;
				}
			}
			/* Two pair */
			if(pairCount == 2) {
				return 7;
			}else if(pairCount == 1) {
				return 8;
			}
		}
		
		/* One pair */
		return 9;
	}
}

class Card{
	char suit;
	char rank;
	
	Card(char suit, char rank){
		this.suit = suit;
		this.rank = rank;
	}
}
