//CS350 Project1 Chris Lample
//Creates a Truchet Tiling by giving tiles random orientations.
//Has 3 styles of tilings, and reads the parameters
//for tile type(1, 2, or 3) and tile size (in pixels)
//from a file named truchet.txt
import java.awt.*;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;
import java.util.Random;

public class Tiles extends JPanel
{
	private int style; //the users choice of tile style
	private int size; //the users choice of tile size
	private int orientation; //the orientation of a tile. Has value of 0 or 1
	Random random = new Random();
	
	// constructor sets the user's style and size choice
	public Tiles( int userStyleChoice, int userSizeChoice )
	{
		style = userStyleChoice;
		size = userSizeChoice;
	} // end Shapes constructor
	
	public void createTile( Graphics g, int x, int y )
	{
		//Get random number to determine tile orientation
		orientation = random.nextInt(2);
		
		// Draw the tile based on the style variable
		switch (style) {
			case 1: if (orientation==0) {
						g.drawArc(x-(size/2),y-(size/2),size, size,0,90);
						g.drawArc(x+(size/2),y-(3*size/2),size,size,180,90);
					} else if (orientation==1) {
						g.drawArc(x-(size/2),y-(3*size/2),size,size,270,90);
						g.drawArc(x+(size/2),y-(size/2),size,size,90,90);
					}
					break;
			case 2: if (orientation==0) {
						g.drawLine(x, y, x+(size/3), y+(size/2));
						g.drawLine(x,y+size, x+(size/3),y+(size/2));
						g.drawLine(x+(size/3),y+(size/2), x+(2*size/3), y+(size/2));
						g.drawLine(x+(2*size/3), y+(size/2),x+size,y+size);
						g.drawLine(x+(2*size/3), y+(size/2), x+size, y);
					} else if (orientation==1) {
						g.drawLine(x,y,x+(size/2),y+(size/3));
						g.drawLine(x,y+size,x+(size/2),y+(2*size/3));
						g.drawLine(x+(size/2),y+(size/3),x+(size/2),y+(2*size/3));
						g.drawLine(x+(size/2),y+(size/3),x+size,y);
						g.drawLine(x+(size/2),y+(2*size/3),x+size,y+size);
					}
					break;
			case 3: if (orientation==0) {
						g.drawLine(x,y,x+size,y+size);
					} else if (orientation==1) {
						g.drawLine(x, y+size, x+size, y);
					}
					break;
		
		}
	}
	public void paintComponent( Graphics g)
	{
		super.paintComponent( g );	      
		g.setColor(Color.red);
		int frameWidth = getWidth();
		int frameHeight = getHeight();
		
		//loop over the panel 
		for(int x=0; x < frameWidth; x = x + size)
		{
			for(int y=0; y < frameHeight; y = y + size)
			{
				createTile( g, x, y);
			}
		}
	}
}
