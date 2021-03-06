
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {

	private ArrayList <NameSurferEntry> database = new ArrayList<NameSurferEntry>();// = new NameSurferEntry[MAX_RANK];
	
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
 
	private BufferedReader readFile(String filename)
	{
		BufferedReader rd = null;
		while(rd == null)
		{
			try
			{
				rd = new BufferedReader(new FileReader(filename));
			}
		catch(IOException ex){throw new ErrorException(ex);}
		}
		return rd;
	}
	
	private void readData(BufferedReader rd)
	{
		try
		{
			String line = new String();
			for(int i =0; ; ++i)
			{
				line = rd.readLine();
//				println("line");
				if(line==null)	break;
				NameSurferEntry pu = new NameSurferEntry(line);
				database.add(pu);
//				i++;
				//append to array list
			}
			rd.close();
		}catch(IOException ex){
			throw new ErrorException(ex);}
	}

	public NameSurferDataBase(String filename) {
		BufferedReader rd = readFile(filename);
		readData(rd);

//		int i =0;
//		database = new NameSurferEntry[MAX_RANK];

	}
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		NameSurferEntry you = null;
		for(int i =0; i<database.size(); ++i)
		{	String wear = database.get(i).getName().toUpperCase();
			name  = name.toUpperCase();
			if(wear.equals(name))
				{you = database.get(i);	break;}
		}
		return you;
	}
	
//	private BufferedReader rd;
	
}
