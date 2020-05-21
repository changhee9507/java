package __004__programmers.set2;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem1 {

	public static void main(String[] args) {
		String input = "line [plus]";
		System.out.println(solution(input));
	}

	static public int solution(String inputString) {
        
		int[] cnts = new int[4]; /* 괄호 쌍의 카운트들 */
		int[] remains = new int[4]; /* 괄호가 열릴 때 +1, 닫힐 때 -1*/
	
		int strLength = inputString.length();
		boolean nomal = true; /* 정상적인 괄호입력인지 저장*/
		
		for(int i=0; i<strLength; i++) {
			switch(inputString.charAt(i)) {
			/* 여는 괄호가 들어오면 해당 카운트와 남은 숫자를 1증가 시킴  */
			case '(': cnts[0]++; remains[0]++; break;
			case '{': cnts[1]++; remains[1]++; break;
			case '[': cnts[2]++; remains[2]++; break;
			case '<': cnts[3]++; remains[3]++; break;
			/* 닫는 괄호가 들어오면 남은 숫자를 1 감소 시킴 , (남은 괄호가 없는데 들어오면 비정상임을 저장) */
			case ')': 
				if(remains[0] > 0) {
					remains[0]--; break;
				}else {
					nomal = false;
				}
				break;
			case '}':
				if(remains[1] > 0) {
					remains[1]--; break;
				}else {
					nomal = false;
				}
				break;
			case ']':
				if(remains[2] > 0) {
					remains[2]--; break;
				}else {
					nomal = false;
				}
				break;
			case '>': 
				if(remains[3] > 0) {
					remains[3]--; break;
				}else {
					nomal = false;
				}
				break;
			}
		}
		/* 비정상적인 입력이 있었다면 return -1*/
		if(!nomal) {
			return -1;
		}
		
		/* 남은 괄호가 있다면 비정상*/
		for(int i=0; i<cnts.length; i++) {
			if(remains[i] != 0) {
				return -1;
			}
		}
		
		/* 정상적이라면 괄호의 카운트를 모두 더해서 리턴 */
		int sum = 0;
		for(int i=0; i<cnts.length; i++) {
			sum += cnts[i];
		}
		return sum;
		
    }
}
