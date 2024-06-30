package _08_LeagueSnake;

/*
 * This class will be used to represent each part of the moving snake.
 * 
 * 1. Add x and y member variables.
 *    They will hold the corner location of each segment of the snake.
 * 
 * 2. Add a constructor with parameters to initialize each variable.
 */
public class Segment {
	public int[] color;
	public int x;
	public int y;
	public Segment(int x, int y, int r, int g, int b) {
		this.x = x;
		this.y = y;
		color = new int[3];
		color [0] = r;
		color [1] = g;
		color [2] = b;
	}
}
