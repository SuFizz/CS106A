/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		display = new FacePamphletCanvas();
		add(display);
		
		database = new FacePamphletDatabase();

		add(new JLabel("Name : "), NORTH);

		nameField = new JTextField(TEXT_FIELD_SIZE);
		add(nameField,NORTH);

		add(new JButton("Add"), NORTH);
		add(new JButton("Delete"), NORTH);
		add(new JButton("Lookup"), NORTH);
		
		status = new JTextField(TEXT_FIELD_SIZE);
		add(status,WEST);		
		add(new JButton("Change Status"), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT),WEST);
		

		pic = new JTextField(TEXT_FIELD_SIZE);
		add(pic,WEST);
		add(new JButton("Change Picture"), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT),WEST);

		friend = new JTextField(TEXT_FIELD_SIZE);
		add(friend,WEST);
		add(new JButton("Add Friend"), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT),WEST);

		addActionListeners();
		nameField.addActionListener(this);
		status.addActionListener(this);
		pic.addActionListener(this);
		friend.addActionListener(this);
    }

    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		String but_pressed = e.getActionCommand();
		String nameF = nameField.getText();
		String stat = status.getText();
		String pict = pic.getText();
		String frend = friend.getText();

		if(e.getSource() == nameField || but_pressed.equals("Add"))
			{if(! nameF.equals(""))
				{//println("Add : "+nameF);
				FacePamphletProfile prof = database.getProfile(nameF);
				if(prof == null)
					{FacePamphletProfile twee = new FacePamphletProfile(nameF);
					database.addProfile(twee);
					display.displayProfile(twee);
					//println("Add : new profile: "+twee.toString());
					}
				else
					display.showMessage("ADD : Profile Already exists");
					//println("Profile Already exists"+prof.toString());
				}
			}

		else if(e.getSource() == status || but_pressed.equals("Change Status"))
			{if(! stat.equals(""))
//				println("Change Status : "+stat);
				{
				FacePamphletProfile prof = database.getProfile(nameF);
				if(prof == null)
					display.showMessage("Status : No profile with this name exists");
				else
					{prof.setStatus(stat);	display.displayProfile(prof);}//println(nameF+" set with status "+stat);}
				}
			}

		else if(e.getSource() == pic || but_pressed.equals("Change Picture"))
			{if(! pict.equals(""))
				{
				GImage image = null;
				try {
				image = new GImage("./images/"+pict);
				} catch (ErrorException ex) {
				display.showMessage("Sorry no such file exists; Please try again.");
				// Code that is executed if the filename cannot be opened.
				}

				FacePamphletProfile prof = database.getProfile(nameF);
				if(prof == null)
					display.showMessage("Picture : No profile with this name exists");
				else if(image != null)
					{prof.setImage(image); display.displayProfile(prof); display.showMessage(nameF+" set with image "+pict);}
				}
			}

		else if(e.getSource() == friend || but_pressed.equals("Add Friend"))
			{if(! frend.equals(""))
				{
				FacePamphletProfile prof = database.getProfile(nameF);
				FacePamphletProfile prof_fren = database.getProfile(frend);

				if(prof == null || prof_fren == null)
					display.showMessage("Friend : No profile with this name exists");
				else if(prof == prof_fren)
					display.showMessage("Friend : Same person.");
				else
					{prof.addFriend(frend);	prof_fren.addFriend(nameF);	display.displayProfile(prof); display.showMessage("FRIEND : "+prof.toString());}
				}

			}

		
//		else if(but_pressed.equals("Add"))
//			{if(! nameF.equals(""))
//				println("Add : "+nameF);}

		else if(but_pressed.equals("Delete"))
			{if(! nameF.equals(""))
				{//println("Add : "+nameF);
				FacePamphletProfile prof = database.getProfile(nameF);
				if(prof == null)
					display.showMessage("Delete : No such profile exists");
				else
					{database.deleteProfile(nameF);	display.showMessage("Delete: profile of "+nameF+" deleted.");}
				}
			}

		else if(but_pressed.equals("Lookup"))
			{if(! nameF.equals(""))
				{//println("Add : "+nameF);
				FacePamphletProfile prof = database.getProfile(nameF);
				if(prof == null)
					display.showMessage("Lookup : No such profile exists");
				else
					{display.displayProfile(prof);	display.showMessage("Lookup : "+prof.toString());}
				}
			}

//		else if(but_pressed.equals("Change Status"))
//			{if(! stat.equals(""))
//				println("Change Status : "+stat);}

//		else if(but_pressed.equals("Change Picture"))
//			{if(! pict.equals(""))
//				println("Change Picture : "+pict);}

//		else if(but_pressed.equals("Add Friend"))
//			{if(! frend.equals(""))
//				println("Add Friend : "+frend);}
	}

	private JTextField nameField;
	private JTextField status;
	private JTextField pic;
	private JTextField friend;	
	private FacePamphletDatabase database;
	private FacePamphletCanvas display;
//	private FacePamphletProfile temp;

}
