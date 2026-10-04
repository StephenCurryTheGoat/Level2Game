package Game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	int score = 0;
	Basket b;
	Random ran = new Random();
	ArrayList<Apple> apples = new ArrayList<Apple>();
	ArrayList<Basket> basket = new ArrayList<Basket>();

	ObjectManager(Basket b) {
		this.b = b;
	}

	void addApples(Apple a) {
		apples.add(new Apple(ran.nextInt(CatcherRunnerr.WIDTH), 0, 50, 50));

	}

	void addBasket(Basket ba) {
		basket.add(ba);
	}

	void update() {
		for (int i = 0; i < apples.size(); i++) {
			Apple al = apples.get(i);
			al.update();
			if (al.y > CatcherRunnerr.HEIGHT) {
				al.isActive = false;
			}

		}
	}
	void draw(Graphics g) {
		b.draw(g);
		for(int i = 0; i < apples.size(); i++) {
			Apple al = apples.get(i);
			al.draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	void checkCollision() {
		for(Apple apple: apples) {
			for(Basket b: basket) {
				if(b.collisionBox.intersects(apple.collisionBox)) {
					apple.isActive = false;
					b.isActive = false;
					score++;
			}
			}
		}
	}
	int getScore() {
		return score;
	}

}
