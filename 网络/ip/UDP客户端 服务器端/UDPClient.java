
import java.io.*;
import java.net.*;
public class UDPClient{
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds=new DatagramSocket(2001);
		InetAddress id=InetAddress.getByName("win7-PC");
		while(true){
			String s=br.readLine();
			byte[] b=s.getBytes();
			DatagramPacket dp=new DatagramPacket(b,b.length,id,2000);
			ds.send(dp);

			byte[] b1=new byte[1024];
			DatagramPacket dp1=new DatagramPacket(b1,b1.length);
			ds.receive(dp1);
			System.out.println("ip"+id.getHostAddress());
			System.out.println(new String(dp1.getData(),0,dp1.getLength()));
		}
	}
}