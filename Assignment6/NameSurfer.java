/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the top of the window.
 */
	public void init() {
		add(new JLabel("Name : "), NORTH);

		add(nameField,NORTH);
		nameField.addActionListener(this);
		
		Graph = new JButton("Graph");
		Clear = new JButton("Clear");
		
		add(Graph, NORTH);
		add(Clear,NORTH);
		
		addActionListeners();
	    // You fill this in, along with any helper methods //
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		String but_pressed = e.getActionCommand();
		
		if(e.getSource == nameField)
			println("Graph :"+nameField.getText());
		
		if(but_pressed.equals("Graph"))
			println("Graph :"+nameField.getText());
		
		if(but_pressed.equals("Clear"))
			println("Clear");
		// You fill this in //
	}
}
