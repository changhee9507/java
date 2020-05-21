/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.set4;

import java.util.Arrays;

public class Solution_p1 {

	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		
		//System.out.println(solution(numbers, hand));
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		int[][] map = new int[10][2];
		map[1] = new int[]{0,0};
		map[2] = new int[]{0,1};
		map[3] = new int[]{0,2};
		map[4] = new int[]{1,0};
		map[5] = new int[]{1,1};
		map[6] = new int[]{1,2};
		map[7] = new int[]{2,0};
		map[8] = new int[]{2,1};
		map[9] = new int[]{2,2};
		map[0] = new int[]{3,1};
		
		Hand leftHand = new Hand(new int[] {3,0}); 
		Hand rightHand = new Hand(new int[] {3,2}); 
		
		for(int i=0; i<numbers.length; i++) {
			//System.out.println(">> num " + numbers[i]);
			//System.out.println(">> left loc" + Arrays.toString(leftHand.location));
			//System.out.println(">> right loc" + Arrays.toString(rightHand.location));
			
			
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer.append('L');
				leftHand.location = map[numbers[i]];
			}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer.append('R');
				rightHand.location = map[numbers[i]];
			}else {
				int leftDistance = Math.abs(leftHand.location[0]-map[numbers[i]][0]) + Math.abs(leftHand.location[1]-map[numbers[i]][1]);
				int rightDistance = Math.abs(rightHand.location[0]-map[numbers[i]][0]) + Math.abs(rightHand.location[1]-map[numbers[i]][1]);
				
				if(leftDistance > rightDistance) {
					answer.append('R');
					rightHand.location = map[numbers[i]];
				}else if (rightDistance > leftDistance) {
					answer.append('L');
					leftHand.location = map[numbers[i]];
				}else {
					if(hand.equals("left")) {
						answer.append('L');
						leftHand.location = map[numbers[i]];
					}else {
						answer.append('R');
						rightHand.location = map[numbers[i]];
					}
				}
			}
			
			//System.out.println(answer.toString());
		}
		
        return answer.toString();
    }
	
	static class Hand{
		int[] location;
		
		public Hand(int[] loc) {
			this.location = loc;
		}
	}
}