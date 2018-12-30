package mrgonzalez.sujayswain.ps11;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
/**
 * <p> </p>This class contains the creation method for making bullets </p>
 *
 * <p>
 *  ADS PS11: Asteroids
 *  9/20/2018
 *  </p>
 *
 * @extends Polygon
 * @author Sujay Swain
 */
public class Bullets extends Polygon{

    private int counter = 0;
    public Bullets(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }

    /**
     * Make the bullet appear on the screen
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
        brush.fillPolygon(px, py, p.length);
    }

    /**
     * Makes the asteroid move around the board
     *
     * @author Sujay Swain
     */
    public void move() {
        counter += 1;
        if (counter <= 100) {
            int stepSize = 1;
            this.position.setX(this.position.getX() + stepSize * Math.cos(Math.toRadians(rotation)));
            this.position.setY(this.position.getY() + stepSize * Math.sin(Math.toRadians(rotation)));

            //wrapping around edges
            if (this.position.x >= 800) this.position.x = 10;
            if (this.position.y >= 600) this.position.y = 0;
            if (this.position.x <= 0) this.position.x = 800;
            if (this.position.y <= 0) this.position.y = 600;
        }
        else {
            this.position.x = 1000;
            this.position.y = 1000;
        }

    }



}
