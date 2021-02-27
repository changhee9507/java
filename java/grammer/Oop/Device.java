/* 추상 클래스
 * 
 * abstact를 클래스 선언앞에 붙여준다
 * 
 * abstact함수가 존재하는 것을 의미하고 인스턴스를 생성할 수 없다
 * 
 * abstact함수는 아직 구현되지 않아서 자손 클래스가 반드시 구현해야하며 함수 구현을 하지않고 또 넘기고 싶으면
 * 해당 자손클래스도 abstact 클래스로 만들면 된다.
 * 
 * abstact함수를 생성할때는 기존 함수의 선언과 비슷한데 abstact를 앞에 붙이고 {}블럭 부분이 없으며 ;를 붙이면 된다.
 * 
 */
package __06__oop;

abstract public class Device {

	private boolean power = false;
	
	public void powerOff() {
		power = false;
		System.out.println("Electronics is powered off!");
	}
	
	public void powerOn() {
		power = true;
		System.out.println("Electronics is powered on!");
	}

	abstract void batteryChange(); /* abstract 함수 선언, {}이 없고 ;로 마무리한다. */	
}
