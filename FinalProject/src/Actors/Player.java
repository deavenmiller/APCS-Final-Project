package Actors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import GUI.GamePanel;
import GUI.GameState;

public class Player {

	// Directional Movement
	private boolean right = false;
	private boolean left = false;
	private boolean jumping = false;
	private boolean falling = false;

	// Player Bound Variables
	private double x, y;
	private int width, height;

	// Move Speed
	private double moveSpeed = 2.5;

	// Jump Speed
	private double jumpSpeed = 6;
	private double currentJumpSpeed = jumpSpeed;

	// Fall Speed
	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;

	private boolean isAlive = true;

	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}

	public void tick(Platform[] b) {

		int iX = (int) x;
		int iY = (int) y;

		for (int i = 0; i < b.length; i++) {
			if (Collision.playerBlock(new Point(iX + width, iY), b[i])
					|| Collision.playerBlock(new Point(iX + width, iY + height), b[i])) {

			}
		}

		if (right) {
			x += moveSpeed;
		}

		if (left) {
			x -= moveSpeed;
		}

		if (jumping) {
			y -= currentJumpSpeed;

			currentJumpSpeed -= 0.2;

			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}

		if (falling) {
			y += currentFallSpeed;

			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.5;
			}
		}

		if (!falling) {
			currentFallSpeed = 0.1;
		}

		if (!isAlive) {
			System.exit(0);
		}

		// Teleports player to other side of screen
		if (x > GamePanel.WIDTH - (width / 2))
			x = 0;
		if (x < 0)
			x = GamePanel.WIDTH - (width / 2);
		if (y > GamePanel.HEIGHT - (height / 2))
			isAlive = false;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

		g.setColor(Color.CYAN);
		g.fillRect((int) x, (int) y, width, height);
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_D)
			right = true;
		if (k == KeyEvent.VK_A)
			left = true;
		if (k == KeyEvent.VK_SPACE) {
			jumping = true;
			falling = false;
		}
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D)
			right = false;
		if (k == KeyEvent.VK_A)
			left = false;
	}

}
