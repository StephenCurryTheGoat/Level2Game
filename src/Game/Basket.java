package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Basket extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Basket(int x, int y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
			loadImage("basket.png");
		}
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;

	}

	public void down() {
		y += speed;
	}

	public void up() {
		y -= speed;
	}

	public Basket getBasket() {
		return new Basket(x + width / 2, y, 10, 10);
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			needImage = false;
		}
	}

}
