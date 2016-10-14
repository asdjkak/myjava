import java.io.*;
import java.net.*;
public class UDPServer{
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds=new DatagramSocket(2000);
		while(true){
			byte[] b=new byte[1024];
			DatagramPacket dp=new DatagramPacket(b,b.length);//创建一个空的
			ds.receive(dp);//把ds接收到的数据写到dp里面

			InetAddress id=dp.getAddress();
			System.out.println("ip"+id.getHostAddress());
			System.out.println(new String(dp.getData(),0,dp.getLength()));
			String s=br.readLine();
			byte[] b1=s.getBytes();
			DatagramPacket dp1=new DatagramPacket(b1,b1.length,id,2001);
			ds.send(dp1);
	}
}
}