package GUI;

import java.awt.*;

import javax.swing.*;

public class GameFrame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Scribble Hop");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(new GamePanel(), BorderLayout.CENTER);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}


