import java.io.*;
import java.net.*;
public class UDFFileServerTest{
	public static void main(String[] args) throws Exception{
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/abc.txt")));
		byte[] b=new byte[1024];
		DatagramPacket dp=new DatagramPacket(b,b.length);
		DatagramSocket ds=new DatagramSocket(2000);
		while(true){
			ds.receive(dp);
			String result=new String(dp.getData(),0,dp.getLength());
			if (result.equals("over")) {
				break;
			}
			System.out.println(result);
			bw.write(result);
			bw.flush();
		}
	}
}
