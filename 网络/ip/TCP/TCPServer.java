import java.io.*;
import java.net.*;
public class TCPServer{
	public static void main(String[] args)throws IOException {
		//定义一个ServerScoket服务器，并监听2000端口
		ServerSocket ss=new ServerSocket(2000);
		//获取Socket对象
		Socket s=ss.accept();
		//获取输入流
		InputStream in=s.getInputStream();
		int len=0;
		//读写数据
		//len=in.read();
		while((len=in.read())!=-1){
		System.out.println((char)len);
		}
		ss.close();
		s.close();
	}
}