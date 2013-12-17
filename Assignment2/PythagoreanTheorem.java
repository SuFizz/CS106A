/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;
import java.math.*

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println("Enter values to compute the Pythagorean theorem.");
		double a = getDouble("a: ");
		double b = getDouble("b: ");
		
		double c = Math.sqrt(a*a + b*b);
		println("c = "+c);

	}
}
