/**
 * 다중 상속이 불가능한 자바의 규칙을 보완하여 
 * 비슷한 특성이나 행동을 가지는 클래스들 사이에서 변수와 함수의 사용을 동일하게 만들어준다.
 * 
 * 설계하는 사람이 중요한 틀을 만들고 구현하는 사람은 그것을 바탕으로 통일하여 구현하는 것이 가능해진다.
 */

package Interface;

public class Animal {
	String name;
	int age;
	
	public void eat() {
		System.out.println("Eat!");
	}
}
