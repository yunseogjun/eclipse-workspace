package tcpip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket server_socket = null;

		try {
			server_socket = new ServerSocket(4444);
		}catch(IOException e) {
			System.out.println("해당 포트가 열려있습니다.");
		}
		try {
				while (true) 
				{
						System.out.println("서버가 열렸습니다. 입력 대기중입니다.");
						socket = server_socket.accept(); // 서버를 생성, Client는 접속 대기
						foo f = new foo(socket);	
						f.start();
				}
		}catch(IOException e) {
			System.out.println("server 프로그램 비정상 종료");
		}
	} 
}

class foo extends Thread{
	Socket socket;
	foo(Socket ss)
	{	
		socket = ss; 
	}
	 
	public void run() {
		try {		
			BufferedReader in = null;
			PrintWriter out = null;		

			while(true) {
		
				System.out.println("Client로 메세지 대기중 : ");
				in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력스트림 생성
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // 출력스트림 생성
				
				String str = null;
				str = in.readLine(); // Client로부터 데이터 읽어옴
				
				System.out.println("Client에서 반은 메세지 : " + str);
				
				out.write(str+"\n"); // print(str)와 비슷합니다.
				out.flush();
				System.out.println("Client로  보낸 메세지 : " + str);
			}
				
		}catch(IOException e) {
			System.out.println("run 프로그램 이상" + e.getMessage());
		}		
	}
}
