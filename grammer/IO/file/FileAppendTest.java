package IO.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileAppendTest {

	File src = new File("c:" + File.separator + "SSAFY" + File.separator + "images.jpg");
	File tgt = new File("c:" + File.separator + "SSAFY" + File.separator + "tree.jpg");

	FileInputStream input = null;
	FileOutputStream output = null;
	
	try {
		input = new FileInputStream(src);
		if(tgt.exists()) {
			System.out.println("tgt File exist!!");
			output = new FileOutputStream(tgt, true);
		}else {
			output = new FileOutputStream(tgt);
		}
		
		byte[] buffer = new byte[100];
		int read = 0;
		while((read = input.read(buffer)) > 0) {
			output.write(buffer, 0,read);
		}
	}catch() {
		
	}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
