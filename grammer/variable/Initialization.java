
package variable;

public class Initialization {
	
	static int test1; /* 멤버 변수로 int를 선언하면 0으로 자동 초기화한다 */
	
	public static void main(String[] args) {
		/* 변수를 선언하고 초기화하는 다양한 방법 */
		int a;
		int b,c;
		int d = 3;
		int e = 4, f =5;
		
		a = 0;
		b = 1;
		c = 2;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(test1);	/* 지역변수에서는 에러이지만 멤버변수는 에러없이 실행*/
	}
}
