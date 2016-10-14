import java.io.*;
import java.net.*;
public class TCPClient{
	public static void main(String[] args)throws IOException {
		//定义一个socket客户端，并指定服务器端ip和端口
		Socket s=new Socket("fei",2000);
		//获取输出流对象，用以发送数据
		OutputStream os=s.getOutputStream();
		//开始写入数据
		os.write("qwer".getBytes());
		os.close();
	}
}