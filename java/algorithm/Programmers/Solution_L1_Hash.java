/**
 * 완주하지 못한 선수
 * 
 * 요약: 문자열의 배열과 그 배열에서 하나의 문자열이 빠진 배열이 주어졌을 때 빠진 문자열 출력
 * 
 * 메모: set,map을 사용할 수 있는 경우 훨씬 큰 성능 상향을 가져온다
 * 
 * @author Changhee yoon
 */
package Programmers;

import java.util.HashSet;
import java.util.Stack;

public class Solution_L1_Hash {

	public static void main(String[] args) {

		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		System.out.println(solution(participant, completion));
	}

	static public String solution(String[] participant, String[] completion) {

		HashSet<String> set = new HashSet<String>();
		Stack<String> sameNames = new Stack<String>();
		
		for (int i = 0; i < participant.length; i++) {
			if(!set.contains( participant[i])) {
				set.add(participant[i]);
			}else { /* 동명 이인 */
				sameNames.push(participant[i]);
			}
			
		}
		for (int i = 0; i < completion.length; i++) {
			if(set.contains( completion[i]) ) {
				set.remove(completion[i]);
			}else {
				sameNames.remove(completion[i]);
			}
		}

		if(sameNames.size() != 0) {
			return sameNames.pop();
		}else {
			for(String name : set) {
				return name;
			}
		}
		
		return null;
	}
}
