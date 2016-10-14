import java.io.*;
import java.net.*;
public class UDFFileReceiver{
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("D:/002.jpg");
		DatagramSocket ds=new DatagramSocket(2000);
		byte[] b=new byte[64*1024]; 
		DatagramPacket dp=new DatagramPacket(b,b.length);
		ds.receive(dp);
		byte[] b1=dp.getData();
		fos.write(b1,0,dp.getLength());
	}
}