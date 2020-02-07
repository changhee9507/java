/**
 * 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조하는 경우
 * 사실상 조상과 자손(2개)의 인스턴스가 생성된다.
 * 
 * 그래서 변수를 호출하면 참조변수(선언 타입)를 기준으로 호출되지만
 * 함수의 호출은 override된 함수(객체의 함수)가 호출되고
 *  
 * override된 함수가 호출하는 변수와 모든 기준은 override된 함수 기준이다.
 * 
 * @author Changhee Yoon
 *
 */


package oop.polymorphism;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrandParentClass obj = new ChildClass();
		System.out.println(obj.i);
		obj.print();
		
	}

}
