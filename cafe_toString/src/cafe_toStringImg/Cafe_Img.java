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

		// ��Ű���ĸ� �������ִ� Jframe ��ü ���� �� Ÿ��Ʋ ����
		JFrame jframe = new JFrame("�ֹ��Ͻ� �޴� ���Խ��ϴ�");
		jframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jframe.setLocationRelativeTo(null);

		// �����ӿ� ���̺� �߰�, ª�� ĳ���� �����̳� �̹����� ǥ���� �ִ� ����
		JLabel jlabel = new JLabel();
		jframe.add(jlabel);

		// �̹��� ���� ���
		filepath = "src//cafe_toStringImg//" + menu_id + ice_hot + ".jpg";
		File file = new File(filepath);

		BufferedImage bi;

		try {
			// �̹��� ������ �о�ͼ� BufferedImage�� ����
			bi = ImageIO.read(file);
			// ���̺� �̹��� ǥ��
			jlabel.setIcon(new ImageIcon(bi));
		} catch (Exception e) {
		}

		jframe.setVisible(true);
		// �������� ũ�⸦ �ڵ����� �������ݴϴ�.
		jframe.pack();
	}

}
