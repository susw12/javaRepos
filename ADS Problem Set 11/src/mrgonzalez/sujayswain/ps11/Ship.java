package mrgonzalez.sujayswain.ps11;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Programs ship functions
 *
 * This program contains code for ship movement and other functions.
 * <p>
 * ADS PS11: Asteroids
 * 9/19/2018
 *
 * @author Sujay Swain
 */
public class Ship extends Polygon implements KeyListener{
    static boolean forward = false, left = false, right = false;
    private Object width, height;
    public Ship(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }

    /**
     * Draw ths ship
     *
     * @author Sujay Swain
     * @param brush
     */
    public void paint(Graphics brush) {
        Point[] p = this.getPoints();
        int[] px = new int[p.length];
        int[] py = new int[p.length];

        for(int i=0; i<p.length; i++) {
            px[i] = (int) p[i].getX();
            py[i] = (int) p[i].getY();
        }
        move();
        brush.drawPolygon(px, py, p.length);
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
            case KeyEvent.VK_UP:
                forward = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
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
            case KeyEvent.VK_UP:
                forward = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {

    }
    /**
     * Makes the asteroid move around the board
     * Takes user input
     * @author Sujay Swain
     */
    public void move() {
//moving forward
        int stepSize = 3;
        if(forward) {
            this.position.x = this.position.getX() + stepSize * Math.cos(Math.toRadians(rotation));
            this.position.y = this.position.getY() + stepSize * Math.sin(Math.toRadians(rotation));
        }

//wrapping around edges
        if(this.position.x >= 800) this.position.x = 10;
        if(this.position.y >= 600) this.position.y = 0;
        if(this.position.x <= 0) this.position.x = 800;
        if(this.position.y <= 0) this.position.y = 600;

//rotate
        if(right) this.rotation += 2;
        if(left) this.rotation -= 2;
    }
}