import java.net.*;
import java.io.*;
public class UDPRecevier{
	public static void main(String[] args)throws Exception {
		//启动一个接收端，监视2010端口
		DatagramSocket ds=new DatagramSocket(2000);
		byte[] b=new byte[1024];
		DatagramPacket dp=new DatagramPacket(b,b.length);
		ds.receive(dp);//接收
			System.out.println(dp.getAddress());
			System.out.println(new String(dp.getData()));
	}
}