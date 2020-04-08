package cafe_toStringBGM;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Cafe_BGM {

	public static void mp3() {
		File bgm;
		AudioInputStream mp3stream;
		AudioFormat format;
		DataLine.Info info;
		bgm = new File("src//cafe_toStringBGM//cafe_toString_BGM.wav");
		Clip clip;

		try {
			// ������ File �κ��� ����� �Է� ��Ʈ���� ���
			mp3stream = AudioSystem.getAudioInputStream(bgm);

			// ����� �Է� ��Ʈ������ ���� �������� ����� ������ ���
			format = mp3stream.getFormat();

			// ����� ������ ������ �����κ��� ������ ������ ���� ��ü�� ����
			info = new DataLine.Info(Clip.class, format);

			// ������ ������ ����Ѵ�
			clip = (Clip) AudioSystem.getLine(info);

			// AudioInpuStream ������ ���õǰ� �ִ� ���İ� ������� �������̽� Clip�� ����Ͽ� �����Ų��
			clip.open(mp3stream);
			clip.start();
//			clip.loop(99);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
