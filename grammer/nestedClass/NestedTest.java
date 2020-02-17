package nestedClass;

import nestedClass.OuterClass.Inner1;

public class NestedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass outer = new OuterClass();
		outer.outerMethod1();
		OuterClass.Inner1 inner1 = new OuterClass().new Inner1(); /* 내부 클래스를 밖에서 사용하는 방법 */
		inner1.innerMethod1();
	} 
}
