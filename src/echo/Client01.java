package echo;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client01 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket();
		
		System.out.print("이름 입력하세요: ");
		String name = sc.nextLine();
		
		System.out.println("연결중...");
		s.connect(new InetSocketAddress("172.30.1.16", 9999));
		
		System.out.println("==================[연결 되었습니다]==================");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
		
		
		while(true) {
			String str = sc.nextLine();
			
			if(str.equals("quit")) {
				break;
			}
			
			bw.write("[" + name + "]" + str);
			bw.newLine();
			bw.flush();
			
			String reply = br.readLine();
			System.out.println("Server: [" + reply + "]");
		}
		
		System.out.println("==================[클라이언트 종료]==================");
		
		sc.close();
		bw.close();
		br.close();
		s.close();
	}
}
