package Interface;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Animal dog1 = new Dog();
		
		dog1.eat();  상속한 함수 호출 
		
		Fly a3 = new Bird();  타입을 interface로 선언하고 그것을 재정의한 객체로 만들수 있다. 
		a3.fly();
		
		Dog dog2 = new Dog();  interface를 이용해서 재정의한 함수를 사용할 수도 있다. 
		dog2.run();
		*/
		
		Fly obj1 = getFlyObj("B");
		Fly obj2 = getFlyObj("D");
		obj1.fly();
		obj2.fly();
	}

	
	/* 함수를 이용해서 구분자에 따라 적절한 객체를 만들어준다. */
	public static Fly getFlyObj(String clsf) {
		Fly obj = null;
		if("B".equals(clsf)) obj = new Bird();
		else if("D".equals(clsf)) obj = new Duck();
		return obj;
	}
}
