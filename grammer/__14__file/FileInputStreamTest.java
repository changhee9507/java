/**
 * 
 * 텍스트 파일 읽기
 * 
 */

package __14__file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("c:\\SSAFY\\hello.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); /* 한글 깨짐 방지 - 인코딩 통일 */
		
		int i = 0;
		while((i = isr.read()) != -1) {
			char c =(char) i;
			System.out.print(c);
		}
		fis.close();
	}

}
