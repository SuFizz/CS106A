import acm.program.*;

public class NameSurferEntryTester extends ConsoleProgram implements NameSurferConstants {
	public void run()
	{
		NameSurferDataBase e = new NameSurferDataBase(NAMES_DATA_FILE);
		
		println(e.findEntry("mike"));
//		NameSurferEntry entry = new NameSurferEntry("A 83 140 228 286 426 612 486 577 836 0 0");
//		println(entry.toString());
	}
	
}
