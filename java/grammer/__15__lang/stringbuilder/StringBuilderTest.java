/**
 * 
 * 문자열을 계속 추가시키는 상황에서 String보다 유리
 * StringBuilder는 원래의 스트링이 자체 수정되는 성질이 강하다 -> 보존보다는 수정에 초점을 둔 클래스
 * 
 */

package __15__lang.stringbuilder;

public class StringBuilderTest {

	public static void main(String[] args) {
	
		StringBuilder sb1 = new StringBuilder();
		String end = "!!";
		sb1.append("Hello").append(" World").append(end);
		System.out.println(sb1);
	
		/* insert */
		
		StringBuilder sb2 = new StringBuilder("abacasder");
		sb2.insert(5, "123");
		System.out.println(sb2); 
		
		/* setCharAt */
		
		StringBuilder sb3 = new StringBuilder("abcdefgh");
		sb3.setCharAt(5, 'X');	/* 해당인덱스의 문자를 교체 */
		System.out.println(sb3);
		
		/* reverse */
		
		StringBuilder sb4 = new StringBuilder("123456789");
		sb4.reverse();	/* 문자열의 순서를 뒤바꿈 */
		System.out.println(sb4);
				
		/* setLength */
		
		StringBuilder sb5 = new StringBuilder("123456789");
		sb5.setLength(5); /* 문자열의 길이를 설정, 0으로 하면 초기화의 효과 */
		System.out.println(sb5);
		
	}
}
