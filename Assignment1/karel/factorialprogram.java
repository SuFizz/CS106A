import acm.program.*;
public class factorialprogram extends ConsoleProgram{

	private int n1;
	public static final int GEN = 100;
	public void run()
	{
		n1 = readInt("Enter Number for factorial : ");
		println("Factorial is " + fact(n1));
	}
	
	private int fact(int n1)
	{
		if(n1 == 1)
			return 1;
		else if (n1 == 0)
			return 1;
		else
			return n1*fact(n1-1);
		
	}
	

}
