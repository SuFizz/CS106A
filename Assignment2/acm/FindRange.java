/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;
import java.math.*;

public class FindRange extends ConsoleProgram {
	private static final int SENTINEL = 0;
	public void run() {
		println("This program finds the largest and smallest numbers.");
		
		int number = readInt("?");
		if(number == SENTINEL)
			{println("No numbers entered. Exiting.");
			return;
			}

		int minimum = number;
		int maximum = number;
		
		while(true)
		{
			int numer = readInt("?");
			if(numer == SENTINEL)
				break;

			if(minimum > numer)
				minimum = numer;
			if(maximum < numer)
				maximum = numer;
		}
		println("smallest: " + minimum);
		println("largest: " + maximum);
				
	}
}

