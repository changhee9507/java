package variable;

public class Printf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 77;
		
		System.out.printf("x = %d\n", x);		  // 10진수 출력
		System.out.printf("x = %o = %#o\n", x,x); // 8진수 출력
		System.out.printf("x = %x = %#x\n", x,x); // 16진수 출력
		
		System.out.printf("x = [%5d]\n", x); 	// 다섯칸 뒤로 정렬		
		System.out.printf("x = [%-5d]\n", x);	// 앞으로 정렬
		System.out.printf("x = [%05d]\n", x);	// 0으로 채우기
		
		
		
		
	}

}
