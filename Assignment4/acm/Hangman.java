/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int N_GUESSES = 8;
	private static final int R_SEED = -1;
	private HangmanCanvas canvas;

/**-------- SEPARATION BETWEEN METHODS AND VARIABLES ------------*/

	public void init()
	{
		canvas = new HangmanCanvas();
		add(canvas);
	}

	public void run() {
//    	HangmanLexicon word;

    	String lexiconWord = getRandomWord();
    	
    	println("Welcome to Hangman!");
    	
    	canvas.reset();
    	play(lexiconWord);
    	
	}

	private String getRandomWord()
	{
		HangmanLexicon word = new HangmanLexicon();
		int total = word.getWordCount();
    	rgen.setSeed(R_SEED);
		int wordNumber = rgen.nextInt(total);
		String string_word = word.getWord(wordNumber);
		return string_word;
	}
	
	private void play(String lexiconWord)
	{
		int length_string = lexiconWord.length();
		String guess = new String();
		int no_guesses_left = N_GUESSES;
		char guess_char;
		
		
		for(int i =0; i<length_string; ++i)
			guess += "-";

		while(true)
		{
			if(no_guesses_left == 0)
			{
				println("You're completely hung.");
				println("The word was : "+lexiconWord);
				println("You lose.");
				return;
			}
			
			if(guess.indexOf("-") == -1)
			{
				println("You guessed the word :"+lexiconWord);
				println("You win.");
				return;
			}
			
			println("The word now looks like this: "+guess);
			println("You have "+no_guesses_left+" guesses left." );
			String interm = readLine("Your guess : ");
			if(interm.length()>1)
				{
				println("That guess was illegal. Pliss to put 1 letter only.");
				continue;
				}
			guess_char = interm.charAt(0);
			guess_char = Character.toUpperCase(guess_char);
			
			//Figure out if this character is present in the original string
			int idx = lexiconWord.indexOf(guess_char);
			if(idx == -1)
				{println("There are no "+guess_char+"\'s in the word. ");
				--no_guesses_left;
				canvas.noteIncorrectGuess(guess_char);
//				continue;
				}
			else
				{
					println("That guess is correct.");
					while(idx != -1)
						{guess = guess.substring(0,idx)+guess_char+guess.substring(idx+1);
//						println(guess);
						idx = lexiconWord.indexOf(guess_char,idx+1);
						}
//					continue;
					canvas.displayWord(guess);
				}
		}
		
	}
}
