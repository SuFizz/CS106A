/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run()
	{
		while(true)
			{
			while(frontIsClear())
			{
				putBeeper();
				move();
				if(frontIsBlocked())
					break;
				move();
				
			}
			if(leftIsBlocked())
				break;
			else
				{turnLeft();
				move();
				turnLeft();}
			putBeeper();
			while(frontIsClear())
			{
//				putBeeper();
				move();
				if(frontIsBlocked())
					break;
				move();
				putBeeper();
			}
			if(rightIsBlocked())
				break;
			else
				{turnRight();
				move();
				turnRight();}
			}
	}
	// You fill in this part

}
