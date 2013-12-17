/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon{

	private static final int SIZE_WORDLIST = 121810;
	private ArrayList <String> wordlist;
//	private int i;

	public HangmanLexicon()
	{
		BufferedReader rd = readFiles("hello");
		

		wordlist = new ArrayList <String> ();
//		i = 0;
		try
		{
			while(true)
			{
				String line = rd.readLine();
				if(line==null) break;
				wordlist.add(line);
//				i++;
				//append to array list
			}
			rd.close();
		}catch(IOException ex){
			throw new ErrorException(ex);}

	}
	
	private BufferedReader readFiles(String prompt)
	{
		BufferedReader rd = null;
		while(rd == null)
		{
			try
			{
//				String name = readLine(prompt);
				rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			}
			catch(IOException ex){}
				//println("Bad File");}
		}
		return rd;
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordlist.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordlist.get(index);
	}
}
