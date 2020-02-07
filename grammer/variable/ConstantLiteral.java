package variable;

public class ConstantLiteral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int octNum = 010;  // 8진수, 출력하면 8
		int hexNum = 0x10; // 16진수, 출력하면 16
		int binNum = 0b10; // 2진수, 출력하면 2
		
		System.out.println(octNum); // 8
		System.out.println(hexNum); // 16
		System.out.println(binNum); // 2

		
		//float fl = 3.14; 3.14는 기본적으로 double 타입이므로 컴파일 에러
		float fl = 3.14f; // 뒤에 f,F,d 같은 접미사를 통해서 타입 변환 가능
		
		System.out.println(fl);
		
		byte by = 65; // 리터럴은 int이지만 byte, short는 리터럴이 존재하지 않아서 범위만 속하면 저장 가능
		short s = 123;
		
	}

}
