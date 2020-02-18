/**
 * 파일 생성 및 파일 정보 출력 +-
 */

package IO.file;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;


public class FileTest {
	public static void main(String[] args) throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		String dirName = "c:" + File.separator + "SSAFY" + File.separator + "mydir";
		File file1 = new File(dirName);
		file1.mkdir();
		
		File file2 = new File(dirName, "test.txt");
		file2.createNewFile();
		/*
		File file4 = new File(new URI("file:///C:SSAFY/mydir/test4.txt"));
		file4.createNewFile();
		*/
		
		File currentDir = new File(".");
		System.out.println(currentDir.getAbsolutePath());
		
		if(currentDir.exists()) {
			File[] childs = currentDir.listFiles();
			
			for(File child : childs) {
				Date time = new Date(child.lastModified());
				String name = child.getName();
				long length = child.length();
				if(child.isDirectory()) {
					name = "[" + child.getName() + "]";
				}
				System.out.printf("%-20s\t%tF %<tT\t%s%n", name, time, length);
			}
		}
	}
}
