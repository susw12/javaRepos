package mrgonzalez.sujayswain.ps11;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Basic abstract game object
 *
 * Game object that interacts with the screen.
 *
 * <p>
 * ADS: Problem Set 11
 *
 * @author Daniel Monroe
 *
 *
 */
public abstract class GameObject {
    protected Polygon hitBox, mesh;
    protected double direction = 0;
    protected double x = 0, y = 0, xv = 0, yv = 0;
    protected double maxR = 0;

    /**
     * Draws mesh
     *
     * Draws mesh onto the graphics
     *
     * <p>
     * @param g graphics to draw on
     */
    public void render(Graphics g) {
        g.setColor(Color.white);
        mesh.rotation = direction;
        mesh.position = new Point(x, y);
        hitBox.rotation = direction;
        hitBox.position = new Point(x, y);
        Point[] points = mesh.getPoints();

        for (int i = 0; i < points.length; i++) {
            Point start = points[i];
            Point finish = points[(i+1) % points.length];
            g.drawLine((int) start.getX(), (int) start.getY(), (int) finish.getX(), (int) finish.getY());
        }

    }

    /**
     * Determines whether these intersect.
     *
     * Determines whether intersects with object
     *
     * <p>
     *
     * @param object GameObject to find if intersects with
     * @return whether we intersect
     *
     */
    public boolean intersects(GameObject object) {
        return (hitBox.intersects(object.getPoly()));
    }

    /**
     * Returns hitBox
     *
     * Returns hitBox
     *
     * <p>
     *
     * @return my hitBox
     */
    public Polygon getPoly() {
        return hitBox;
    }

    /**
     * Ticks
     *
     * Moves by xv and yv
     *
     * <p>
     *
     */
    public void tick() {
        x += xv / 60;
        y += yv / 60;
    }

    public void setMaxR() {
        Point p, pos = mesh.position;
        Point[] points = mesh.getPoints();
        for (int i = 0; i < points.length; i++) {
            p = points[i];
            maxR = Math.max(p.getDistance(pos), maxR);
        }
    }

    /**
     * Checks if forever offscreen.
     *
     * Returns true if the asteroid will always be off screen. <p>
     *
     * @param screenWidth width of screen
     * @param screenHeight height of screen
     * @return whether offscreen forever
     */
    public boolean checkToDelete(double screenWidth, double screenHeight) {
        if (this.x > screenWidth + maxR && this.xv > 0 || this.x  < -maxR && this.xv < 0) {
            return true;
        }