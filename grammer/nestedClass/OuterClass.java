package nestedClass;

public class OuterClass {
	int outerInt = 10;
	void outerMethod1() {
		/*System.out.println("innerInt : " + innerInt);*/ /* 내부 클래스의 멤버변수에는 접근 불가능 */
		System.out.println("outerInt : " + outerInt);
		Inner1 inner1 = new Inner1(); /* 객체를 생성해야 내부 클래스의 멤버 변수에 접근 가능 */
		System.out.println("innerInt : " + inner1.innerInt);
	}
	
	class Inner1{
		int innerInt = 20;
		void innerMethod1() {
			System.out.println("innerInt : " + innerInt);
			System.out.println("outerInt : " + outerInt); /* 내부클래스에서는 밖 클래스의 멤버변수에 접근 가능 */
		}
		
	}
	
	/* 멤버함수 안의 클래스*/
	void outerMethod2() {
		class Inner2{
			int innerInt = 30;
			void innerMethod2() {
				System.out.println("outerInt : " + outerInt);
				System.out.println("innerInt : " + innerInt);
			}
		}
		
		
		Inner2 inner2 = new Inner2();
		inner2.innerMethod2();
	}
}