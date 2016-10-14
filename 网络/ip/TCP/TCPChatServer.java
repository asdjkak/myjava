import java.io.*;
import java.net.*;
public class TCPChatServer{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(2000);
		Socket s=ss.accept();
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str="";
		InetAddress id=s.getInetAddress();
		while((str=br.readLine())!=null){
			System.out.println(id);
			System.out.println(str);
			break;
		}

		Socket s1=new Socket("fei",2001);
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw1=new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
		String str1="";
		while((str1=br1.readLine())!=null){
			bw1.write(str1);
			bw1.newLine();
			bw1.flush();
			break;
		}
	}
}