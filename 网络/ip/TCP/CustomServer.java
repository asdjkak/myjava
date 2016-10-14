import java.io.*;
import java.net.*;
public class CustomServer{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(2100);
		Socket s=ss.accept();
		InputStream in=s.getInputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=in.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		// s.close();
	PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
	pw.println("hello");
	s.close();
	ss.close();
	}
}
//GET / HTTP/1.1Host: 172.30.31.144:2100Connection: keep-aliveAccept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8Upgrade-Insecure-Requests: 1User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, likeGecko) Chrome/49.0.2623.22 Safari/537.36 SE 2.X MetaSr 1.0Accept-Encoding: gzip, deflate, sdchAccept-Language: zh-CN,zh;q=0.8