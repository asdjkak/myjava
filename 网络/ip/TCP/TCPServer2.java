import java.io.*;
import java.net.*;
import java.util.*;
public class TCPServer2{
	public static void main(String[] args)throws IOException {
		ServerSocket ss=new ServerSocket(2000);
		while(true){
		Socket s=ss.accept();
		new Thread(new ReveiveRunnable(s)).start();
		}
	}
}
class ReveiveRunnable implements Runnable{
	private Socket s;
	public ReveiveRunnable(Socket s){
		this.s=s;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+"正在传输。。。");
		BufferedReader br=null;
		PrintWriter pw=null;
		Random r=new Random();
		int i=r.nextInt(100);
		try{
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw=new PrintWriter(new FileOutputStream("D:/"+i+".txt"),true);
		String str="";
		while((str=br.readLine())!=null){
			pw.println(str);
		}
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (br!=null) {
				try{
					br.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			if (pw!=null) {
				try{
					pw.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		try{
			s.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}