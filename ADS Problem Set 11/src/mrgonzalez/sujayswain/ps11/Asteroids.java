package mrgonzalez.sujayswain.ps11;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import mrgonzalez.sujayswain.ps11.*;

import java.awt.event.KeyListener;
import java.util.*;

class Asteroids extends Game {
    static int counter = 0;
    Point[] shipPoints = {new Point(0,0), new Point(0,10), new Point(5,10), new Point(5,0)};
    Ship main = new Ship(shipPoints, new Point(400,300), -90);

    public Asteroids() {
        super("Asteroids!",800,600);
        this.setFocusable(true);
	    this.requestFocus();
	    this.addKeyListener(main);
    }
  
      public void paint(Graphics brush) {
            brush.setColor(Color.black);
            brush.fillRect(0,0,width,height);

            // sample code for printing message for debugging
            // counter is incremented and this message printed
            // each time the canvas is repainted
            counter++;
            brush.setColor(Color.white);
            brush.drawString("Counter is " + counter,10,10);

            brush.setColor(Color.green);
            main.paint(brush);
      }

      public static void main (String[] args) {
            Asteroids a = new Asteroids();
            a.repaint();
      }
}