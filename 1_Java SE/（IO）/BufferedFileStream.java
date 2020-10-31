package array;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferedFileStream {

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
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int c = bis.read();
			while(c != -1){
				bos.write(c);
				c = bis.read();
			}
			bos.flush();
			
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
