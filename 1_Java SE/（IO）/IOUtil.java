package array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

public class IOUtil {
	/**
	 * 
	 * ��������С 1MB
	 * 
	 */
	private static final int BUFFER_SIZE = 1024 * 1024;

	/**
	 * Description: ������������������
	 * 
	 * @param in
	 *            ������
	 * @param out
	 *            �����
	 * @param bufferSize
	 *            ��������С
	 * @throws IOException
	 * @mail sunyujia@yahoo.cn
	 * @since��Jun 15, 2008 5:57:24 PM
	 */

	public static void in2OutStream(InputStream in, OutputStream out,
			int bufferSize) throws IOException {
		byte[] buffer = new byte[bufferSize];// ������
		for (int bytesRead = 0; (bytesRead = in.read(buffer)) != -1;) {
			out.write(buffer, 0, bytesRead);
			Arrays.fill(buffer, (byte) 0);
		}
	}

	/**
	 * Description:��read�е�����д��writer
	 * 
	 * @param in
	 * @param out
	 * @param bufferSize
	 * @throws IOException
	 * @mail sunyujia@yahoo.cn
	 * @since��Jul 2, 2008 11:22:42 PM
	 */

	public static void read2Writer(Reader in, Writer out, int bufferSize)
			throws IOException {
		char[] buffer = new char[bufferSize];// ������
		for (int bytesRead = 0; (bytesRead = in.read(buffer)) != -1;) {
			out.write(buffer, 0, bytesRead);
			buffer = new char[bufferSize];
		}
	}

	/**
	 * Description:��read�е�����д��writer(����)
	 * 
	 * @param in
	 * @param out
	 * @param bufferSize
	 * @throws IOException
	 * @mail sunyujia@yahoo.cn
	 * @since��Jul 2, 2008 11:22:42 PM
	 */
	public static void read2Writer(BufferedReader in, PrintWriter out)
			throws IOException {
		for (String line; (line = in.readLine()) != null;) {
			out.println(line);
		}
	}

