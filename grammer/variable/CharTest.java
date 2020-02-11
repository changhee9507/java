package variable;

public class CharTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char testChar = 'A';	     // char ch = 65;         
		int testInt = (int)testChar;  // ch에 저장된 값을 int타입으로 변환하여 저장한다.

		System.out.printf("%c=%d(%#X)%n", testChar, testInt, testInt); 

		
		char HangleChar = '윤';     // char hch = 0xAC00;
		System.out.printf("%c=%d(%#X)%n", HangleChar, (int)HangleChar, (int)HangleChar);
		
		
		/* 특수 문자 */
		
		System.out.println('\'');		     //  '''처럼 할 수 없다.
		System.out.println("abc\t123\b456"); // \b에 의해 3이 지워진다.
		System.out.println('\n');		     //  개행(new line)문자 출력하고 개행
		System.out.println("\"Hello\"");	 //  큰따옴표를 출력하려면 이렇게 한다.
		System.out.println("c:\\");
		
	}

}
