package edu.ucsb.cs56.S13.drawings.mlindsay.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad 
 * @author Marc Lindsay, changed to draw Doors and DoorsWithWindows
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a doors
     */

    public static void drawPicture1(Graphics2D g2) {
	Door d1 = new Door(300,100,50,150);
	g2.setColor(Color.CYAN); g2.draw(d1);

	// Make an avacado house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.5,0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	g2.setColor(new Color(0x568203)); g2.draw(d2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	d2 = ShapeTransforms.scaledCopyOfLL(d2,4,4);
	d2 = ShapeTransforms.translatedCopyOf(d2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(d2); 
	
	// Draw two doors with Windows
	
	DoorWithWindows dw1 = new DoorWithWindows(50,350,40,75);
	DoorWithWindows dw2 = new DoorWithWindows(200,350,200,100);
	
	g2.draw(dw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(dw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few doors by Marc Lindsay", 20,20);
    }


    /** Draw a picture with a few doors
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some doors
	
	Door large_door = new Door(20,100,200,100);
	Door small_door = new Door(30,50,10,20);
	Door tall_door = new Door(150,150,15,100);
	Door short_door = new Door(50,250,100,10);
	Door rectangle_door = new Door(300,300,100,100);

	g2.setColor(Color.yellow); g2.draw(large_door);
	g2.setColor(Color.pink);   g2.draw(small_door);
	g2.setColor(Color.orange);  g2.draw(tall_door);
	g2.setColor(Color.green); g2.draw(short_door);
	g2.setColor(Color.darkGray); g2.draw(rectangle_door);
	
	// Make another pink door that's 30% the size, 
	// and moved over 200 pixels in x direction
	Shape door_translated = ShapeTransforms.scaledCopyOfLL(large_door,0.3,0.3);
	door_translated = ShapeTransforms.translatedCopyOf(door_translated,200,0);
	g2.setColor(Color.pink); g2.draw(door_translated);
	
	// Here's a house that's 5x as big
	// and moved 100 more pixels to down.
        door_translated = ShapeTransforms.scaledCopyOfLL(door_translated,5,5);
	door_translated = ShapeTransforms.translatedCopyOf(door_translated,0,100);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #00FF7F" Guppie Green according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x00FF7F)); 
	g2.draw(door_translated); 
	
	// Draw two houses with Windows
	
	DoorWithWindows dw1 = new DoorWithWindows(50,400,40,80);
	DoorWithWindows dw2 = new DoorWithWindows(150,250,200,100);
	
	g2.draw(dw1);
	g2.setColor(new Color(0xE9D66B)); 

	// Rotate the second house 135 degrees around its center.
	Shape dw3 = ShapeTransforms.rotatedCopyOf(dw2, 3.0*Math.PI);
	
	g2.draw(dw3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of doors and a few doors with windows by Marc Lindsay", 20,20);
    }
  
    /** Draw a different picture with doors with windows
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// A few of doors with windows, and their mirror images
	
	g2.drawString("A bunch of doors with windows by Marc Lindsay", 20,20);
	
	// Draw some doors with windows.
	
       DoorWithWindows door1 = new DoorWithWindows(50,50,75,150);
       DoorWithWindows door2 = new DoorWithWindows(130,50,75,150);
       DoorWithWindows door3 = new DoorWithWindows(210,50,75,150);
       g2.setColor(new Color(0xADFF2F));   g2.draw(door1);
       g2.setColor(new Color(0x5218FA));  g2.draw(door2);
       g2.setColor(new Color(0x3FFF00)); g2.draw(door3);
	
       Shape t_door1 = ShapeTransforms.rotatedCopyOf(door1, 2.0*Math.PI);	   
       t_door1 = ShapeTransforms.translatedCopyOf(t_door1,0,155);

       Shape t_door2 = ShapeTransforms.rotatedCopyOf(door2, 2.0*Math.PI);	   
       t_door2 = ShapeTransforms.translatedCopyOf(t_door2,0,155);

       Shape t_door3 = ShapeTransforms.rotatedCopyOf(door3, 2.0*Math.PI);	   
       t_door3 = ShapeTransforms.translatedCopyOf(t_door3,0,155);

       g2.setColor(new Color(0x3FFF00));   g2.draw(t_door1);
       g2.setColor(new Color(0xADFF2F));  g2.draw(t_door2);
       g2.setColor(new Color(0x5218FA)); g2.draw(t_door3);
       
    }
    

}
