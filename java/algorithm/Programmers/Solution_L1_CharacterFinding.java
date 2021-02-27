/**
 * 
 * 
 * @author Changhee Yoon
 */
package Programmers;

public class Solution_L1_CharacterFinding {

	public static void main(String[] args) {

		String s = "pPoooyY";
		System.out.println(solution(s));
	}

	public static boolean solution(String s) {
		int pCnt = 0;
		int yCnt = 0;

		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case 'p':
			case 'P' : pCnt++; break;
			case 'y' :
			case 'Y' : yCnt++; break;
			}
		}
		
		if(pCnt == yCnt) {
			return true;
		}else{
			return false;
		}
	}
}