	/**
	 * Description: ��ȡ�ļ������ֽ�������
	 * 
	 * @param file
	 *            �ļ�
	 * @return �ֽ�������
	 * @mail sunyujia@yahoo.cn
	 * @since��Jun 15, 2008 4:52:41 PM
	 */
	public static ByteArrayOutputStream readFileToByteStream(File file)
			throws IOException {
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream();
			in2OutStream(fis, bos, BUFFER_SIZE);
		} finally {
			if (fis != null)
				fis.close();
		}
		return bos;
	}

	/**
	 * 
	 * 
	 * 
	 * Description:��ȡ�ļ������ֽ�����
	 * 
	 * 
	 * 
	 * @param file
	 * 
	 * �ļ�
	 * 
	 * @return �ֽ�����
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jun 15, 2008 5:38:50 PM
	 * 
	 */

	public static byte[] readFileToByteArray(File file) throws IOException {

		ByteArrayOutputStream bos = null;

		try {

			bos = readFileToByteStream(file);

		} finally {

			if (bos != null)

				bos.close();

		}

		return bos.toByteArray();

	}

	/**
	 * 
	 * 
	 * 
	 * Description:��Reader�����ж�ȡ�ַ���
	 * 
	 * 
	 * 
	 * @param reader
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jul 2, 2008 11:08:32 PM
	 * 
	 */

	public static String readString(Reader reader) throws IOException {

		PrintWriter sw = null;

		BufferedReader in = null;

		try {

			in = new BufferedReader(reader);

			StringWriter swr = new StringWriter();

			sw = new PrintWriter(swr, true);

			read2Writer(in, sw);

			return swr.toString();

		} finally {

			try {

				if (in != null)

					in.close();

			} finally {

				if (sw != null)

					sw.close();

			}

		}

	}

	/**
	 * 
	 * 
	 * 
	 * Description:��ȡ�ļ�����
	 * 
	 * 
	 * 
	 * @param file
	 * 
	 * �ļ�
	 * 
	 * @return String����
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jun 15, 2008 5:46:32 PM
	 * 
	 */

	public static String readFileToString(File file) throws IOException {

		return readString(new FileReader(file));

	}

	/**
	 * 
	 * 
	 * 
	 * Description:�����ļ�
	 * 
	 * 
	 * 
	 * @param src
	 * 
	 * Դ�ļ�
	 * 
	 * @param dest
	 * 
	 * Ŀ���ļ�
	 * 
	 * @param cover
	 * 
	 * �Ƿ񸲸�
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jun 15, 2008 6:08:28 PM
	 * 
	 */

	public static void copyFile(File src, File dest, boolean cover)

	throws IOException {

		FileInputStream in = null;

		FileOutputStream out = null;

		try {

			if (!dest.exists()) {

				dest.createNewFile();

			} else if (dest.exists() && cover) {

				dest.delete();

				dest.createNewFile();

			} else {

				return;

			}

			in = new FileInputStream(src);

			out = new FileOutputStream(dest);

			in2OutStream(in, out, BUFFER_SIZE);

		} finally {

			try {

				if (in != null)

					in.close();

			} finally {

				if (out != null)

					out.close();

			}

		}

	}

	/**
	 * 
	 * 
	 * 
	 * Description:д�ļ�
	 * 
	 * 
	 * 
	 * @param file
	 * 
	 * �ļ�
	 * 
	 * @param str
	 * 
	 * ����
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jun 15, 2008 6:17:24 PM
	 * 
	 */

	public static void writeFile(File file, String str) throws IOException {
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			if (!file.exists())
				file.createNewFile();
			in = new BufferedReader(new StringReader(str));
			out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			read2Writer(in, out);
		} finally {
			try {
				if (in != null)
					in.close();
			} finally {
				if (out != null)
					out.close();
			}
		}
	}

	/**
	 * 
	 * 
	 * 
	 * Description:�ӿ���̨��ȡһ���ַ���
	 * 
	 * 
	 * 
	 * @return ��ȡ���ַ���
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jun 15, 2008 6:42:29 PM
	 * 
	 */

	public static String readStringFromSystemIn() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}

	/**
	 * 
	 * 
	 * 
	 * Description:��ObjectInputStream�������
	 * 
	 * readObject();ʱ,���ByteArrayInputStream���з����л����Ķ���
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param bi
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jun 15, 2008 7:07:53 PM
	 * 
	 */

	public static ObjectInputStream buildObjectInputStream(
			ByteArrayInputStream bi) throws IOException {
		return new ObjectInputStream(bi);
	}

	/**
	 * 
	 * 
	 * 
	 * Description:��ObjectOutputStream�������
	 * 
	 * writeObject(o);ʱ,o��������л���ByteArrayOutputStream����ȥ
	 * 
	 * 
	 * 
	 * @param bos
	 * 
	 * �ֽ�������
	 * 
	 * @return ���������
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jun 15, 2008 7:06:00 PM
	 * 
	 */

	public static ObjectOutputStream buildObjectOutputStream(
			ByteArrayOutputStream bos) throws IOException {
		return new ObjectOutputStream(bos);

	}

	public static BufferedReader buildBufferedReader(String str) {
		return new BufferedReader(new StringReader(str));
	}

	public static ByteArrayInputStream buildByteArrayInputStream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}

	public static ByteArrayInputStream buildByteArrayInputStream(byte[] bt) {
		return new ByteArrayInputStream(bt);
	}

	public static BufferedReader buildReader(InputStream is) {
		return new BufferedReader(new InputStreamReader(is));
	}

	/**
	 * 
	 * 
	 * 
	 * Description:���Դ���
	 * 
	 * 
	 * 
	 * @param args
	 * 
	 * @throws Exception
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since��Jul 3, 2008 8:18:33 PM
	 * 
	 */

	public static void main(String[] args) throws Exception {

		byte[] bootFileBytes = IOUtil.readFileToByteArray(new File(
				"C:\\boot.ini"));
		System.out.println(new String(bootFileBytes));
		String bootFileStr = readFileToString(new File("C:\\boot.ini"));
		System.out.println(bootFileStr);
		System.out.println(new String(bootFileBytes).equals(bootFileStr));
		IOUtil.copyFile(new File("C:\\boot.ini"), new File("C:\\boot1.ini"),
				true);
		IOUtil.writeFile(new File("C:\\boot2.ini"), bootFileStr);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = IOUtil.buildObjectOutputStream(bos);
		oos.writeObject(new String("abcd"));
		ObjectInputStream ois = IOUtil.buildObjectInputStream(IOUtil
				.buildByteArrayInputStream(bos.toByteArray()));
		System.out.println(ois.readObject());
		System.out.println(IOUtil.readString(new StringReader("����")));
		System.out.println(IOUtil.readStringFromSystemIn());
	}
}