package Actors;

public class Platform {
	
	private int width;
	private int height;
	private boolean moveable;
	
	public Platform() {
		width = 0;
		height = 0;
		moveable = false;
	}
	
	public Platform(int w, int h, boolean move) {
		width = w;
		height = h;
		moveable = move;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
		
	public boolean isMoveable() {
		return moveable;
	}
	
	public void setWidth(int x) {
		width = x;
	}
	
	public void setHeight(int y) {
		height = y;
	}
	
	public void setMoveable(boolean t) {
		moveable = t;
	}
	
}
