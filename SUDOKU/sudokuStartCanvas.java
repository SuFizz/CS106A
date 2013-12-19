/*
 * File: sudokuStartCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the
 * sudoku are displayed.  NOTE: This class updates the display
 * when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

public void sudokuStartCanvas extends GCanvas implements sudokuConstants{

	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public sudokuStartCanvas(){
		choose = new GLabel("Choose");
		choose.setFont(START_CHOOSE);
		NewGame

		update()
//		add(choose,getWidth())
	}
	
	public void update()
	{
		add(choose, getWidth()/2 - choose.getWidth()/2, getHeight()/2 - choose.getHeight()/2);
	}
	
	private GLabel choose;
	private GButton NewGame;
	private GButton LoadGame;
}
