import java.net.*;
public class IPDemo{
	public static void main(String[] args) throws Exception{
		 InetAddress id=InetAddress.getLocalHost();//获取主机名与ip
		 System.out.println(id);
		 String name=id.getHostName();//主机名
		 System.out.println(name);
		 String ip=id.getHostAddress();//主机的ip地址

		 //通过指定主机名获取qq的主机信息
		 InetAddress id2=InetAddress.getByName("www.qq.com");
		 System.out.println(id2);
		 //所有的qq ip
		 InetAddress[] id3=InetAddress.getAllByName("www.qq.com");
		 for (InetAddress i :id3 ) {
		 	System.out.println(i.getHostAddress());
		 }
	}
}