/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter a number: ");
		int times = 0;
		while(true)
		{
			if(n == 1)
				break;
			++times;
			
			if(n%2 == 1)
			{
				n = 3*n +1;
				println(n + " is odd, so I make 3n + 1: "+ n);
			}
			else
			{
				n /= 2;
				println(n + " is even, so I take half: "+n);
			}			
		}
		println("The process took "+times+" to reach 1");
	}
}

