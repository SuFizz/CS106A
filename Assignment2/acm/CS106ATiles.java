/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	private static final int TILE_WIDTH = 60;
	private static final int TILE_HEIGHT= 30;
	
	public void run() {
	
	double centerX = getWidth()/2;
	double centerY = getHeight()/2;

		GRect rect00 = new GRect(centerX - TILE_SPACE/2.0 - TILE_WIDTH, centerY - TILE_SPACE/2 - TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		GRect rect01 = new GRect(centerX + TILE_SPACE/2.0, centerY - TILE_SPACE/2 - TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		GRect rect10 = new GRect(centerX - TILE_SPACE/2.0 - TILE_WIDTH, centerY + TILE_SPACE/2, TILE_WIDTH, TILE_HEIGHT);
		GRect rect11 = new GRect(centerX + TILE_SPACE/2.0, centerY + TILE_SPACE/2, TILE_WIDTH, TILE_HEIGHT);
		add(rect00);
		add(rect01);
		add(rect10);
		add(rect11);
		
		GLabel label00 = new GLabel("CS106A",centerX - TILE_SPACE/2 - TILE_WIDTH/2, centerY-TILE_SPACE/2 - TILE_HEIGHT/2);
//		label00.setFont("sansSerif-30");

		GLabel label01 = new GLabel("CS106A",centerX + TILE_SPACE/2 + TILE_WIDTH/2, centerY-TILE_SPACE/2 - TILE_HEIGHT/2);


		GLabel label10 = new GLabel("CS106A",centerX - TILE_SPACE/2 - TILE_WIDTH/2, centerY+TILE_SPACE/2 + TILE_HEIGHT/2);


		GLabel label11 = new GLabel("CS106A",centerX + TILE_SPACE/2 + TILE_WIDTH/2, centerY+TILE_SPACE/2 + TILE_HEIGHT/2);

		

		double widthLabel = label00.getWidth();
		double heightLabel = label00.getHeight();

		label00.move(-widthLabel/2,heightLabel/2);
		label01.move(-widthLabel/2,heightLabel/2);
		label10.move(-widthLabel/2,heightLabel/2);
		label11.move(-widthLabel/2,heightLabel/2);
		
		add(label00);
		add(label01);
		add(label10);
		add(label11);
		
	}
}
