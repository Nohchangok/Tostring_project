package cafe_toStringChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class Lt extends Thread {
	private String username;
	private OutputStream out;
	InputStream in;

	public Lt(String username, OutputStream out, InputStream in) {
		this.username = username;
		this.out = out;
		this.in = in;
	}

	@Override
	public void run() {
		try {
			Writer wr = new OutputStreamWriter(out);
			Scanner sc = new Scanner(System.in);
			Rt rt = new Rt(in);

			String str;
			wr.write(username + ":" + "join\n");
			wr.flush();

			rt.setDaemon(true);
			rt.start();
			System.out.println("대화방입장.");

			while ((str = sc.nextLine()) != "quit") {
				if (str.equals("quit")) {
					System.out.println("채팅종료");
					wr.write(username + ":" + str + "\n");
					wr.flush();
					break;
				} else {
					wr.write(username + ":" + str + "\n");
					wr.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
