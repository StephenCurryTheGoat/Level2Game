package Game;
import javax.swing.JFrame;
import java.awt.Dimension;

public class CatcherRunnerr {
	static final int WIDTH = 500;
	static final int HEIGHT = 800;
	JFrame frame;
	GamePanel panel;
	public static void main(String[] args) {
		CatcherRunnerr runner = new CatcherRunnerr();
		runner.setUp();
	}//
	CatcherRunnerr(){
		frame = new JFrame();
		panel = new GamePanel();
	}
	void setUp() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		frame.pack();
	}
}
