package __02__operator;

public class OperatorTest {

	public static void main(String[] args) {
		//exercise1();
		//exercise2();
	}
	
	/* ++, -- 연산자 테스트
	 *  
	 * 코드 내에서 ++나 --가 먼저오면 일단 증감을 먼저 실행한 다음 코드를 실행하고
	 * 뒤에 오면 코드 실행 이후에 증감이 일어난다
	 * 
	 * 한줄에 여러개가 쓰이면 혼란스러운데 코드내에서 증감이 여러번 일어나게 된다 (앞에서 증감이 일어나고 같은 변수가 뒤에 쓰이면 증감이 적용된다)
	 */
	public static void exercise1() {
		int i = 7;
		System.out.println(i++); /* 참조 이후 증가*/
		System.out.println(i);
		System.out.println();
		
		System.out.println(++i); /* 참조 이전 증가*/
		System.out.println(i);
		System.out.println();
		
		System.out.println(i--); /* 참조 이후 감소*/
		System.out.println(i);
		System.out.println();
		
		System.out.println(--i); /* 참조 이전 감소*/
		System.out.println(i);
	
		int x = 5;
		
		System.out.println(x = x++ - ++x); /* 값은 -2, 증가가 식 안에서 두번 이루어 졌다*/
	}
	
	
	
	/* 사칙연산 테스트
	 *
	 * 특히 나누기에서 형 변환에 주의
	 * 타입은 큰 타입으로 변환이 기본이지만 int보다 작은 정수 타입은 int로 변환
	 */
	public static void exercise2() {
		
		int int1 = 27;
		int int2 = 5;

		System.out.printf("%d + %d = %d\n",  int1, int2, int1 + int2);
		System.out.printf("%d - %d = %d\n",  int1, int2, int1 - int2);
		System.out.printf("%d * %d = %d\n",  int1, int2, int1 * int2);
		System.out.printf("%d / %d = %d\n",  int1, int2, int1 / int2);
		System.out.printf("%d / %f = %f\n",  int1, (float)int2, int1 / (float)int2);	
	}
}
