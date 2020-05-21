/**
 * 문자열 내 마음대로 정렬하기
 * 
 * 메모: Comparator 사용법이 아직 미숙하다
 * 
 * 		문제의 조건을 제대로 읽지 않아서 오류가 발생하는 경우가 아직 많다 조심하자.
 * 
 * 		compare이나 compareTo 같은 경우 왼쪽(처음)이 오른쪽보다 크면 양수가 리턴되며
 * 		음수가 아닌 경우 교환이 일어나는 방식으로 오름차순을 만든다.
 * 		이것을 생각해서 비교 위치를 설정해야 한다.
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_L1_StringSort {

	public static void main(String[] args) {
		
		String[] strings = {"abce", "abcd", "cdx", "abce", "abcd", "cdx"};
		int n = 2;
		System.out.println(Arrays.toString(solution(strings, n)));
	}

	public static String[] solution(String[] strings, int n) {
        
		Arrays.sort(strings,new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.charAt(n) == s2.charAt(n)) {
					return s1.compareTo(s2);
				}else {
					return Character.compare(s1.charAt(n), s2.charAt(n));
				}
			}
		});
		
        return strings;
    }
}