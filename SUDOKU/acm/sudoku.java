/* 
 * File: sudoku.java
 * -----------------------
 * When it is finished, this program will implement a basic sudoku puzzle
 */
import java.io.*;
import acm.graphics.*;
import java.util.*;
import java.lang.*;

import acm.program.*;
import acm.util.*;

import java.awt.event.*;
import javax.swing.*;

import java.applet.*;
import java.awt.*;

import java.*;

public class sudoku extends Program implements sudokuConstants{

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init()
	{
		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		gameInProgress = new String();
		display = new sudokuCanvas();
		add(display);

		add(new JButton("NEW GAME"), SOUTH);

		add(new JLabel("File Name : "), SOUTH);

		nameField = new JTextField(TEXT_FIELD_SIZE);
		add(nameField,SOUTH);

		add(new JButton("LOAD GAME"), SOUTH);

		addActionListeners();
		nameField.addActionListener(this);

//		addMouseListeners();
//		addKeyListeners();
	}
	
	/**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e)
    {
    	display.update();
	    String but_pressed = e.getActionCommand();
		String nameF = nameField.getText();
		if(e.getSource() == nameField || but_pressed.equals("LOAD GAME"))	{
			if(nameF != ""){
				game = new sudokuProfile(nameF, EMPTY_STRING);
				gameInProgress = nameF;}
			}
		if(but_pressed.equals("NEW GAME"))
			{
			game = new sudokuProfile(EMPTY_STRING,"sufiyan");
//			add(new GLabel(game.getName(),10,10));
			gameInProgress = "default.txt";
			}
    }
    
//   	public void mouseClicked(MouseEvent e)
//	{
//	 clkX = e.getX();
//	 clkY = e.getY();
//	 for(int i=0; i<9; ++i)
//	 	for(int j =0 ; j<9; ++j)
//	 		add(new GLabel(""+game.getNumbers()[i][j],clkX + j*30,clkY + i*30));
//	}

	private JTextField nameField;
//	private GLabel choose;
//	private JButton NewGame;
//	private JButton LoadGame;
	private sudokuProfile game;
	private String gameInProgress;
//	private static int gameNo;
	private double clkX;
	private double clkY;
	private sudokuCanvas display;
}
