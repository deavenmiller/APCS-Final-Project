package GUI;

import java.awt.Graphics;

import Actors.Platform;
import Actors.Player;

public class Level1State extends GameState {

	private Platform[] b;
	
	private Player player;

	public Level1State(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		player = new Player(30, 30);
		b = new Platform[3];
		b[0] = new Platform(100, 100);
		b[1] = new Platform(200, 200);
		b[2] = new Platform(400, 400);
	}

	public void tick() {
		
		for(int i = 0; i < b.length; i++) {
			b[i].tick();
		}
		
		player.tick(b);
	}

	public void draw(Graphics g) {
		player.draw(g);
		
		for(int i = 0; i < b.length; i++) {
			b[i].draw(g);
		}
		
	}

	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	public void keyReleased(int k) {
		player.keyReleased(k);
	}

}
