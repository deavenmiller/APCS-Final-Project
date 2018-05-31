package Actors;

import java.awt.Graphics;
import java.awt.Rectangle;

import GUI.GameState;

public class Platform extends Rectangle {
	private static final long serialVersionUID = 1L;
	
	public static final int width = 100;
	public static final int height = 20;
	
	public Platform(int x, int y) {
		
		setBounds(x, y, width, height);
		
	}
	
	public void tick() {
		x = x - (int) GameState.xOffset;
		y = y - (int) GameState.yOffset;
	}
	
	public void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
}
