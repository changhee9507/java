/* 인터페이스
 * 
 * 인터페이스는 일종의 추상클래스이지만 더욱 추상화되어 상수와 abstact 함수만을 가진다
 * 
 * 보통 기능의 구현을 위해서 사용되기 때문에 이름도 ~able 형식으로 붙는 경우가 많다
 * 
 * 인터페이스는 다른 인터페이스를 상속 받을 수 있으며 클래스는 인터페이스를 implements로 구현한다
 * 
 * 클래스는 다중으로 인터페이스 구현이 가능하다 단일 상속과 대조적이다
 * 
 * 인터페이스 이름도 클래스의 이름처럼 타입이 될 수 있으며 인스턴스는 해당 인터페이스를 구현한 클래스의 인스턴스가 오면된다.
 * 
 * [디폴트 메서드]는 인터페이스에 함수를 추가하고 싶지만 해당 인터페이스를 구현한 모든 클래스가 해당 함수를 구현해야되는
 * 부담을 주고 싶지 않을때 추가할 수 있는 함수이다. default를 앞에서 명시한다.
 * 
 * 
 * 
 * @Changhee Yoon
 */

package __06__oop;

public interface Connectable {

	public static final String connectionType = "wifi"; /* static 상수를 public으로 선언해야 한다 */
	public abstract void wifiOn(); /* 추상함수를 public으로 선언해야 한다 */

	void method(); /* 앞에 public abstact을 생략할 수 있다 */
	default void newMethod(){}; /* 디폴트 메서드 JDK1.8에서 추가 */
	
}
