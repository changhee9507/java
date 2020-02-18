package exception.nonRuntime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NonRuntimeExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine().trim(); /* IOException */
		}catch(IOException e) {
			/* 예외가 발생한 이유를 추적 - 로그 찍어보기 */
			e.printStackTrace();
			/* 처리*/
		}
		
		
	}

}
