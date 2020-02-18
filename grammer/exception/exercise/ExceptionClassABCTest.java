/**
 * throws를 하면 자신 부른쪽으로 예외처리의 책임을 보내는 것을 의미한다
 * 구조적으로 예외처리가 필요한 위치라면 try, catch를 통해서 예외 처리를 마무리하면 된다.
 */
package exception.exercise;

public class ExceptionClassABCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionClassA eca = new ExceptionClassA();
		eca.mA();
		
	}

}
