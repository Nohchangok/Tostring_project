package cafe_toStringChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Rt extends Thread {
	private InputStream in;

	public Rt(InputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		BufferedReader rd = new BufferedReader(new InputStreamReader(in));
		try {

			while (true) {
				String message = rd.readLine();
				System.out.println(message);

			}

		} catch (IOException e) {
		}
	}
}
