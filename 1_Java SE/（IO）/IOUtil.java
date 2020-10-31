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
	 * 缓冲区大小 1MB
	 * 
	 */
	private static final int BUFFER_SIZE = 1024 * 1024;

	/**
	 * Description: 将输入流输出到输出流
	 * 
	 * @param in
	 *            输入流
	 * @param out
	 *            输出流
	 * @param bufferSize
	 *            缓冲区大小
	 * @throws IOException
	 * @mail sunyujia@yahoo.cn
	 * @since：Jun 15, 2008 5:57:24 PM
	 */

	public static void in2OutStream(InputStream in, OutputStream out,
			int bufferSize) throws IOException {
		byte[] buffer = new byte[bufferSize];// 缓冲区
		for (int bytesRead = 0; (bytesRead = in.read(buffer)) != -1;) {
			out.write(buffer, 0, bytesRead);
			Arrays.fill(buffer, (byte) 0);
		}
	}

	/**
	 * Description:将read中的内容写入writer
	 * 
	 * @param in
	 * @param out
	 * @param bufferSize
	 * @throws IOException
	 * @mail sunyujia@yahoo.cn
	 * @since：Jul 2, 2008 11:22:42 PM
	 */

	public static void read2Writer(Reader in, Writer out, int bufferSize)
			throws IOException {
		char[] buffer = new char[bufferSize];// 缓冲区
		for (int bytesRead = 0; (bytesRead = in.read(buffer)) != -1;) {
			out.write(buffer, 0, bytesRead);
			buffer = new char[bufferSize];
		}
	}

	/**
	 * Description:将read中的内容写入writer(逐行)
	 * 
	 * @param in
	 * @param out
	 * @param bufferSize
	 * @throws IOException
	 * @mail sunyujia@yahoo.cn
	 * @since：Jul 2, 2008 11:22:42 PM
	 */
	public static void read2Writer(BufferedReader in, PrintWriter out)
			throws IOException {
		for (String line; (line = in.readLine()) != null;) {
			out.println(line);
		}
	}

	/**
	 * Description: 读取文件返回字节数组流
	 * 
	 * @param file
	 *            文件
	 * @return 字节数组流
	 * @mail sunyujia@yahoo.cn
	 * @since：Jun 15, 2008 4:52:41 PM
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
	 * Description:读取文件返回字节数组
	 * 
	 * 
	 * 
	 * @param file
	 * 
	 * 文件
	 * 
	 * @return 字节数组
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since：Jun 15, 2008 5:38:50 PM
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
	 * Description:从Reader对象中读取字符串
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
	 * @since：Jul 2, 2008 11:08:32 PM
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
	 * Description:读取文件内容
	 * 
	 * 
	 * 
	 * @param file
	 * 
	 * 文件
	 * 
	 * @return String内容
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since：Jun 15, 2008 5:46:32 PM
	 * 
	 */

	public static String readFileToString(File file) throws IOException {

		return readString(new FileReader(file));

	}

	/**
	 * 
	 * 
	 * 
	 * Description:复制文件
	 * 
	 * 
	 * 
	 * @param src
	 * 
	 * 源文件
	 * 
	 * @param dest
	 * 
	 * 目标文件
	 * 
	 * @param cover
	 * 
	 * 是否覆盖
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since：Jun 15, 2008 6:08:28 PM
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
	 * Description:写文件
	 * 
	 * 
	 * 
	 * @param file
	 * 
	 * 文件
	 * 
	 * @param str
	 * 
	 * 内容
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since：Jun 15, 2008 6:17:24 PM
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
	 * Description:从控制台读取一串字符串
	 * 
	 * 
	 * 
	 * @return 读取的字符串
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since：Jun 15, 2008 6:42:29 PM
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
	 * Description:当ObjectInputStream对象调用
	 * 
	 * readObject();时,会从ByteArrayInputStream流中反序列化出的对象
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
	 * @since：Jun 15, 2008 7:07:53 PM
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
	 * Description:当ObjectOutputStream对象调用
	 * 
	 * writeObject(o);时,o对象会序列化到ByteArrayOutputStream流中去
	 * 
	 * 
	 * 
	 * @param bos
	 * 
	 * 字节数组流
	 * 
	 * @return 对象输出流
	 * 
	 * @throws IOException
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since：Jun 15, 2008 7:06:00 PM
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
	 * Description:测试代码
	 * 
	 * 
	 * 
	 * @param args
	 * 
	 * @throws Exception
	 * 
	 * @mail sunyujia@yahoo.cn
	 * 
	 * @since：Jul 3, 2008 8:18:33 PM
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
		System.out.println(IOUtil.readString(new StringReader("测试")));
		System.out.println(IOUtil.readStringFromSystemIn());
	}
}