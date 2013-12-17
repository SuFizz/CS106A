/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels.  On some platforms 
  * these may NOT actually be the dimensions of the graphics canvas. */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board.  On some platforms these may NOT actually
  * be the dimensions of the graphics canvas. */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/**	No of rows of bricks of a particular color*/
	private static final int NROWS_PER_COLOR = 2;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		setupGame();
//		playGame();
	}
	private void setupGame()
	{
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		for (int i=0; i<NROWS_PER_COLOR; ++i)
			for (int j = 0; j< NBRICKS_PER_ROW; ++j)
			{
				GRect reds = new GRect(BRICK_SEP/2 + j*(BRICK_WIDTH + BRICK_SEP), BRICK_Y_OFFSET+i*(BRICK_HEIGHT+ BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);
				reds.setFilled(true);
				reds.setFillColor(Color.RED);
				add(reds);
			}
		
		for (int i=NROWS_PER_COLOR; i<NROWS_PER_COLOR*2; ++i)
			for (int j = 0; j< NBRICKS_PER_ROW; ++j)
			{
				GRect reds = new GRect(BRICK_SEP/2 + j*(BRICK_WIDTH+ BRICK_SEP), BRICK_Y_OFFSET+i*(BRICK_HEIGHT+ BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);
				reds.setFilled(true);
				reds.setFillColor(Color.ORANGE);
				add(reds);
			}
		
		for (int i=NROWS_PER_COLOR*2; i<NROWS_PER_COLOR*3; ++i)
			for (int j = 0; j< NBRICKS_PER_ROW; ++j)
			{
				GRect reds = new GRect(BRICK_SEP/2 + j*(BRICK_WIDTH+ BRICK_SEP), BRICK_Y_OFFSET+i*(BRICK_HEIGHT+ BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);
				reds.setFilled(true);
				reds.setFillColor(Color.YELLOW);
				add(reds);
			}
		
		for (int i=NROWS_PER_COLOR*3; i<NROWS_PER_COLOR*4; ++i)
			for (int j = 0; j< NBRICKS_PER_ROW; ++j)
			{
				GRect reds = new GRect(BRICK_SEP/2 + j*(BRICK_WIDTH+ BRICK_SEP), BRICK_Y_OFFSET+i*(BRICK_HEIGHT+ BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);
				reds.setFilled(true);
				reds.setFillColor(Color.GREEN);
				add(reds);
			}
		
		for (int i=NROWS_PER_COLOR*4; i<NROWS_PER_COLOR*5; ++i)
			for (int j = 0; j< NBRICKS_PER_ROW; ++j)
			{
				GRect reds = new GRect(BRICK_SEP/2 + j*(BRICK_WIDTH+ BRICK_SEP), BRICK_Y_OFFSET+i*(BRICK_HEIGHT+ BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);
				reds.setFilled(true);
				reds.setFillColor(Color.CYAN);
				add(reds);
			}
		
			

	}
}
