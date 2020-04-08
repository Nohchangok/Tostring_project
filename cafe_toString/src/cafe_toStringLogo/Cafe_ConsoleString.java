package cafe_toStringLogo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Cafe_ConsoleString {

	public static void main(String[] args) {
		consoleString("cafe_toString");
	}

	public static void consoleString(String word) {
		int width = 101;
		int height = 100;

		// width, heightũ�⸦ ������, ������ �ȼ��� �� �� 8 ��Ʈ RGB �����п� ���� �̹����� ���� ������ �̹��� ����
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// image�� �׷����� �����´�
		Graphics graphics = image.getGraphics();

		// �׷��� ���� ��Ʈ�� ���� ����
		graphics.setFont(new Font("", Font.BOLD, 16));

		// Graphic Ŭ������ Ȯ���ϸ�, �׷����� ����, �ؽ�Ʈ �� �̹����� �׸��� ���� �⺻ Ŭ����
		Graphics2D graphics2d = (Graphics2D) graphics;

		// �Ŀ� ����� draw �޼ҵ��� ǰ���� �����Ѵ�, �ؽ�Ʈ�� ������(���ϸ���¡)����
		graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// �Է¹��� word�� �׷���ȭ ��Ų��
		graphics2d.drawString(word, 0, 40);

		for (int y = 0; y < height; y++) {

			StringBuilder stringbuilder = new StringBuilder();

			for (int x = 0; x < width; x++) {

				// 1677216�� ��ǻ�� 24��Ʈ�� HTML�� ǥ���� �� �ִ� �ִ� ���� ����
				// ��, ����ִٸ� ��������, ������� �ʴٸ� �� �κ��� @���� ��ü
				stringbuilder.append(image.getRGB(x, y) == -16777216 ? " " : "@");

			}

			// ���ڿ��� ����ִٸ� �Ʒ� ��¹� ����
			if (stringbuilder.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(stringbuilder);
		}
	}
}
