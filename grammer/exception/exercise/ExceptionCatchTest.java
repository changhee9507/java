package exception.exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = new FileInputStream("hello.txt");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine().trim();
		}catch(IOException e) {
			e.printStackTrace();
		}/*catch(FileNotFoundException e) {  상위 예외가 이미 위에서 처리되었기 때문에 에러 발생 
			e.printStackTrace();
		}*/
		
		
	}	

}
