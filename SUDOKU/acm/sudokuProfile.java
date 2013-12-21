/*
 * File: sudokuProfile.java
 * ------------------------------
 * This class keeps track of all the information for one profile
 * in the sudoku game.  Each profile contains the numbers that 
 * have been used
 */
import java.io.*;
import acm.graphics.*;
import java.util.*;
import java.lang.*;

import acm.program.*;
import acm.util.*;


public class sudokuProfile implements sudokuConstants
{
	public sudokuProfile(String filename, String names)
	{
		rgen = RandomGenerator.getInstance();
//		rgen.setSeed();

		numbers = new int[(int)BOARD_SIZE][(int)BOARD_SIZE];
		
		for(int i=0; i<BOARD_SIZE; ++i)
			for(int j=0; j<BOARD_SIZE; ++j)
				numbers[i][j] = -1;
		
		Name = new String();
		
		if(! names.equals(""))
			Name = names;

		if(filename.equals(""))	starter();
		else
			{BufferedReader rd = null;
			rd = readFile(filename);
			readData(rd);}
		
	}
	
	private void starter()
	{
		for(int i=0; i<BOARD_SIZE; ++i)
			for(int j=0; j<BOARD_SIZE; ++j)
				{int num = (rgen.nextInt(-20,9));
//				numbers[j][i] = num;}
				boolean ty = addToBoard(j+1, i+1, num);}
	}
	
	private BufferedReader readFile(String filename)
	{
		BufferedReader rd = null;
		while(rd == null)
		{
		try	{rd = new BufferedReader(new FileReader(filename));}
		catch(IOException ex){throw new ErrorException(ex);}
		}
		return rd;
	}

	private void readData(BufferedReader rd)
	{
		try
		{
	/**	READING the file contents	*/
		String line = new String();
		for(int i =0; i<BOARD_SIZE; ++i)
		{
			line = rd.readLine();
			if(line==null)	break;
			int prev = -1;
			for(int j=0; j<BOARD_SIZE-1; ++j)						//SPLIT into individual elements
			{
				int temp = line.indexOf(" ", prev+1);
				String numb = line.substring(prev+1, temp);
				numbers[i][j] = Integer.parseInt(numb);
				prev = temp;
			}
			numbers[i][BOARD_SIZE-1] = Integer.parseInt(line.substring(prev+1));
		}
		Name = rd.readLine();
	/**End of reading file contents*/

		rd.close();
		}catch(IOException ex){
			throw new ErrorException(ex);}
	}

	public boolean addToBoard(int X, int Y, int No)
	{
		if(No <=0)	return false;
		
		boolean aL, cB;
		aL = false;
		cB = false;

		if (numbers[Y-1][X-1] == -1)
			{aL = alongLines(X,Y,No);
			cB = checkInBox(X,Y,No);}
		else	return false;

		if(aL == true && cB == true)
			{numbers[Y-1][X-1] = No;	return true;}
		else	return false;
	}
	
	private boolean alongLines(int X, int Y, int No)
	{
		for(int i=0; i<BOARD_SIZE; ++i)
		{	if(numbers[i][X-1] == No)
				return false;
			if(numbers[Y-1][i] == No)
				return false;}
		return true;
	}
	
	private int u(int number)
	{
		if(number<=0)
			return 1;
		else
			return number;
	}
	
	private boolean checkInBox(int X, int Y, int No)
	{
		for(int i= ((X-1)/BOX_SIZE)*BOX_SIZE; i<((X-1)/BOX_SIZE)*BOX_SIZE + BOX_SIZE; ++i)
			for(int j=((Y-1)/BOX_SIZE)*BOX_SIZE; j<((Y-1)/BOX_SIZE)*BOX_SIZE + BOX_SIZE; ++j)
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
//	private int X;
//	private int Y;
//	private int No;
	private RandomGenerator rgen;
}
