/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 17;
	
	
	
	public void run() {
		double CENTERX = getWidth()/2;
//		double CENTERY = getHeight()/2;
		
//		GRect brick = new GRect(CENTERX, getHeight() - BRICKS_IN_BASE * BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT);
		
		for (int i =0; i < BRICKS_IN_BASE; ++i)
		{
			for (int j=0; j<=i; ++j)
				{
				GRect brick = new GRect(CENTERX - (i-j*2)*BRICK_WIDTH/2 , getHeight() - (BRICKS_IN_BASE-i) * BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT);
				add(brick);
				}
		}
		
		
//		add(brick);
	}
}

