/**
 * 상속관계(Device - Computer - Phone);
 * 
 * 
 * @author Changhee Yoon
 */
package __06__oop;

public class OOPTest {

	public static void main(String[] args) {
		//polymorphismTest();
		anonymousClassTest();
	}
	
	
	
	
	
	/* 같은 이름으로 변수와 함수가 자손 클래스와 부모 클래스에 포함되어 있는 경우
	 * 변수 - 타입 기준으로 호출, 함수 - 인스턴스 기준으로 호출.
	 * 함수를 통해서 중복된 변수를 호출하면 해당 클래스에 있는 변수를 호출.
	 */
	public static void polymorphismTest() {
		
		Computer computer = new Phone();
		Phone phone = new Phone();
		
		System.out.println(computer.screenSize);
		System.out.println(phone.screenSize);
		
		computer.powerOn();
		phone.powerOn();
	}
	
	/* anonymous(익명) 클래스는 기존에 존재하는 클래스나 인터페이스 등을 일회적으로 구현하거나 오버라이딩할 필요가   
	 * 있을 때 쓰인다.
	 * 
	 */
	public static void anonymousClassTest() {
		
		Phone phone = new Phone() { /* 기존에 존재하는 music함수를 일회적으로 오버라이딩 */
			@Override
			public void music() {
				System.out.println("K-POP is playing");
			}
		};
		
		phone.music();
	}
}
