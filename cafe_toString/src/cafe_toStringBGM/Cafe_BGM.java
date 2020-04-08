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
			// 지정된 File 로부터 오디오 입력 스트림을 취득
			mp3stream = AudioSystem.getAudioInputStream(bgm);

			// 오디오 입력 스트림내의 사운드 데이터의 오디오 형식을 취득
			format = mp3stream.getFormat();

			// 오디오 형식을 포함한 정보로부터 데이터 라인의 정보 객체를 구축
			info = new DataLine.Info(Clip.class, format);

			// 데이터 라인을 취득한다
			clip = (Clip) AudioSystem.getLine(info);

			// AudioInpuStream 내에서 제시되고 있는 형식과 오디오를 인터페이스 Clip을 사용하여 실행시킨다
			clip.open(mp3stream);
			clip.start();
//			clip.loop(99);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
