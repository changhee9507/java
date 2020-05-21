package __01__variable;

public class VariableTest {

	public static void main(String[] args) {

		//Swap();
		//printf1();
		//printf2();
		//charToInt();
		//specialChar();
		//overflow();
		//floatTest();
		typeCasting();
	}

	/* 1. 저장된 값 교체 
	 * 
	 * 두 변수의 값을 교체하기 위해서는 tmp 라는 변수를 하나 더 선언해서
	 * 둘 중 하나의 값을 저장하게 만든 다음 실행한다. 
	 */
	
	public static void Swap() {
		
		int x = 7;
		int y = 24;
		int tmp = 0;
		
		System.out.println("x : " + x +" y : " + y);
		
		tmp = x; /* 1 = 2 */
		x = y;	 /*	2 = 3 */
		y = tmp; /* 3 = 1 */
		
		System.out.println("x : " + x +" y : " + y);
	}
	
	/* 2. printf 함수
	 * 
	 * 2진수는 특정 지시자가 없어서 Integer의 toBinaryString함수 사용
	 */
	public static void printf1() {
		byte  byte1 = 7;
		short short1 = 77;
		char  char1 = 'A';
		int  int1 = 1; 
		long long1 = 777_777_777_777L; /* L을 붙여서 타입 명시, _를 이용해서 가독성 높임 */ 
		long hex = 0xFFFF_FFFF_FFFF_FFFFL ; 
		int octNum = 010;/*8진수*/
		int hexNum = 0x10;/*16진수*/
		int binNum = 0b10;/*2진수*/

		System.out.printf("byte1 = %d%n", byte1);
		System.out.printf("short1 = %d%n", short1);
		System.out.printf("char1 = %c, %d %n\n", char1, (int)char1);
		
		System.out.printf("int1=[%5d]%n",  int1); /*5칸 사용 뒤로 정렬*/
		System.out.printf("int1=[%-5d]%n", int1); /*5칸 사용 앞으로  정렬 */
		System.out.printf("int1=[%05d]%n\n", int1); /*5칸 사용 뒤로 정렬 0으로 채움*/
		
		System.out.printf("long1 = %d%n", long1);
		System.out.printf("hex = %#x%n", hex); /*16진수형식으로 출력, #은 0x를 추가*/ 
		System.out.printf("octNum=%o, %d%n", octNum, octNum);/*8진수 형식 출력*/   
		System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);/* 16진수 형식 출력*/
		System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum); /* 2진수 형식 출력, 지시자가 없어서 Integer의 toBinaryString 함수 사용 */
		
	}
	
	/* 3. 실수와 String관련 printf함수 활용
	 * 
	 * %f는 소수점 6자리까지 출력, 7자리에서 반올림
	 * 
	 * %e는 소수점 6자리까지 출력하며 e(10의 지수승)이 포함된 형태
	 * 
	 * %g는 간략한 형태
	 */
	
	public static void printf2() {
		
		float float1 = .07f; // 소수점 표시에서는 앞에수 생략 가능
		float float2 = 7e1f;    // e*은 10의 *승을 의미
		float float3 = 7.77e3f; //
		double double1 = 1.23456789;

		System.out.printf("float1 = %f, %e, %g%n", float1, float1, float1);
		System.out.printf("float2 = %f, %e, %g%n", float2, float2, float2); 
		System.out.printf("float3 = %f, %e, %g%n%n", float3, float3, float3);

		System.out.printf("double1 = %f%n", double1);
		System.out.printf("double1 = %14.10f%n%n", double1);

		String testString = "abc";
		
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("[%s]%n", testString);
		System.out.printf("[%20s]%n", testString);
		System.out.printf("[%-20s]%n", testString);
		System.out.printf("[%.8s]%n", testString); // 왼쪽에서부터 8글자만
		
	}
	
	/* char에 대한 분석
	 */
	public static void charToInt() {
		char ch1 = 'A';	        
		int code = (int)ch1; 
		System.out.printf("%c = %d (%#X) %n", ch1, code, code); 

		char ch2 = '한';    
		System.out.printf("%c = %d (%#X) %n", ch2, (int)ch2, (int)ch2);
	}
	
	/* 특수 문자
	 */
	public static void specialChar() {
		
		System.out.println('\''); /* ' 출력 */
		System.out.println("abc\tdef\bghi"); /* 탭, 백 스페이스 */
		System.out.println("\"Hi\""); /* " 출력 */
		System.out.println("c:\\"); /* \출력 */
		
	}
	
	/* 오버플로우
	 * 
	 * 표현 범위를 넘어가는 비트는 버려진다
	 */
	public static void overflow() {
		short shortMin = -32768;
		short shortMax = 32767;
		char  charMin = 0;
		char  charMax = 65535;

		System.out.println("shortMin   = " + shortMin);
		System.out.println("shortMin-1 = " + (short)(shortMin-1));
		System.out.println("shortMax   = " + shortMax);
		System.out.println("shortMax+1 = " + (short)(shortMax+1));
		System.out.println("charMin   = " + (int)charMin);
		System.out.println("charMin-1 = " + (int)--charMin);
		System.out.println("charMax   = " + (int)charMax);
		System.out.println("charMax+1 = " + (int)++charMax);	
	}
	
	/* 실수의 출력과 오차 
	 * 
	 * float는 7자리 10진수를 오차없이 표현할 수 있고
	 * double은 15자리로 더 높은 정밀도를 가진다.
	 * 
	 * %f는 기본적으로 소수 7자리에서 반올림되서 6자리만 출력한다
	 * 
	 * %24.20f는 전체 24자리에서 20칸을 소수로 표현한다는 의미
	 * 
	 */
	public static void floatTest() {
		float  float1    = 7.12345678901234567890f;
		float  float2    = 7.2345678901234567890f;
		double double1   = 7.12345678901234567890d;

		System.out.printf("f  : %f%n", float1);
		System.out.printf("f  : %24.20f%n", float1);
		System.out.printf("f2 : %24.20f%n", float2);
		System.out.printf("d  : %24.20f%n", double1);
		
	}
	
	/* 형변환
	 * 
	 * double을 int로 형변환하면 소수는 버려진다
	 * 
	 * 형변환 연산자는 그 실제값을 수정하지는 않는다
	 * 
	 * 실수저장에서 타입의 정밀도에 따라서 버려지는 위치가 다르다(저장되는 값이 다르다)
	 * 그래서 같은 값을 저장하더라도 정밀도를 넘어서는 값이면 차이가 발생하며
	 * float에서 double로 형 변환을 하는 것은 그냥 비트의 복사이기 때문에 값이 동일하다 
	 * 
	 */
	
	public static void typeCasting() {
		/* part1 int와 double */
		double double1  = 77.77;
		int int1 = (int)double1;

		System.out.println("int1 = " + int1);
		System.out.println("double1 = " + double1);
		System.out.println();
		
		
		/* part2 byte와 int */
		System.out.printf("(int -> byte) i     = %d  -> b = %d%n", 77, (byte)77); 
		System.out.printf("(int -> byte) i     = %d -> b = %d%n", 777, (byte)777); 
		byte byte1 = 77;
		byte byte2 = -77;
		System.out.printf("(byte -> int) byte1 = %d  -> i = %d%n", byte1, (int)byte1); 
		System.out.printf("(byte -> int) byte2 = %d -> i = %d%n", byte2, (int)byte2); 
		System.out.println("-2 = "+Integer.toBinaryString(-2));
		System.out.println();
		
		/* part3 float과 double */
		float float1   = 7.1234567f;
		double double2  = 7.1234567;
		double double3 = (double)float1;

		System.out.printf("float         = %20.18f\n", float1);
		System.out.printf("double        = %20.18f\n", double2);
		System.out.printf("casted double = %20.18f\n", double3);
		
		
		
	}
}
