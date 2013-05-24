package edu.ucsb.cs56.S13.drawings.mlindsay.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;
/**
   A Door with a window
      
   @author Marc Lindsay
   @version for CS56, S13, UCSB, 05/23/2013
   
*/
public class DoorWithWindows extends Door implements Shape
{
    /**
     * Constructor for objects of class Door
     */
    public DoorWithWindows(double x, double y, double width, double height)
    {
	// construct the basic door shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make one large window
	double window_x = x + (0.25 * width);
	double window_y = y + (0.2 * height);
	double window_height =  0.25 * height;
	double window_width = (.2 * width);

	Rectangle2D.Double window =
	    new Rectangle2D.Double(window_x, window_y, window_width, window_height);

	// add the window to the door
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeDoor = this.get();
        wholeDoor.append(window, false);

    }

}
