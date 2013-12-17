/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run()
	{
		while(true)
		{	

			putBeeper();
			if(frontIsBlocked())
				break;
			move();
			turnLeft();
			move();
			turnRight();
		}
		turnAround();
		
		while(frontIsClear())
			move();
		
		turnAround();
		
		while(true)
		{
			if(beepersPresent())
				{
				turnRight();
				while(frontIsClear())
					move();
				putBeeper();
				break;
				}
			move();
			if(beepersPresent())
				{
				turnRight();
				while(frontIsClear())
					move();
				putBeeper();
				break;
				}
			turnRight();
			move();
			
			
			if(beepersPresent())
				{
				turnRight();
				while(frontIsClear())
					move();
				putBeeper();
				break;
				}

			turnLeft();
		}
			
		turnRight();
		while(frontIsClear())
			move();
//		pickBeeper();
		
		turnAround();
		
		while(true)
		{	
			pickBeeper();
			if(frontIsBlocked())
				break;
			move();
			turnLeft();
			move();
			turnRight();
		}
		
		turnRight();
		
		while(frontIsClear())
			move();

		turnRight();
		
		while(noBeepersPresent())
			move();
		
		turnAround();
			
		
	}

	// You fill in this part

}
