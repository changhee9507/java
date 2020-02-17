package staticClass;

public class StaticOuterClass {
	
	static class StaticClass{
		int MAX_NUM = 100;
		static int STATIC_MAX_NUM = 200;
	}
	
	void m1() {
		//StaticClass.MAX_NUM = 400; /* 객체 생성없이 접근 불가 */
		StaticClass.STATIC_MAX_NUM = 300; /* 스태틱이기 때문에 접근 가능 */
		StaticClass sc = new StaticClass();
		sc.MAX_NUM = 500;
		sc.STATIC_MAX_NUM = 600;
	}
}
