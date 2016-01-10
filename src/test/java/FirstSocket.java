import java.io.*;
import java.net.*;
 
public class FirstSocket {  
	public static void main(String args[]) {
		args=new String[2]; 
		  
		args[1]="http://www.qq.com/";
		args[0]="www.qq.com"; 
		    
		// 判断参数是否为两个，正确的用法为 FirstSocket 网站 页面
		if (args.length != 2) {
			System.out
					.println("Usage : FirstSocket host page\r\nExample:FirstSocket www.google.com /");
			System.exit(0);
		}
		String strServer = args[0]; // 取得第一个参数
		String strPage = args[1]; // 取得第二个参数

		try {
			String hostname = strServer;
			int port = 80;
//			InetAddress addr = InetAddress.getByName(hostname);
//			Socket socket = new Socket(addr, port); // 建立一个Socket
			Socket socket = new Socket(hostname, port); // 建立一个Socket

			// 发送命令
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream(), "UTF8"));
			wr.write("GET " + strPage + " HTTP/1.0\r\n");
			wr.write("HOST:" + strServer + "\r\n");
			wr.write("\r\n");
			wr.flush();

			// 接收返回的结果
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					socket.getInputStream(),"gb2312"));
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
			wr.close();
			rd.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}