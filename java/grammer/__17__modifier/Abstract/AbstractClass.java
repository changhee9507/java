/**
 * 추상 클래스는 추상 메서드를 가지고 있는 클래스이다.
 * 추상 클래스는 객체 생성을 할 수 없고 상속을 통해서 그것이 반드시 재정의 되어야 한다. 
 * 
 */

package __17__modifier.Abstract;

public abstract class AbstractClass { /* 추상 메서드를 만들기위해서는 클래스 선언에서 abstract 필요 */
	String name;
	static int MAX_NUM;
	
	abstract void m1();
	
	void m3() {
		System.out.println("method is called!");
	}
}
