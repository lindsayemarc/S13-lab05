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
   A vector drawing of a vending machine that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Marc Lindsay 
   @version for CS56, Winter 11, UCSB
   
*/
public class VendingMachine extends GeneralPathWrapper implements Shape
{
     /**
       Constructor for object of basic VendingMachine

       @param x x coord of lower left corner of machine
       @param y y coord of lower left corner of machine
       @param width width of machine
       @param height height of machine
     */

    public VendingMachine(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
	double dispenser_x = x + 5;
	double dispenser_y = y + height - (0.1*height + 2);
	double dispenser_w = width-10;
	double dispenser_h = 0.1*height;

   // create a rectangle for the dispenser
   Rectangle2D.Double dispenser =
       new Rectangle2D.Double(dispenser_x,dispenser_y,dispenser_w,dispenser_h);

   // create the actual vending machine frame
   Rectangle2D.Double machine = 
       new Rectangle2D.Double(x,y,width,height);		
   
   //put the whole vending machine together     
   GeneralPath wholeMachine = this.get();
   wholeMachine.append(machine, false);
   wholeMachine.append(dispenser, false);
    }   
}
