package _08_LeagueSnake;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
	static final int WIDTH = 500;
	static final int HEIGHT = 500;

	/*
	 * Game variables
	 * 
	 * Put all the game variables here.
	 */
	Segment snakeHead;
	int foodX;
	int foodY;
	int direction;
	int food;
	int snakeSpeed = 10;
	ArrayList<Segment> segments;
	Random ran = new Random();




	/*
	 * Setup methods
	 * 
	 * These methods are called at the start of the game.
	 */

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		snakeHead = new Segment(10, 10, 255, 0, 0);
		segments = new ArrayList <Segment>();
		frameRate(20);
		
		dropFood();
	}

	void dropFood() {
		// Set the food in a new random location
		foodX = ((int)random(48)*10);
		foodY = ((int)random((48)*10)+10);



	}

	/*
	 * Draw Methods
	 * 
	 * These methods are used to draw the snake and its food
	 */

	@Override
	public void draw() {
		background(0, 0, 0);
		drawFood();

		if(frameCount%3 == 0) {
			manageTail();
			move();
			checkTailCollision();
		}
		drawSnake();
		eat();
		drawTail();

	}

	void drawFood() {
		// Draw the food
		fill(0, 255, 0);
		rect(foodX, foodY, 10, 10);

	}

	void drawSnake() {
		// Draw the head of the snake followed by its tail
		fill(snakeHead.color[0], snakeHead.color[1], snakeHead.color[2]);
		rect(snakeHead.x, snakeHead.y, 10, 10);

	}

	void drawTail() {
		// Draw each segment of the tail
		Segment currentSegment;
		for(int i = 0; i< segments.size(); i++) {
			currentSegment = segments.get(i);
			fill(currentSegment.color[0], currentSegment.color[1], currentSegment.color[2]);
			rect(currentSegment.x, currentSegment.y, 10, 10);

		}

	}

	/*
	 * Tail Management methods
	 * 
	 * These methods make sure the tail is the correct length.
	 */

	void manageTail() {
		// After drawing the tail, add a new segment at the "start" of the tail and
		// remove the one at the "end"
		// This produces the illusion of the snake tail moving.
		Segment s = createSegmentAtHead(snakeHead);
		segments.add(s);
		segments.remove(0);






	}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment
		for(int i = 0; i< segments.size(); i++) {
			if(snakeHead.x == segments.get(i).x & snakeHead.y == segments.get(i).y) {
				segments.removeAll(segments);
			}
		}
	}

	/*
	 * Control methods
	 * 
	 * These methods are used to change what is happening to the snake
	 */

	@Override
	public void keyPressed() {
		// Set the direction of the snake according to the arrow keys pressed
		if(key == CODED) {
			if(keyCode == UP) {
				direction = keyCode;
			}
		}
		if(key == CODED) {
			if(keyCode == DOWN) {
				direction = keyCode;
			}
		}
		if(key == CODED) {
			if(keyCode == LEFT) {
				direction = keyCode;
			}
		}
		if(key == CODED) {
			if(keyCode == RIGHT) {
				direction = keyCode;
			}
		}
	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.


		if (direction == UP) {
			// Move head up
			if(0 < snakeHead.y) {
				snakeHead.y -=snakeSpeed;
			}

		} else if (direction == DOWN) {
			if(snakeHead.y < 500) {
				snakeHead.y +=snakeSpeed;
			}
			// Move head down

		} else if (direction == LEFT) {
			if(0< snakeHead.x) {
				snakeHead.x -=snakeSpeed;
			}

		} else if (direction == RIGHT) {
			if(snakeHead.x < 500) {
				snakeHead.x +=snakeSpeed;
			}
		}
		checkBoundaries();
	}

	public void checkBoundaries() {
		// If the snake leaves the frame, make it reappear on the other side
		if (0 >= snakeHead.y) {
			snakeHead.y = 490;
		}
		else if (snakeHead.y >= 500) {
			snakeHead.y = 10;
		}
		else if(0>= snakeHead.x) {
			snakeHead.x = 490;
		}
		else if(snakeHead.x >= 500) {
			snakeHead.x = 10;
		}

	}
	Segment createSegmentAtHead(Segment head) {
		return new Segment(head.x, head.y, ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
	}
	void eat() {
		// When the snake eats the food, its tail should grow and more
		// food appear
		if(snakeHead.x+10 > foodX && snakeHead.x < foodX+10) {
			if(snakeHead.y+10>foodY && snakeHead.y < foodY+10) {
				dropFood();
				food+=1;
				Segment s = createSegmentAtHead(snakeHead);
				segments.add(s); 


			}
		}

	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
