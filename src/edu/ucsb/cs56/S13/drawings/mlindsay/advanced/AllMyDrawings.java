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
 * @author Marc Lindsay, changed to draw VendingMachines and VendingMachines with a window
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with vending machines
     */

    public static void drawPicture1(Graphics2D g2) {
	VendingMachine m1 = new VendingMachine(300,100,50,150);
	g2.setColor(Color.CYAN); g2.draw(m1);

	// Make an avacado house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape m2 = ShapeTransforms.scaledCopyOfLL(m1,0.5,0.5);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	g2.setColor(new Color(0x568203)); g2.draw(m2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	m2 = ShapeTransforms.scaledCopyOfLL(m2,4,4);
	m2 = ShapeTransforms.translatedCopyOf(m2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(m2); 
	
	// Draw two vending machines with windows
	
	VendingMachineWithWindow mw1 = new VendingMachineWithWindow(50,300,40,75);
	VendingMachineWithWindow mw2 = new VendingMachineWithWindow(200,250,200,50);
	
	g2.draw(mw1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(mw2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few vending machines by Marc Lindsay", 20,20);
    }


    /** Draw a picture with a few vending machines
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some vending machines
	
	VendingMachine large_machine = new VendingMachine(20,100,200,100);
	VendingMachine small_machine = new VendingMachine(30,50,10,20);
	VendingMachine tall_machine = new VendingMachine(150,150,15,100);
	VendingMachine short_machine = new VendingMachine(50,250,100,10);
	VendingMachine rectangle_machine = new VendingMachine(300,250,100,100);

	g2.setColor(Color.yellow); g2.draw(large_machine);
	g2.setColor(Color.pink);   g2.draw(small_machine);
	g2.setColor(Color.orange);  g2.draw(tall_machine);
	g2.setColor(Color.green); g2.draw(short_machine);
	g2.setColor(Color.darkGray); g2.draw(rectangle_machine);
	
	// Make another pink vending machine that's 30% the size, 
	// and moved over 200 pixels in x direction
	Shape machine_translated = ShapeTransforms.scaledCopyOfLL(large_machine,0.3,0.3);
	machine_translated = ShapeTransforms.translatedCopyOf(machine_translated,200,0);
	g2.setColor(Color.pink); g2.draw(machine_translated);
	
	// Here's a vending machine that's 5x as big
	// and moved 100 more pixels to down.
        machine_translated = ShapeTransforms.scaledCopyOfLL(machine_translated,5,5);
	machine_translated = ShapeTransforms.translatedCopyOf(machine_translated,0,100);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #00FF7F" Guppie Green according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x00FF7F)); 
	g2.draw(machine_translated); 
	
	// Draw two vending machine with windows
	
	VendingMachineWithWindow mw1 = new VendingMachineWithWindow(50,350,40,80);
	VendingMachineWithWindow mw2 = new VendingMachineWithWindow(150,250,200,100);	
	
	g2.draw(mw1);
	g2.setColor(new Color(0xE9D66B)); 
	g2.draw(mw2); g2.setColor(new Color(0x967BB6));
	// Rotate the second vending machine 180 degrees around its center.
	Shape mw3 = ShapeTransforms.rotatedCopyOf(mw2, Math.PI);
	mw3 = ShapeTransforms.translatedCopyOf(mw3,0,200);
	g2.draw(mw3); g2.setColor(new Color(0xEE82EE));

	// Rotate the third vending machine 135 degrees around its center.
	Shape mw4 = ShapeTransforms.rotatedCopyOf(mw2, (3.0*Math.PI)/4.0);
	mw4 = ShapeTransforms.translatedCopyOf(mw4,125,100);
	g2.draw(mw4);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of vending machines and a few vending machines with windows by Marc Lindsay", 20,20);
    }
  
    /** Draw a different picture with vending machines with windows
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// A few of vending machines with windows, and their mirror images
	
	g2.drawString("A bunch of vending machines with windows by Marc Lindsay", 20,20);
	
	// Draw some vending machines with windows.
	
       VendingMachineWithWindow door1 = new VendingMachineWithWindow(50,50,75,150);
       VendingMachineWithWindow door2 = new VendingMachineWithWindow(130,50,75,150);
       VendingMachineWithWindow door3 = new VendingMachineWithWindow(210,50,75,150);
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
