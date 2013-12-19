/*
 * File: sudokuProfile.java
 * ------------------------------
 * This class keeps track of all the information for one profile
 * in the sudoku game.  Each profile contains the numbers that 
 * have been used
 */

import acm.graphics.*;
import java.util.*;
import java.lang.*;

public class sudokuProfile implements sudokuConstants
{
	public sudokuProfile(String filename, String names)
	{
		numbers = new int[BOARD_SIZE][BOARD_SIZE];
		Name = new String();
		
		if(! names.equals(""))
			Name = names;

		if(filename.equals(""))
			for(int i=0; i<BOARD_SIZE; ++i)
				for(int j=0; j<BOARD_SIZE; ++j)
					numbers[i][j] = 0;
		else
			{BufferedReader rd = readFile(filename);
			readData(rd);}
		
	}
	
	private BufferedReader readFile(String filename)
	{
		BufferedReader rd = null;
		while(rd == null)
		{
			try
			{
				rd = new BufferedReader(new FileReader(filename));
			}
		catch(IOException ex){throw new ErrorException(ex);}
		}
		return rd;
	}

	private void readData(BufferedReader rd)
	{
		try
		{
	/**	READING the file contents	*/
			buildMatrix(rd);
			rd.close();
		}catch(IOException ex){
			throw new ErrorException(ex);}
	}

	private void buildMatrix(BufferedReader rd)
	{
		String line = new String();
		for(int i =0; i<BOARD_SIZE; ++i)
		{
			line = rd.readLine();
			if(line==null)	break;

			int prev = -1;
			for(int j=0; j<BOARD_SIZE-1; ++j)						//SPLIT into individual elements
			{
				int temp = line.indexOf(" ", prev+1);
				String numbers = line.substring(prev+1, temp);
				numbers[i][j] = Integer.parseInt(numbers);
				prev = temp;
			}
			numbers[i][BOARD_SIZE-1] = Integer.parseInt(line.substring(prev+1));
		}
		Name = rd.readLine()
		
	}

	public boolean addToBoard(int x, int y, int num)
	{
		X = x;
		Y = y;
		No = num;
		
		boolean aL, cB;
		if (numbers[Y-1][X-1] != 0)
			aL = alongLines(X,Y,No);
			cB = checkInBox();

		if(al && cB)
			{numbers[X-1][Y-1] = No;	return true;}
		else	return false;
			
	}
	
	private boolean alongLines()
	{
		for(int i=0; i<BOARD_SIZE; ++i)
		{	if(numbers[(Y-1+i) % BOARD_SIZE ][X-1] == No)
				return false;
			if(numbers[Y-1][(X-1+i) % BOARD_SIZE] == No)
				return false;}
		return true;
	}
	
	private boolean checkInBox()
	{
		for(int i= (X/BOX_SIZE)*BOX_SIZE; i<(X/BOX_SIZE)*BOX_SIZE + BOX_SIZE; ++i)
			for(int j=(Y/BOX_SIZE)*BOX_SIZE; j<(Y/BOX_SIZE)*BOX_SIZE + BOX_SIZE; ++j)
				if(numbers[j][i] == No)
					return false;
		return true;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public int[][] getNumbers()
	{
		return numbers;
	}

	private String Name;
	private int[][] numbers;
	private int X;
	private int Y;
	private int No;
}
