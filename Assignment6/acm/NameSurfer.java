/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the top of the window.
 */
	public void init() {
		graph = new NameSurferGraph();
		add(graph);

		add(new JLabel("Name : "), NORTH);

		nameField = new JTextField(10);
		add(nameField,NORTH);

//		Graph = new JButton("Graph");
//		Clear = new JButton("Clear");

		add(new JButton("Graph"), NORTH);
		add(new JButton("Clear"), NORTH);
		
		addActionListeners();
		nameField.addActionListener(this);
//		println(NAMES_DATA_FILE);
//		NameData = new NameSurferDataBase(NAMES_DATA_FILE);

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
		
		if(e.getSource() == nameField)
			if(! nameField.getText().equals(""))
				{//println("Graph :"+nameField.getText());
				String namef = nameField.getText();
				NameSurferEntry entry = NameData.findEntry(namef.toUpperCase());
				//println(entry);
				if(entry != null)
					graph.addEntry(entry);
				}
		
		if(but_pressed.equals("Graph"))
			if(! nameField.getText().equals(""))
				{//println("Graph :"+nameField.getText());
				String namef = nameField.getText();
				NameSurferEntry entry = NameData.findEntry(namef.toUpperCase());
				//println(entry);
				if(entry != null)
					graph.addEntry(entry);
				}
		
		if(but_pressed.equals("Clear")){graph.clear();}
			//println("Clear");
		// You fill this in //
	}

	private JTextField nameField;
//	public NameSurferDatabase NameData;
	private NameSurferDataBase NameData = new NameSurferDataBase(NAMES_DATA_FILE);
	private NameSurferGraph graph;

//	private JButton Graph;
//	private JButton Clear;
}
