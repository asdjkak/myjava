import java.io.*;
import java.net.*;
public class TCPServer1{
	public static void main(String[] args)throws Exception {
		ServerSocket ss=new ServerSocket(2000);
		Socket s=ss.accept();
		//InputStream in=s.getInputStream();
		// byte[] b=new byte[1024];
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		int len=0;
		String line="";
		while((line=br.readLine())!=null){
			//System.out.println(new String(b,0,len));
			System.out.println(line);
		}
		ss.close();
		s.close();
	}
}