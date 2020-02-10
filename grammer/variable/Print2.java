package variable;

public class Print2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello, World!";

		/* e* 은 10^* */
		float f1 = .10f;   // 0.10
		float f2 = 1e1f;   // 10.0
		float f3 = 3.14e3f;// 3140
		double d = 1.23456789;

		/*
		 * f는 6자리까지 출력하고 7자리에서 반올림, e는 지수 출력, g는 간략한 출력
		 * */
		System.out.printf("f1=%f, %e, %g%n", f1, f1, f1); 
		System.out.printf("f2=%f, %e, %g%n", f2, f2, f2); 
		System.out.printf("f3=%f, %e, %g%n", f3, f3, f3);

		System.out.println();
		System.out.printf("d=%f%n", d);
		System.out.printf("d=%14.10f%n", d); // 전체 14자리 중 소수점 10자리
		System.out.printf("d=%.10f%n", d);   // 뒤만 적으면 소수점 10자리 출력 
		
		System.out.println();
		System.out.printf("[12345678901234567890]%n");
		System.out.printf("[%s]%n", str); 
		System.out.printf("[%20s]%n", str);  // 20칸 오른쪽으로 부터 출력
		System.out.printf("[%-20s]%n", str); // 왼쪽에서 부터 출력
		System.out.printf("[%.8s]%n", str);  // * 왼쪽에서 8글자만 출력
	}

}
