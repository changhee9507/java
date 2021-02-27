/**
 * 찾기
 * 
 * 요약: 
 * 
 * 메모: 전체 문자열을 Text, 찾고자 하는 문자열을 Pattern 이라고 표현하며
 * 		Text에 Pattern이 몇번 어디에 위치하는지 알아내는 문제를 문자열 매칭이라고 한다.
 * 		brute-force에서  나가서 좀 더 복잡한 알고리즘(KMP)을 통해서 시간복잡도을 개선하여 해결한다.
 * 
 * 		이전에 비교했던 정보를 바탕으로 불필용한 반복을 줄이는 것이 핵심이다.
 * 
 * @author Changhee Yoon
 */
package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_1786 {
	
	static LinkedList<Integer> locs = new LinkedList<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		String pattern = br.readLine();
		
		KMP(text, pattern);

		System.out.println(locs.size());
		while(!locs.isEmpty()) {
			System.out.print(locs.poll() + " ");
		}
	}

	
	// 실패테이블
	static int[] getPi(String pattern) {
		// 접두사와 접미사가 일치하는 최대길이를 담을 배열 선언
		int[] pi = new int[pattern.length()];

		// idx
		int j = 0;
		// i,j가 가리키는 값이 일치하면 둘다 증가
		// 불일치하면 i만 증가시켜야 하므로 for문
		for (int i = 1; i < pattern.length(); i++) {

			// pattern 내에서 i와 j가 가리키는 값이 다를때
			//while문안에 넣는 이유는 중간단계를 건너뛰고 최대한으로 점프하려고
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				//j의 값을 한칸 뺀곳의 값으로 j를 바꿈
				j = pi[j - 1];
			}
			// pattern 내에서 i와 j가 가리키는 값이 같으면
			if (pattern.charAt(i) == pattern.charAt(j)) {
				// i번째의 최대길이는 ++j한 값
				pi[i] = ++j;
			}
		}

		return pi;
	}
	
	static void KMP(String text, String pattern) {
		int[] table = getPi(pattern);
		
		int j = 0; 
		for(int i = 0 ; i< text.length(); i++) {
			while(j >0 && text.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			//부모와 패턴이 일치한다면
			if(text.charAt(i) == pattern.charAt(j)) {
				//j의 값이 패턴의 길이-1이라면 한번 다찾은거니까
				//찾아다고 처리
				if(j == pattern.length()-1) {
					locs.offer((i-pattern.length()+1)+1);
					//패턴을 또 찾기 위해서
					j = table[j];
				}else {
					//다찾은건아니라면 계속 진행해야하므로 j값 증가
					j++;
				}
			}
		}
		
	}
	
}
