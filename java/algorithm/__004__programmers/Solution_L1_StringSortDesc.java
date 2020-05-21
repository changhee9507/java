/**
 * 요약: 문자열의 각 char을 내림차순으로 정렬해서 새로운 문자열 생성
 * 
 * 메모: 대문자의 유니코드?가 소문자보다 작다. 정렬은 항상 배열이나 컬렉션의 자료구조에 클래스나 일반 자료형으로 담은다음
 * 		comparater나 comparable을 이용하면 된다.
 * 
 * 		comparater를 사용할때 <>안에 객체이름을 명시해야 되기 때문에 char대신 Character같은 형식이어야한다.		
 * 
 * @author Changhee Yoon
 */
package __004__programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_L1_StringSortDesc {

	public static void main(String[] args) {

		String s = "Zbcdefg"; 
		
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
        int a = 'a';
        int A = 'A';
        System.out.println(a + " " + A);
		Character[] chars = new Character[s.length()];
		for(int i=0; i<s.length(); i++) {
			chars[i] = s.charAt(i);
		}
        
        Arrays.sort(chars, new Comparator<Character>() {
        	@Override
        	public int compare(Character o1, Character o2) {
        		return o2.compareTo(o1);
        	}
        });
        
        for(int i=0; i<chars.length; i++) {
        	sb.append(chars[i]);
        }
        
        return sb.toString();
    }
}