/*
 * File: sudokuCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the
 * sudoku are displayed.  NOTE: This class updates the display
 * when the window is resized.
 */


import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.applet.*;



public class sudokuCanvas extends GCanvas 
	implements sudokuConstants, ComponentListener {

	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public sudokuCanvas(){
		update();
		addComponentListener(this);
//		addMouseListeners();
	}
	public void clear() {}
	
	public void update(){
		removeAll();

		double spacingX = getWidth()/BOARD_SIZE;
		double spacingY = getHeight()/BOARD_SIZE;

		for(int i=0; i<BOARD_SIZE; ++i){
			add(new GLine(i*spacingX, 0, i*spacingX, getHeight()));
			add(new GLine(0,i*spacingY,getWidth(),i*spacingY));}

		GLine lineX1 = new GLine(getWidth()/BOX_SIZE, 0, getWidth()/BOX_SIZE, getHeight());
		lineX1.setColor(Color.RED);
		add(lineX1);
		
		GLine lineX2 = new GLine(2*getWidth()/BOX_SIZE, 0, 2*getWidth()/BOX_SIZE, getHeight());
		lineX2.setColor(Color.RED);
		add(lineX2);
		
		GLine lineY1 = new GLine(0, getHeight()/BOX_SIZE, getWidth(), getHeight()/BOX_SIZE);
		lineY1.setColor(Color.RED);
		add(lineY1);
		
		GLine lineY2 = new GLine(0, 2*getHeight()/BOX_SIZE, getWidth(), 2*getHeight()/BOX_SIZE);
		lineY2.setColor(Color.RED);
		add(lineY2);
		}
		
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
