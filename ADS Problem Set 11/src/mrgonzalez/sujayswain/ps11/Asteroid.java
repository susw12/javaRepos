
package mrgonzalez.sujayswain.ps11;
import java.io.*;
import java.util.*;

import mrgonzalez.sujayswain.ps11.Point;

import java.awt.*;

public class Asteroid extends Polygon {
    public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }

    public void paint(Graphics brush) {
        Point[] p = this.getPoints();
        int[] px = new int[p.length];
        int[] py = new int[p.length];

        for(int i=0; i<p.length; i++) {
            px[i] = (int) p[i].getX();
            py[i] = (int) p[i].getY();
        }
        brush.fillPolygon(px, py, p.length);
    }

    public void move() {
        int stepSize = 1;
        this.position.setX(this.position.getX() + stepSize * Math.cos(Math.toRadians(rotation)));
        this.position.setY(this.position.getY() + stepSize * Math.sin(Math.toRadians(rotation)));

//wrapping around edges
        if(this.position.x >= 800) this.position.x = 0;
        if(this.position.y >= 600) this.position.y = 0;

    }
}