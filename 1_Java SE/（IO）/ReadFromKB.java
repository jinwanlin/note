package array;

import java.io.IOException;
/**
 * �Ӽ��̶�ȡ����, ���������ʾ��
 * @author Administrator
 *
 */
public class ReadFromKB {
	public static void main(String args[]) {
		try {
			byte bArray[] = new byte[128];
			System.out.println("Enter something Using Keyborad:");
			System.in.read(bArray);
			
			String str = new String(bArray, 0);
			System.out.print("You entered:");
			System.out.println(str);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
