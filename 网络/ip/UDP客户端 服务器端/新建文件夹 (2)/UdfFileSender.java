import java.io.*;
import java.net.*;
public class UdfFileSender{
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("D:/12.jpg");
		byte[] b=new byte[fis.available()];
		fis.read(b);
		InetAddress id=InetAddress.getByName("win7-PC");
		DatagramPacket dp=new DatagramPacket(b,b.length,id,2000);
		DatagramSocket ds=new DatagramSocket();
		ds.send(dp);
		fis.close();
	}
}