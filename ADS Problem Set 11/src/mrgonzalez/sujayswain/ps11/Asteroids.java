package mrgonzalez.sujayswain.ps11;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;

class Asteroids extends Game {
	static int counter = 0;

  public Asteroids() {
    super("Asteroids!",900,600);
    this.setFocusable(true);
	this.requestFocus();
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
  }
  
	public static void main (String[] args) {
   		Asteroids a = new Asteroids();
		a.repaint();
  }
}