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

		// width, height크기를 가지고, 정수형 픽셀에 팩 된 8 비트 RGB 색성분에 의한 이미지를 담은 공백의 이미지 생성
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// image의 그래픽을 가져온다
		Graphics graphics = image.getGraphics();

		// 그래픽 안의 폰트를 값을 성정
		graphics.setFont(new Font("", Font.BOLD, 16));

		// Graphic 클래스를 확장하며, 그래픽의 도형, 텍스트 및 이미지를 그리기 위한 기본 클래스
		Graphics2D graphics2d = (Graphics2D) graphics;

		// 후에 사용할 draw 메소드의 품질을 제어한다, 텍스트의 노이즈(에일리어징)제거
		graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// 입력받은 word를 그래픽화 시킨다
		graphics2d.drawString(word, 0, 40);

		for (int y = 0; y < height; y++) {

			StringBuilder stringbuilder = new StringBuilder();

			for (int x = 0; x < width; x++) {

				// 1677216는 컴퓨터 24비트와 HTML이 표현할 수 있는 최대 색깔 개수
				// 즉, 비어있다면 공백으로, 비어있지 않다면 그 부분을 @으로 대체
				stringbuilder.append(image.getRGB(x, y) == -16777216 ? " " : "@");

			}

			// 문자열이 비어있다면 아래 출력문 무시
			if (stringbuilder.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(stringbuilder);
		}
	}
}
