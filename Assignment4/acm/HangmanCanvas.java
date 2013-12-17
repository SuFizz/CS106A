/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		guessesRemaining = TOTAL_GUESSES_ALLOWED;
		CENTERX = getWidth()/2;
		CENTERY = getHeight()/2;

//SET up the guessed word
		guess = new GLabel("");
		guess.setFont("sanserif-30");
		add(guess, CENTERX - BEAM_LENGTH + SPACE, CENTERY + SCAFFOLD_HEIGHT/2 + SPACE + guess.getHeight());

//SET up the guess characters made
		guesses_made = new GLabel("");
		guesses_made.setFont("sanserif-20");
		add(guesses_made, CENTERX - BEAM_LENGTH + SPACE, CENTERY + SCAFFOLD_HEIGHT/2 + SPACE + guess.getHeight() + SPACE);
		guesse_made_str = new String("");
		
//SET up the starting off structure
		GLine scaff_left = new GLine(CENTERX - BEAM_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2, CENTERX - BEAM_LENGTH, CENTERY + SCAFFOLD_HEIGHT/2);
		add(scaff_left);
		
		GLine scaff_top = new GLine(CENTERX - BEAM_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2, CENTERX, CENTERY - SCAFFOLD_HEIGHT/2);
		add(scaff_top);
		
		GLine rope = new GLine(CENTERX, CENTERY - SCAFFOLD_HEIGHT/2, CENTERX,  CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH);
		add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		guess.setLabel(word);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
	
		if(guessesRemaining == 0)
			return;
		
		switch(guessesRemaining){
		case 8: 
		{
			GOval head = new GOval(CENTERX - HEAD_RADIUS, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH,HEAD_RADIUS*2,HEAD_RADIUS*2);
			add(head);
			break;
		}
		
		case 7:
		{
			GLine body = new GLine(CENTERX, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2, CENTERX, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH);
			add(body);
			break;
		}
		
		case 6:
		{
			GLine leftarm = new GLine(CENTERX - UPPER_ARM_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD, CENTERX, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD);
			add(leftarm);
			
			GLine leftlower = new GLine(CENTERX - UPPER_ARM_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD, CENTERX - UPPER_ARM_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
			add(leftlower);
			
			break;
		}
		
		case 5:
		{
			GLine rightarm = new GLine(CENTERX + UPPER_ARM_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD, CENTERX, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD);
			add(rightarm);
			
			GLine rightlower = new GLine(CENTERX + UPPER_ARM_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD, CENTERX + UPPER_ARM_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
			add(rightlower);
			
			break;			
		}
		
		case 4:
		{
			GLine leftleg = new GLine(CENTERX, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH, CENTERX - HIP_WIDTH/2 , CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH);
			
			add(leftleg);
			
			GLine leftdown = new GLine(CENTERX - HIP_WIDTH/2 , CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH, CENTERX - HIP_WIDTH/2 , CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH + LEG_LENGTH);
			
			add(leftdown);
			break;
		}
		
		case 3:
		{
			GLine rightleg = new GLine(CENTERX, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH, CENTERX + HIP_WIDTH/2 , CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH);
			
			add(rightleg);
			
			GLine rightdown = new GLine(CENTERX + HIP_WIDTH/2 , CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH, CENTERX + HIP_WIDTH/2 , CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH + LEG_LENGTH);
			
			add(rightdown);
			break;
		}
		
		case 2:
		{
			GLine leftfoot = new GLine(CENTERX - HIP_WIDTH/2, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH + LEG_LENGTH, CENTERX - HIP_WIDTH/2 - FOOT_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH + LEG_LENGTH);
			add(leftfoot);
			break;
		}
		
		case 1:
		{
			GLine rightfoot = new GLine(CENTERX + HIP_WIDTH/2, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH + LEG_LENGTH, CENTERX + HIP_WIDTH/2 + FOOT_LENGTH, CENTERY - SCAFFOLD_HEIGHT/2 + ROPE_LENGTH + HEAD_RADIUS*2 + BODY_LENGTH + LEG_LENGTH);
			add(rightfoot);
			break;
		}
		
		default:{
			GLabel die = new GLabel("YOU LOSE!!");
			add(die,SPACE, die.getHeight()+SPACE);
			}

		}

		guessesRemaining--;
		guesse_made_str += letter;
		guesses_made.setLabel(guesse_made_str);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int SPACE = 30;
	private static final int TOTAL_GUESSES_ALLOWED = 8;

	private double CENTERX;
	private double CENTERY;
	private int guessesRemaining;
	private GLabel guesses_made;
	private GLabel guess;
	private String guesse_made_str;
}
