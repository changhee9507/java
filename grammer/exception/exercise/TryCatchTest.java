package exception.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*try {
			FileInputStream fis = new FileInputStream("hello.txt");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {  예외 발생과 상관없이 실행 
			System.out.println("finally block");
		}
		*/
		
		try {
		}finally { /* 예외 발생과 상관없이 실행 */
			System.out.println("finally block2222");
		}
		
		
	}	

}
