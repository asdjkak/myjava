import java.io.*;
import java.net.*;
public class HttpDemo{
	public static void main(String[] args) throws Exception{
		URL url=new URL("http://img60.aili.com/a1/12/a112250a4182e9c8a29f9afd3847e7b2.png?1474265640");
		URLConnection con=url.openConnection();
		InputStream is=con.getInputStream();
		FileOutputStream fis=new FileOutputStream("D:/8.jpg");
		byte[] b=new byte[1024];
		int len=0;
		while((len=is.read(b))!=-1){
			fis.write(b,0,len);
		}
		fis.close();
	}
}
