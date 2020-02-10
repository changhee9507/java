package variable;

public class Printf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte  testByte = 7;
		short testShort = 77;
		char  testChar = 'A';

		int  testInt  = 7;
		long testLong = 100_000_000_000L; // _를 이용해서 큰 숫자를 가독성 높게 작성할 수 있다.
		long testHex  = 0xFFFF_FFFF_FFFF_FFFFL; // long hex = 0xFFFFFFFFFFFFFFFFL;

		int octNum = 010;  // 8진수 10, 10진수로는 8
		int hexNum = 0x10; // 16진수 10, 10진수로는 16
		int binNum = 0b10; // 2진수 10, 10진수로는 2

		System.out.printf("testByte = %d%n", testByte); // %d로 byte 출력 가능
		System.out.printf("testShort = %d%n", testShort);// %d로 short 출력 가능
		System.out.printf("testChar = %c, %d %n", testChar, (int) testChar); // 'A'를 인트로 변경하면 65. 		
		
		
		System.out.println();
		System.out.printf("testInt= %5d %n", testInt); // 다섯칸의 간격으로 출력, 오른쪽 정렬
		System.out.printf("testInt= %-5d %n", testInt);// 다섯칸의 간격으로 출력, 왼쪽 정렬
		System.out.printf("testInt= %05d %n", testInt);// 다섯칸의 간격으로 출력, 0 채우기
		
		
		System.out.println();
		System.out.printf("big=%d%n", testLong);
		System.out.printf("hex=%x%n", testHex); 
		
		/* %d는 10진수 저장을 어떻게 하든 상관없이 */
		System.out.println();
		System.out.printf("octNum=%#o, %o, %d%n", octNum, octNum, octNum); // '#'은 접두사(16진수 0x, 8진수 0)
		System.out.printf("hexNum=%#x, %x, %d%n", hexNum, hexNum, hexNum);
		System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum); // 이진수는 따로 지시자가 없어서 api를 사용해야 한다.
		
	}

}
