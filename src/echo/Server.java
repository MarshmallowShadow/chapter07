package echo;
import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket();
		ss.bind(new InetSocketAddress("172.30.1.16", 9999));
		
		while(true) {
			Socket s = ss.accept();
			System.out.println("================[클라이언트 연결]================");
			
			Thread th = new ServerThread(s);
			th.start();
		}
	}
}
