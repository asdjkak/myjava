import java.io.*;
import java.net.*;
public class TCPClient2{
	public static void main(String[] args)throws IOException  {
		Socket s=new Socket("fei",2000);
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:/ad.txt")));
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		String str="";
		int count=0;
		while((str=br.readLine())!=null){
			pw.println(str);
			count++;
		}
		s.shutdownOutput();
		pw.close();
		br.close();
		s.close();
	}
}