package mrgonzalez.sujayswain.ps11;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/

import java.awt.*;

import mrgonzalez.sujayswain.ps11.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 *
 * Main Asteroid Controller
 * <p> This creates and draws the asteroids on the board and allows the game creator to control the settings of the game</p>
 *
 * <p>
 *  ADS PS11: Asteroids
 *  9/20/2018
 *  </p>
 *
 * @extends Polygon
 * @author Sujay Swain
 */

class Asteroids extends Game {
    static int counter = 0;
    Point[] shipPoints = {new Point(0, 0), new Point(0, 10), new Point(5, 10), new Point(5, 0)};
    Point[] asteroidPoints = {new Point(0, 0), new Point(0, 20), new Point(10, 20), new Point(10, 0)};
    Point[] bulletPoints = {new Point(0, 0), new Point(0, 1), new Point(5, 1), new Point(5, 0)};
    Ship main = new Ship(shipPoints, new Point(400, 300), -90);
    Asteroid[] killers = {new Asteroid(asteroidPoints, new Point(0,0), -90), new Asteroid(asteroidPoints, new Point(0,100), -90)};
    boolean createBullet = false;

    /**
     * Creates Asteroids Class
     *
     * @author Sujay Swain
     */
    public Asteroids() {
        super("Asteroids!", 800, 600);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(main);
    }

    public void paint(Graphics brush) {
        brush.setColor(Color.black);
        brush.fillRect(0, 0, width, height);

        // sample code for printing message for debugging
        // counter is incremented and this message printed
        // each time the canvas is repainted
        counter++;
        brush.setColor(Color.white);
        brush.drawString("Counter is " + counter, 10, 10);

        brush.setColor(Color.green);
        main.paint(brush);

        brush.setColor(Color.magenta);
        for (int x = 0; x < killers.length; x++) {
            killers[x].paint(brush);
        }

        if (createBullet) {
            Bullets fired = new Bullets(bulletPoints, main.position, main.rotation);
            brush.setColor(Color.red);
            fired.paint(brush);

        }
    }

    /**
     * Checks to see what key is pressed
     *
     * @author Sujay Swain
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_SPACE:
                createBullet = true;
                break;
        }
    }

    /**
     * Checks to see what key is released
     *
     * @author Sujay Swain
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_SPACE:
                createBullet = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {

    }



    public static void main(String[] args) {
        Asteroids a = new Asteroids();
        a.repaint();
    }
}