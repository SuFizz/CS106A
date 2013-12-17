/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.math.*;

public class Target extends GraphicsProgram {
	
	private static final int OutRad = (1)* 72;
	private static final double MidRad = (0.65)* 72;
	private static final double InRad = (0.3)* 72;
//	double CENTERX = getWidth()/2;
//	double CENTERY = getHeight()/2;
	public void run() {
		double CENTERX = getWidth()/2;
		double CENTERY = getHeight()/2;
		GOval OutCircle = new GOval(CENTERX - OutRad, CENTERY - OutRad, 2*OutRad, 2*OutRad);
		OutCircle.setFilled(true);
		OutCircle.setFillColor(Color.RED);
//		OutCircle.
		add(OutCircle);
		
		
		GOval MidCircle = new GOval(CENTERX - MidRad, CENTERY - MidRad, 2*MidRad, 2*MidRad);
		MidCircle.setFilled(true);
		MidCircle.setFillColor(Color.WHITE);
		add(MidCircle);
		
		GOval InCircle = new GOval(CENTERX - InRad, CENTERY - InRad, 2*InRad, 2*InRad);
		InCircle.setFilled(true);
		InCircle.setFillColor(Color.RED);
		add(InCircle);
	}
}
