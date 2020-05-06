/**
 * 자카드 유사도
 * 
 * 메모: 문자열에서 공백이나 특수문자 등을 버리는 방법 확인  (char에 하나씩 접근하면서 부등호로 'a''A'등을 이용한다. 대소문자는 덜어져있다.)
 * 
 * 		중복을 허용하지 않은면 set 허용하면 map으로 접근하는 것이 좋다
 * 
 * 		map에서 접근은 key로 이루어지기 때문에 keySet으로 key들을 뽑아낸다음 접근하면 된다.
 * 
 * @author Changhee Yoon
 */
package __004__programmers.levelTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution_L2_Jacad {

	public static void main(String[] args) {

		String str1 = "aa1+aa2";
		String str2 = "AAAA12";

		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		int intersection = 0; /* 교집합 크기 */
		int union = 0; /* 합집합 크기 */

		/* 중복원소를 허용하기 때문에 맵 사용 */
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		/* 대소문자 구분을 없애며 알파벳인 경우에만 취급해서 저장 */
		for (int i = 0; i < str1.length() - 1; i++) {
			String tmp = str1.substring(i, i + 2);
			System.out.println("map1 " + tmp);
			tmp = tmp.toUpperCase();
			if ((tmp.charAt(0) >= 'A' && tmp.charAt(0) <= 'Z') && (tmp.charAt(1) >= 'A' && tmp.charAt(1) <= 'Z')) {
				if (map1.containsKey(tmp)) {
					map1.put(tmp, map1.get(tmp) + 1); /* 원래 존재하면 카운트를 올리면서 저장*/
				} else {
					map1.put(tmp, 1);
				}
			}
		}

		/* 두번째 문자열에서도 똑같이 */
		for (int i = 0; i < str2.length() - 1; i++) {
			String tmp = str2.substring(i, i + 2);
			System.out.println("map2 " + tmp);
			tmp = tmp.toUpperCase();
			if ((tmp.charAt(0) >= 'A' && tmp.charAt(0) <= 'Z') && (tmp.charAt(1) >= 'A' && tmp.charAt(1) <= 'Z')) {

				if (map2.containsKey(tmp)) {
					map2.put(tmp, map2.get(tmp) + 1);
				} else {
					map2.put(tmp, 1);
				}

			}
		}

		/* 만약 둘다 공집합이면 값은 1 */
		if (map1.size() == 0 && map2.size() == 0) {
			return 65536;
		}

		/* 아니면 교집합크기와 합집합 크기 계산 */
		Set<String> keys = map1.keySet(); /* 맵에서 하나씩 접근할때는 keySet를 가져온다*/

		for (String key : keys) { /* ketSet에서 하나씩 접근 */
			if (map2.containsKey(key)) { /* 둘다 포함한다면 교집합은 작은 수 합집합은 큰 수가 저장된다.*/
				if (map1.get(key) >= map2.get(key)) {
					union += map1.get(key);
					intersection += map2.get(key);
				} else { /* 두 맵에 포함되지 안흔다면 그냥 합집합에만 숫자를 추가하면 된다.*/
					union += map2.get(key);
					intersection += map1.get(key);
				}
			} else {
				union += map1.get(key);
			}
		}

		/*위와 동일한 과정이지만 이미 교집합은 계산되었기 때문에 남는 부분을 합집합에 계산해준다. */
		keys = map2.keySet();
		for (String key : keys) {
			if (map1.containsKey(key)) {
				continue;
			} else {
				union += map2.get(key);
			}
		}

		/* 결과 확인 */
		System.out.println(map1.toString());
		System.out.println(map2.toString());
		System.out.println(">> inter " + intersection);
		System.out.println(">> uni " + union);

		/* 조건에 맞게 값을 변환 */
		double answer = (double) intersection / (double) union;
		answer = Math.floor(answer * 65536);
		
		return (int) answer;
	}
}