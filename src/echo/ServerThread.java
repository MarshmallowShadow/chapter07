package echo;
import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
	
	private Socket s;
	
	public ServerThread(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
			
			while(true) {
				String str = br.readLine();
				
				if(str == null) {
					break;
				}
				
				System.out.println(str);
				
				bw.write("Hello!");
				bw.newLine();
				bw.flush();
			}
			
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
