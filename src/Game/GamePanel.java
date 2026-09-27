package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Basket b = new Basket(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(b);
	Font titleFont;
	Font titleFont2;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Timer frameDraw;
	Dimension panelDim = new Dimension(500, 800);

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titleFont2 = new Font("Arial", Font.PLAIN, 20);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		this.setPreferredSize(panelDim);
		if (needImage) {
			loadImage("sky.png");
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
g.setColor(Color.BLUE);
g.fillRect(0, 0, CatcherRunnerr.WIDTH, CatcherRunnerr.HEIGHT);
g.setFont(titleFont);
g.setColor(Color.BLACK);
g.drawString("Apple Fall", 150 , 50);
g.setFont(titleFont2);
g.setColor(Color.BLACK);
g.drawString("Press ENTER to start", 170, 300);
g.setFont(titleFont2);
g.setColor(Color.BLACK);
g.drawString("Press space for instructions", 130,600);

	}

	void drawGameState(Graphics g) {
if(gotImage) {
	g.drawImage(image, 0 ,0,CatcherRunnerr.WIDTH, CatcherRunnerr.HEIGHT, null);
}else {
	g.setColor(Color.blue);
	g.fillRect(0,0,CatcherRunnerr.WIDTH, CatcherRunnerr.HEIGHT);
}
g.drawString("b", CatcherRunnerr.WIDTH, CatcherRunnerr.HEIGHT);
manager.draw(g);
if(b.isActive == false) {
	currentState = END;
}
	}

	void drawEndState(Graphics g) {
g.setColor(Color.red);
g.fillRect(0, 0, CatcherRunnerr.WIDTH, CatcherRunnerr.HEIGHT);
g.setFont(titleFont);
g.setColor(Color.WHITE);
g.drawString("Apple Fall", 80, 50);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
if(e.getKeyCode() == KeyEvent.VK_ENTER) {
	if(currentState == END) {
		currentState = MENU;
		b = new Basket(250, 700, 50, 50);
		manager = new ObjectManager(b);
	}else {
		currentState++;
	}
	if(currentState == GAME) {
		startGame();
	}
	if(currentState == END) {
		frameDraw.stop();
	}
}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
	//System.out.println("UP");
	b.up();
	if(b.y < 0) {
		b.y = 0;
	}
}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			b.down();
		}
}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
	repaint();

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
	 void startGame() {
		 frameDraw = new Timer(100, manager);
		 frameDraw.start();
	 }

}
