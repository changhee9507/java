package IO.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("c:" + File.separator + "SSAFY" + File.separator + "images.jpg");
		File tgt = new File("c:" + File.separator + "SSAFY" + File.separator + "tree.jpg");
		
		
		try {
			FileInputStream input = new FileInputStream(src);
			FileOutputStream output = new FileOutputStream(tgt);
			
			byte[] buffer = new byte[100];
			int read = 0;
			while((read = input.read(buffer)) > 0) {
				output.write(buffer, 0, read);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
