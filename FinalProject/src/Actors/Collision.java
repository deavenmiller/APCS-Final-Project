package Actors;

import java.awt.Point;

public class Collision {
	
	public static boolean playerBlock(Point p, Platform b) {
		return b.contains(p);
	}
	
	public Collision() {
		
	}
	
}
