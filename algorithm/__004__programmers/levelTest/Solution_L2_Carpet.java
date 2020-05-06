/**
 * 
 * 
 * @author Changhee Yoon
 */
package __004__programmers.levelTest;

public class Solution_L2_Carpet {

	public static void main(String[] args) {
		int brown = 10;
		int red = 2;
		
		System.out.println(solution(brown, red));
	}

	public static int[] solution(int brown, int red) {
		double total = brown + red;
		
		for(int height=3; height<total/2; height++) {
			if( (int)(total % height) == 0) {
				int width = (int) (total / height);
				
				int brownNum = height * 2 + (width-2) * 2;
				
				if(brownNum == brown) {
					int [] answer ={width,height};
					
					return answer;
				}
			}
		}
		return null;
		
    }
}