/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run()
	{
		boolean place = false;	//false means DOWN ; true means UP
//		boolean finished = false;	//whether you have finished a column

		while (true)
		{
//			if(finished)
//			{
				
//				finished = false;
//				if(frontIsBlocked())
//					break;
//			}
			
			if(place)
				{turnRight();
				place = false;}
			else
				{turnLeft();
				place = true;}

			while(frontIsClear())
				if(noBeepersPresent())
				{
					putBeeper();
					move();
				}
				else
					move();
				if(noBeepersPresent())
					putBeeper();

			if(place)
				turnRight();
			else
				turnLeft();

			if(frontIsBlocked())
				break;

			for(int i=0;i<4;++i)
				move();
//			finished = true;
		}		
				
	}
	// You fill in this part

}
