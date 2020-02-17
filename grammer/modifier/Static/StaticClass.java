/**
 * static을 사용하면 객체의 생성없이 접근할 수 있고 타입에 따라 초기화가 이루어진다.
 *  
 * static함수에는 static 변수만 파라미터로 받지 않고 접근가능하다.
 * 
 * 
 */

package modifier.Static;

public class StaticClass {

	public static int MIN_NUM = 100;
	public int MAX_NUM = 999;
	
	public static void method1() { 
		MIN_NUM = 111;
		//MAX_NUM = 222;
		} /* static함수에 static이 아닌 변수는 올 수 없다. */
	public void method2() {
		MIN_NUM = 222;
		MAX_NUM = 111;
	}
}
