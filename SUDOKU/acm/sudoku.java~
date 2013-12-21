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
//		setSize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
		ButtonGroup leftGroup = new ButtonGroup();

		leftSide1 = new JRadioButton("");
		leftSide2 = new JRadioButton("");
		leftSide3 = new JRadioButton("");
		leftSide4 = new JRadioButton("");
		leftSide5 = new JRadioButton("");
		leftSide6 = new JRadioButton("");
		leftSide7 = new JRadioButton("");
		leftSide8 = new JRadioButton("");
		leftSide9 = new JRadioButton("");

		leftGroup.add(leftSide1);
		leftGroup.add(leftSide2);
		leftGroup.add(leftSide3);
		leftGroup.add(leftSide4);
		leftGroup.add(leftSide5);
		leftGroup.add(leftSide6);
		leftGroup.add(leftSide7);
		leftGroup.add(leftSide8);
		leftGroup.add(leftSide9);

		add(leftSide1,WEST);
//		add(new JLabel("\n"),WEST);
//		add(new JLabel("\n"),WEST);

		add(leftSide2,WEST);
//		add(new JLabel("\n"),WEST);
//		add(new JLabel("\n"),WEST);

		add(leftSide3,WEST);
//		add(new JLabel("\n"),WEST);
//		add(new JLabel("\n"),WEST);

		add(leftSide4,WEST);
//		add(new JLabel("\n"),WEST);
//		add(new JLabel("\n"),WEST);

		add(leftSide5,WEST);
//		add(new JLabel("\n"),WEST);
//		add(new JLabel("\n"),WEST);

		add(leftSide6,WEST);
//		add(new JLabel("\n"),WEST);
//		add(new JLabel("\n"),WEST);

		add(leftSide7,WEST);
//		add(new JLabel("\n"),WEST);
//		add(new JLabel("\n"),WEST);

		add(leftSide8,WEST);
//		add(new JLabel("\n"),WEST);
//		add(new JLabel("\n"),WEST);

		add(leftSide9,WEST);
		leftSide9.setSelected(true);


		ButtonGroup topGroup = new ButtonGroup();

		topSide1 = new JRadioButton("");
		topSide2 = new JRadioButton("");
		topSide3 = new JRadioButton("");
		topSide4 = new JRadioButton("");
		topSide5 = new JRadioButton("");
		topSide6 = new JRadioButton("");
		topSide7 = new JRadioButton("");
		topSide8 = new JRadioButton("");
		topSide9 = new JRadioButton("");

		topGroup.add(topSide1);
		topGroup.add(topSide2);
		topGroup.add(topSide3);
		topGroup.add(topSide4);
		topGroup.add(topSide5);
		topGroup.add(topSide6);
		topGroup.add(topSide7);
		topGroup.add(topSide8);
		topGroup.add(topSide9);

		add(topSide1,NORTH);
//		add(new JLabel("        "),NORTH);
//		add(new JLabel("\n"),NORTH);

		add(topSide2,NORTH);
//		add(new JLabel("\n"),NORTH);
//		add(new JLabel("        "),NORTH);

		add(topSide3,NORTH);
//		add(new JLabel("        "),NORTH);
//		add(new JLabel("\n"),NORTH);

		add(topSide4,NORTH);
//		add(new JLabel("        "),NORTH);
//		add(new JLabel("\n"),NORTH);

		add(topSide5,NORTH);
//		add(new JLabel("\n"),NORTH);
//		add(new JLabel("        "),NORTH);

		add(topSide6,NORTH);
//		add(new JLabel("        "),NORTH);
//		add(new JLabel("\n"),NORTH);

		add(topSide7,NORTH);
//		add(new JLabel("        "),NORTH);
//		add(new JLabel("\n"),NORTH);

		add(topSide8,NORTH);
//		add(new JLabel("        "),NORTH);
//		add(new JLabel("\n"),NORTH);

		add(topSide9,NORTH);
		topSide9.setSelected(true);


//		for(int i =0; i<BOARD_SIZE; ++i)
			
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
     
    public void makers()
    {
    	if(leftSide1.isSelected())
    		LeftSide = 1;
    	else if(leftSide2.isSelected())
    		LeftSide = 2;
    	else if(leftSide3.isSelected())
    		LeftSide = 3;
    	else if(leftSide4.isSelected())
    		LeftSide = 4;
    	else if(leftSide5.isSelected())
    		LeftSide = 5;
    	else if(leftSide6.isSelected())
    		LeftSide = 6;
    	else if(leftSide7.isSelected())
    		LeftSide = 7;
    	else if(leftSide8.isSelected())
    		LeftSide = 8;
    	else if(leftSide9.isSelected())
    		LeftSide = 9;

    	if(topSide1.isSelected())
    		TopSide = 1;
    	else if(topSide2.isSelected())
    		TopSide = 2;
    	else if(topSide3.isSelected())
    		TopSide = 3;
    	else if(topSide4.isSelected())
    		TopSide = 4;
    	else if(topSide5.isSelected())
    		TopSide = 5;
    	else if(topSide6.isSelected())
    		TopSide = 6;
    	else if(topSide7.isSelected())
    		TopSide = 7;
    	else if(topSide8.isSelected())
    		TopSide = 8;
    	else if(topSide9.isSelected())
    		TopSide = 9;
    	
    	display.putBig(LeftSide,TopSide);

    }
    public void actionPerformed(ActionEvent e)
    {
    	display.update();
	    String but_pressed = e.getActionCommand();
		String nameF = nameField.getText();
		if(e.getSource() == nameField || but_pressed.equals("LOAD GAME"))	{
			if(nameF != ""){
				makers();
				game = new sudokuProfile(nameF, EMPTY_STRING);
				display.initArray(game.getNumbers(),Color.BLUE);
				gameInProgress = nameF;}
			}
		if(but_pressed.equals("NEW GAME"))
			{
			makers();
			game = new sudokuProfile(EMPTY_STRING,"sufiyan");
			display.initArray(game.getNumbers(),Color.BLUE);
//			add(new GLabel(game.getName(),10,10));
			gameInProgress = "default.txt";
			}
    }
    
//	public void mouseClicked(MouseEvent e)
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
    private int LeftSide = 9;
    private int TopSide = 9;


	private JRadioButton leftSide1;
	private JRadioButton leftSide2;
	private JRadioButton leftSide3;
	private JRadioButton leftSide4;
	private JRadioButton leftSide5;
	private JRadioButton leftSide6;
	private JRadioButton leftSide7;
	private JRadioButton leftSide8;
	private JRadioButton leftSide9;
	
	private JRadioButton topSide1;
	private JRadioButton topSide2;
	private JRadioButton topSide3;
	private JRadioButton topSide4;
	private JRadioButton topSide5;
	private JRadioButton topSide6;
	private JRadioButton topSide7;
	private JRadioButton topSide8;
	private JRadioButton topSide9;
}
