import java.net.*;
import java.io.*;
public class UDFSender{
	public static void main(String[] args)throws IOException {
		//Socket是从linux学过来的，是通过文件处理的 IO
		String s="你好123";
		byte[] b=s.getBytes();
		//封装数据 ，要把数据，主机信息，端口号
		//相当于寄快递，需要物品（数据），收货地址（ip，端口号）
		InetAddress id=InetAddress.getByName("win7-PC");
		DatagramPacket dp=new DatagramPacket(b,b.length,id,2000);//2000 接收端口号 id 主机名
		//通过udp发送数据，若没有指定主机，则默认是本地主机
		DatagramSocket ds=new DatagramSocket(2010);//2000出去的端口
		ds.send(dp);
		//自定义一个接收端
		byte[] b1=new byte[1024];
		DatagramPacket dp1=new DatagramPacket(b1,b1.length);
		ds.receive(dp1);
		System.out.println(new String(dp1.getData()));

	}
}