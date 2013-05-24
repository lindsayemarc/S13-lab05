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
   A VendingMachine with a window
      
   @author Marc Lindsay
   @version for CS56, S13, UCSB, 05/23/2013
   
*/
public class VendingMachineWithWindow extends VendingMachine implements Shape
{
    /**
     * Constructor for objects of class Door
     */
    public VendingMachineWithWindow(double x, double y, double width, double height)
    {
	// construct the basic machine shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make one large window
	double window_x = x + 5;
	double window_y = y + 5;
	double window_height =  height - 10 - (.1*height + 2);
	double window_width = width - 10;

	Rectangle2D.Double window =
	    new Rectangle2D.Double(window_x, window_y, window_width, window_height);

	// add the window to the machine
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeMachine = this.get();
        wholeMachine.append(window, false);

    }

}
