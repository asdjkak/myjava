import java.io.*;
import java.net.*;
public class TCPClient1{
	public static void main(String[] args)throws Exception {
		Socket s=new Socket("fei",2000);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//定义BufferedWriter，传入OutputStream对象，提高效率
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String str="";
		while((str=br.readLine())!=null){
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		s.close();
	}
}