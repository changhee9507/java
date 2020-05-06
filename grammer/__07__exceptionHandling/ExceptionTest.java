/**
 * 예외처리 흐름
 * 
 * try문에서 예외가 발생하면 그 이후 문장은 실행되지 않으며 해당 에러 객체가 생성되어 거기 맞는 catch문이 실행된다.
 * 
 * 상위 예외는 가장 나중에 와야하며 더 구체화된(예를 들어 Arithmetic이 그냥 Exception보다 구체화된 에러 )에러로
 * catch문이 실행되면 그 이후 catch문은 실행되지 않고 빠져나간다.
 * 
 * printStackTrace나 getMessage같은 함수가 예외 객체에 담겨져 있고 이것이 예외 발생원인을 파악하는데 큰 도움을 준다.
 * 
 * ㅣ를 이용해서 catch를 여러개 만드는 수고를 줄일수 있다. ex) catch(ExceptionA a|ExceptionB b){}
 * 
 * throw를 이용해서 예외를 프로그래머가 일부러 발생 시킬수도 있다.
 * 
 * 발생하는 예외에 대한 에러처리(catch문)가 되지 않으면 에러가 발생한다.
 * 
 * RuntimeException클래스들은 컴파일러가 예외처리를 확인하지 않고 나머지는 예외처리를 컴파일러가 확인 한다.
 * 
 * @author Changhee Yoon
 */
package __07__exceptionHandling;

public class ExceptionTest {

	public static void main(String[] args) {

		try {
			ExceptionMethod();
		} catch (Exception e) {
			System.out.println("ExceptionMethod의 예외가 메인에서 처리되었습니다.");
			e.printStackTrace();
		}
		
		
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);

			throw new ArithmeticException("고의 적인 산술에러!"); /* 일부러 예외 객체를 생성해서 catch로 던진다. 이후 코드가 있으면 에러 */
			// System.out.println(0/0);
			// System.out.println(4); /* 실행되지 않음 */
		} catch (ArithmeticException ae) {
			ae.printStackTrace(); /* 호출스택에 있었던 메서드의 정보와 예외 메세지를 출력 */
			System.out.println(ae.getMessage()); /* 에러 객체에 담긴 예외 메세지만 가져오는 함수 */
			System.out.println(5);
		} catch (Exception e) { /* 상위 에러, 에러 범위에 속하지만 위에서 에러 처리가 되기 때문에 실행되지 않음 */
			System.out.println(6);
		}
		System.out.println(7);
	}

	/*
	 * 어떤 함수에서 발생하는 예외처리를 그 함수를 사용하는 사람에게 부담하도록 할 수 있다.
	 * 함수이름 옆에 throws를 붙인다음 발생하는 예외의 객체 이름을 붙여준다.
	 * 
	 * 메인이나 이 함수를 부르는 곳에서는 try-catch를 통해서 적절히 이 예외를 처리하던가 또다시 예외를 상위 함수로 전가할 수 도 있다.
	 *
	 **/
	static void ExceptionMethod() throws Exception {
		throw new Exception();
	}

}
