
package mrgonzalez.sujayswain.ps11;
import java.io.*;
import java.util.*;

import java.awt.*;
/**
 * <p> </p>This class contains the creation method for making asteroids </p>
 *
 * <p>
 *  ADS PS11: Asteroids
 *  9/20/2018
 *  </p>
 *
 * @extends Polygon
 * @author Sujay Swain
 */
public class Asteroid extends Polygon {
    /**
     * Initializes the asteroid
     *
     * @author Sujay Swain
     * @param inShape
     * @param inPosition
     * @param inRotation
     */
    public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }

    /**
     * Make the asteroid appear on the screen
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
        Random rotation = new Random();
        int rotationInt = rotation.nextInt()*180;
        int stepSize = 5;
        this.position.setX(this.position.getX() + stepSize * Math.cos(Math.toRadians(rotationInt)));
        this.position.setY(this.position.getY() + stepSize * Math.sin(Math.toRadians(rotationInt)));

//wrapping around edges
        if(this.position.x >= 800) this.position.x = 10;
        if(this.position.y >= 600) this.position.y = 0;
        if(this.position.x <= 0) this.position.x = 800;
        if(this.position.y <= 0) this.position.y = 600;

    }
}