/*
 * File: sudokuConstants.java
 * --------------------------------
 * This file declares several constants that are shared by the
 * different modules in the sudoku application.  Any class
 * that implements this interface can use these constants.
 */

import java.math.*;

public interface sudokuConstants{

	/** The width of the application window */
	public static final int APPLICATION_WIDTH = 800;

	/** The height of the application window */
	public static final int APPLICATION_HEIGHT = 500;
	
	/**	The number of cells	*/
	public static final int BOARD_SIZE = 9;
	
	/**	The number of cells in the BOX*/
	public static final int BOX_SIZE = 3;
}
