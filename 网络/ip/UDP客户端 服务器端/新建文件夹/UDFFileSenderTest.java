import java.io.*;
import java.net.*;
public class UDFFileSenderTest{
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("D:/ad.txt");
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		InetAddress id=InetAddress.getByName("win7-PC");
		DatagramSocket ds=new DatagramSocket(2001);
		String s="";
		while((s=br.readLine())!=null){
			byte[] b=s.getBytes();
			DatagramPacket dp=new DatagramPacket(b,b.length,id,2000);
			ds.send(dp);
		}
		String str="over";
		byte[] b1=str.getBytes();
		DatagramPacket dp=new DatagramPacket(b1,b1.length,id,2000);
		ds.send(dp);
	}
}