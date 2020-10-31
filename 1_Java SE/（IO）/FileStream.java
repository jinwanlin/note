package array;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileStream {

	/**
	 * 字节流 ——文件流(使用缓冲区)
	 * @param args
	 */
	public static void main(String[] args) {
		File inFile = new File("c:\\WebQQ_329262945_446829520_2009-07-25.html");
		File outFile = new File("c:/WebQQ_329262945_446829520_2009-07-25(copy).htm");

		try {
			FileInputStream fis = new FileInputStream(inFile);
			FileOutputStream fos = new FileOutputStream(outFile);
			
			int c = fis.read();
			while(c != -1){
				fos.write(c);
				c = fis.read();
			}
			
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
