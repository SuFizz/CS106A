/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;
//import yahtzeelib.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {

	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {

		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		scorerr = new int[N_CATEGORIES][nPlayers];
		for(int yy=0; yy<N_CATEGORIES; ++yy)
			for(int xx=0; xx<nPlayers; ++xx)
				scorerr[yy][xx] = -1;
		
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
	for(int noPlays =0; noPlays <N_SCORING_CATEGORIES;++noPlays)
	{
		for(int i =1; i<= nPlayers; ++i)
		{
			display.printMessage(playerNames[i-1]+"'s turn! Click \"Roll Dice\" button to roll the dice.");
			display.waitForPlayerToClickRoll(i);

/**	Create the Random Dice configuration for the player 'i'*/
			int[] dice = new int[5];
			for(int j =0; j< 5; ++j)
				dice[j] = rgen.nextInt(1,6);

			display.displayDice(dice);

/**	Ask for the 2nd and 3rd times*/
			for(int y=0;y<2;++y){
				display.printMessage("Select the dice you wish to re-roll and click \"Roll Again\".");
			
				display.waitForPlayerToSelectDice();
//				display.waitForPlayerToClickRoll(i);
			
				for(int j =0; j< N_DICE; ++j)
					if(display.isDieSelected(j))
						dice[j] = rgen.nextInt(1,6);
//				display.printMessage(""+dice[0]+dice[1]+dice[2]+dice[3]+dice[4]+dice[5]);
//				waitForClick();
				display.displayDice(dice);
				}
//			for(int k=0; k<N_SCORING_CATEGORIES;++k)
				int category_selected = display.waitForPlayerToSelectCategory();
				while(scorerr[category_selected-1][i-1] != -1)
					{
					display.printMessage("You already picked that category. Please choose another category.");
					category_selected = display.waitForPlayerToSelectCategory();
					}
				int score = checkCategory(dice, category_selected);
				
				display.updateScorecard(category_selected,i,score);
				scorerr[category_selected - 1][i-1] = score;
				
				int next_cat = 0;
				int up;
				for(up = 0; up<SIXES; ++up)
					if(scorerr[up][i-1] == -1)
						break;
					else
						next_cat += scorerr[up][i-1];
				if (up == SIXES)
					{display.updateScorecard(UPPER_SCORE, i, next_cat);
					scorerr[UPPER_SCORE - 1][i-1] = next_cat;
					if(next_cat >=63)
						{display.updateScorecard(UPPER_BONUS, i, 35);
						scorerr[UPPER_BONUS - 1][i-1] = 35;
						}
					else	scorerr[UPPER_BONUS - 1][i-1] = 0;
					}
				int lowscore = 0;
				int down;
				for(down = THREE_OF_A_KIND-1; down <CHANCE; ++down)
					if(scorerr[down][i-1] == -1)
						break;
					else
						lowscore += scorerr[down][i-1];

				if (down == CHANCE)
					{display.updateScorecard(LOWER_SCORE, i, lowscore);
					scorerr[LOWER_SCORE - 1][i-1] = lowscore;
					}
		}
		}
		
		for (int players =0; players < nPlayers; ++players)
		{
			scorerr[TOTAL-1][players] = 0;
			for(int j =0; j< TOTAL; ++j)
				scorerr[TOTAL-1][players] += scorerr[j][players];
		}
		
		int maximum = scorerr[TOTAL-1][0];
		int winner = 0;
		for (int players =0; players < nPlayers; ++players)
			if(maximum < scorerr[TOTAL-1][players])
				{maximum = scorerr[TOTAL-1][players];winner = players;}
		display.printMessage("Congratulations, "+playerNames[winner]+", you\'re the winner with a total score of "+maximum);
	}
	
	private int checkCategory(int[] dice, int category_selected)
	{
		int scores = 0;
		switch (category_selected)
		{
			case ONES:
			{
				int score = 0;
				for(int j =0; j<N_DICE; ++j)
					if(dice[j] == ONES)
						score += ONES;
				return score;
			}
			
			case TWOS:
			{
				int score = 0;
				for(int j =0; j<N_DICE; ++j)
					if(dice[j] == TWOS)
						score += TWOS;
				return score;
			}

			case THREES:
			{
				int score = 0;
				for(int j =0; j<N_DICE; ++j)
					if(dice[j] == THREES)
						score += THREES;
				return score;
			}
			
			case FOURS:
			{
				int score = 0;
				for(int j =0; j<N_DICE; ++j)
					if(dice[j] == FOURS)
						score += FOURS;
				return score;
			}

			case FIVES:
			{
				int score = 0;
				for(int j =0; j<N_DICE; ++j)
					if(dice[j] == FIVES)
						score += FIVES;
				return score;
			}
			
			case SIXES:
			{
				int score = 0;
				for(int j =0; j<N_DICE; ++j)
					if(dice[j] == SIXES)
						score += SIXES;
				return score;
			}
			
			case THREE_OF_A_KIND:
			{
				int score = 0;
				int flag = 0;
				for(int ii=0; ii<N_DICE; ++ii)
				{	for(int j=ii; j<N_DICE; ++j)
						{
						if(dice[ii] != dice[j])	continue;
						for(int k=j; k<N_DICE; ++k)
							if(dice[k] == dice[j])
								{flag = 1;break;}
						if (flag==1)	break;
						}
					if(flag==1)		break;
				}
				if(flag == 0)
					return 0;

				else if(flag == 1)
					for(int j =0; j<N_DICE; ++j)
							score += dice[j];
					return score;
			}
			
			case FOUR_OF_A_KIND:
			{
				int score = 0;
				int flag = 0;
				for(int ii=0; ii<N_DICE; ++ii)
				{
					for(int j=ii+1; j<N_DICE; ++j)
						{
						if(dice[ii] != dice[j])	continue;
						for(int k=j+1; k<N_DICE; ++k)
						{	if(dice[k] != dice[j])	continue;
							for(int kk=k+1; kk<N_DICE; ++kk)
								if(dice[kk] != dice[j])
									{flag = 1;break;}
							if (flag==1)	break;
						}
						if(flag==1)		break;
						}
					if(flag==1)		break;
				}
				if(flag == 0)
					return 0;

				else if(flag == 1)
					for(int j =0; j<N_DICE; ++j)
							score += dice[j];
				return score;
			}
			
			case FULL_HOUSE:
			{
				int score = 0;
				int flag = 0;
				int ii = 0;
				int j = 0;
				int k = 0;
				for(ii=0; ii<N_DICE; ++ii)
				{
					for(j=ii+1; j<N_DICE; ++j)
						{
						if(dice[ii] != dice[j])	continue;
						for(k=j+1; k<N_DICE; ++k)
							if(dice[k] == dice[j])
								{flag = 1;break;}
						if(flag==1)	break;
						}
					if(flag==1)		break;
				}
				if(flag == 0)
					return 0;
				
				int memory = -1;
				for(int y=0;y<N_DICE;++y)
				{
					if(y==ii ||y==j||y==k)
						continue;
					else if(memory == -1)
						{memory = dice[y];continue;}
					else
						if(memory == dice[y])
							{flag = 2;break;}
				}
				
				if(flag==1)	return 0;
				else if (flag==2)
					return 25;
				
			}
			
			case SMALL_STRAIGHT:
			{
			//The only possible sequences I need to care about are 
			// 1-2-3-4
			// 2-3-4-5
			// 3-4-5-6
			int flag1 = 0;
			int flagenter1 =0;
			int flagenter2 =0;
			int flagenter3 =0;
			int flagenter4 =0;
			
			for(int ii =0;ii<N_DICE;++ii)
			{
				if(dice[ii] == 1 && flagenter1 == 0)
					{flag1++; flagenter1 = 1; continue;}
				else if(dice[ii] == 2 && flagenter2 == 0)
					{flag1++; flagenter2 = 1; continue;}
				else if(dice[ii] == 3 && flagenter3 == 0)
					{flag1++;flagenter3 = 1;continue;}
				else if(dice[ii] == 4 && flagenter4 == 0)
					{flag1++;flagenter4 = 1;continue;}
			}

			flagenter1 =0;
			flagenter2 =0;
			flagenter3 =0;
			flagenter4 =0;

			
			int flag2 = 0;
			for(int ii =0;ii<N_DICE;++ii)
			{
				if(dice[ii] == 5 && flagenter1 ==0)
					{flag2++;flagenter1 = 1;continue;}
				else if(dice[ii] == 2 && flagenter2 ==0)
					{flag2++;flagenter2 = 1;continue;}
				else if(dice[ii] == 3 && flagenter3 ==0)
					{flag2++;flagenter3 = 1;continue;}
				else if(dice[ii] == 4 && flagenter4 ==0)
					{flag2++;flagenter4 = 1;continue;}
			}

			flagenter1 =0;
			flagenter2 =0;
			flagenter3 =0;
			flagenter4 =0;

			int flag3 = 0;
			for(int ii =0;ii<N_DICE;++ii)
			{
				if(dice[ii] == 5 && flagenter1 ==0)
					{flag3++;flagenter1 = 1;continue;}
				else if(dice[ii] == 6 && flagenter2 ==0)
					{flag3++;flagenter2 = 1;continue;}
				else if(dice[ii] == 3 && flagenter3 ==0)
					{flag3++;flagenter3 = 1;continue;}
				else if(dice[ii] == 4 && flagenter4 ==0)
					{flag3++;flagenter4 = 1;continue;}
			}
			
			if(flag1 == 4 || flag2 ==4 || flag3 == 4)
				return 30;
			else
				return 0;
			}
			
			case LARGE_STRAIGHT:
			{
			
			int flagenter1 =0;
			int flagenter2 =0;
			int flagenter3 =0;
			int flagenter4 =0;
			int flagenter5 =0;
			
				int flag = 0;
				for(int ii =0;ii<N_DICE;++ii)
				{
					if(dice[ii] == 1&& flagenter1 ==0)
						{flag++;flagenter1 = 1;continue;}
					else if(dice[ii] == 2&& flagenter2 ==0)
						{flag++;flagenter2 = 1;continue;}
					else if(dice[ii] == 3&& flagenter3 ==0)
						{flag++;flagenter3 = 1;continue;}
					else if(dice[ii] == 4&& flagenter4 ==0)
						{flag++;flagenter4 = 1;continue;}
					else if(dice[ii] == 5&& flagenter5 ==0)
						{flag++;flagenter5 = 1;continue;}
				}
				
				int flag_ = 0;
				for(int ii =0;ii<N_DICE;++ii)
				{
					if(dice[ii] == 6&& flagenter1 ==0)
						{flag_++;flagenter1 = 1;continue;}
					else if(dice[ii] == 2&& flagenter2 ==0)
						{flag_++;flagenter2 = 1;continue;}
					else if(dice[ii] == 3&& flagenter3 ==0)
						{flag_++;flagenter3 = 1;continue;}
					else if(dice[ii] == 4&& flagenter4 ==0)
						{flag_++;flagenter4 = 1;continue;}
					else if(dice[ii] == 5&& flagenter5 ==0)
						{flag_++;flagenter5 = 1;continue;}
				}
				if(flag == 5||flag_==5)
					return 40;
				else
					return 0;
			}
			
			case YAHTZEE:
			{
				int start = dice[0];
				for(int ii = 1;ii<N_DICE;++ii)
					if(dice[ii] != start)
						return 0;
				else
					return 50;
			}
			
			case CHANCE:
			{
			int score = 0;
			for(int j =0; j<N_DICE; ++j)
				score += dice[j];
			return score;
			}
		}
		return scores;
	}
		
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	private int[][] scorerr;

}
