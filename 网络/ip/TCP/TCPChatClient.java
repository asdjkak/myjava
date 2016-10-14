import java.io.*;
import java.net.*;
public class TCPChatClient{
	public static void main(String[] args) throws Exception{
		while(true){

		Socket s=new Socket("fei",2000);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String str="";
		while((str=br.readLine())!=null){
			bw.write(str);
			bw.newLine();
			bw.flush();
			break;
		}

		ServerSocket ss1=new ServerSocket(2001);
		Socket s1=ss1.accept();
		BufferedReader br1=new BufferedReader(new InputStreamReader(s1.getInputStream()));
		String str1="";
		while((str1=br1.readLine())!=null){
			System.out.println(str1);
			break;
		}
		}
	}
}