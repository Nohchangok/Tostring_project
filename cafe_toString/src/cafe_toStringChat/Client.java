package cafe_toStringChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public void start() {
		String username = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		username = sc.next();
		Socket socket;

		try {
			socket = new Socket("192.168.0.20", 7778);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			Lt lt = new Lt(username, out, in);
			lt.start();

			try {
				lt.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
