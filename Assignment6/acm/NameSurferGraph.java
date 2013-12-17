/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	private static final int SPACE = 20;
	private static final int nLines = NDECADES;
	private static int iterat = 0;
	
	private static final Color Color0 = Color.BLACK;
	private static final Color Color1 = Color.RED;
	private static final Color Color2 = Color.BLUE;
	private static final Color Color3 = Color.MAGENTA;
	
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		update();
		addComponentListener(this);
	}
	
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		removeAll();
		displayers = new ArrayList<NameSurferEntry>();
		update();
	}
	
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/	
	public void addEntry(NameSurferEntry entry) {
		displayers.add(entry);
		update();
/*		String name_e = entry.getName();
		double prevX = 0;
		double prevY = 0;
		for(int i=1; i<=nLines;++i)
		{	GLine line = new GLine(i*distBetweenLines, 0, distBetweenLines*i, getHeight());
			add(line);
			GLabel decade = new GLabel(name_e);
			add(decade,distBetweenLines*i,entry.getRank(i-1));
		}
*/
	}
	

	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		// You fill this in //
		removeAll();
		double distBetweenLines = getWidth()/NDECADES;
		
		for(int i=1; i<nLines;++i)
		{	GLine line = new GLine(i*distBetweenLines, 0, distBetweenLines*i, getHeight());
			add(line);
			if(i != nLines)
				{GLabel decade = new GLabel("19"+(i-1)+"0");
				add(decade,distBetweenLines*(i-1),getHeight());}
		}
		
		GLabel decade = new GLabel("2000");
		add(decade,distBetweenLines*(nLines-1),getHeight());
		
		GLine linU = new GLine(0, SPACE,getWidth(),SPACE);
		add(linU);

		GLine linD = new GLine(0,getHeight() - SPACE, getWidth(),getHeight() - SPACE);
		add(linD);

		for(int j=0; j< displayers.size(); ++j)
		{
			NameSurferEntry toDraw = null;
			toDraw = displayers.get(j);

			double spacing = (getHeight() - 2*SPACE);

			double startY = spacing * (toDraw.getRank(0)-1)/MAX_RANK + SPACE;
			double startX = 0;
			
			GLabel namer = new GLabel("");
			if(toDraw.getRank(0) == 0)
				{namer.setLabel(toDraw.getName() + "*");
				startY = getHeight() - SPACE;}
			else
				namer.setLabel(toDraw.getName() + toDraw.getRank(0));

			add(namer,startX,startY);
//			remove(namer);

			for(int i=1; i< nLines; ++i)
				{

				int rank = toDraw.getRank(i);
//				println(""+rank);
				
				double endY = (rank-1)*spacing/MAX_RANK + SPACE;
				double endX = distBetweenLines*i;
				GLabel namers = new GLabel("");

				if(rank == 0)
					{
					endY = getHeight() - SPACE;
					namers.setLabel(toDraw.getName()+" *");
//					add(namer,distBetweenLines*(i),getHeight()-SPACE);
					}
				else
					namers.setLabel(toDraw.getName()+" "+rank);


				GLine liner = new GLine(startX,startY,endX,endY);
//				liner.setFilled(true);
//				namers.setFilled(true);
				
				Color sel = Color.GREEN;
				
				switch((iterat)%4)
					{
						case 0 : {sel = Color0;break;}
						case 1 : {sel = Color1;break;}
						case 2 : {sel = Color2;break;}
						case 3 : {sel = Color3;break;}
					}
				liner.setColor(sel);
				namers.setColor(sel);

				add(namers,endX,endY);
				add(liner);

				startX = endX;
				startY = endY;
				}
				iterat++;
		}
	}

	private ArrayList <NameSurferEntry> displayers = new ArrayList<NameSurferEntry>();
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
