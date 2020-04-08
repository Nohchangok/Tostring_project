package cafe_toStringImg;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cafe_Img extends JFrame {
	String filepath;

	public Cafe_Img(int menu_id, String ice_hot) {
		super();

		// 아키텍쳐를 지원해주는 Jframe 객체 생성 및 타이틀 지정
		JFrame jframe = new JFrame("주문하신 메뉴 나왔습니다");
		jframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jframe.setLocationRelativeTo(null);

		// 프레임에 레이블 추가, 짧은 캐릭터 라인이나 이미지를 표시해 주는 영역
		JLabel jlabel = new JLabel();
		jframe.add(jlabel);

		// 이미지 파일 경로
		filepath = "src//cafe_toStringImg//" + menu_id + ice_hot + ".jpg";
		File file = new File(filepath);

		BufferedImage bi;

		try {
			// 이미지 파일을 읽어와서 BufferedImage에 넣음
			bi = ImageIO.read(file);
			// 레이블에 이미지 표시
			jlabel.setIcon(new ImageIcon(bi));
		} catch (Exception e) {
		}

		jframe.setVisible(true);
		// 프레임의 크기를 자동으로 설정해줍니다.
		jframe.pack();
	}

}
