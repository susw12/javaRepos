package mrgonzalez.sujayswain.ps11;

import java.awt.*;
import java.awt.event.*;

public class Ship extends Polygon implements KeyListener {
    private int[] xCords = new int[4];
    private int[] yCords = new int[4];
    private String moveCommand = "";

    public Ship(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }

    public void paint(Graphics brush) {
        Point[] main = this.getPoints();
        for (int num = 0; num < (super.getPoints().length); num++) {
            xCords[num] = (int) main[num].getX();
            yCords[num] = (int) main[num].getY();
        }
        this.move(moveCommand);
        brush.drawPolygon(xCords, yCords,4);
    }

    public void move(String whatToDo) {
        if (whatToDo.equals("up")) {
            this.position = new Point(this.position.getX() + Math.cos(Math.toRadians(rotation)), this.position.getY() + Math.sin(Math.toRadians(rotation)));
        }

        if (whatToDo.equals("right")) {
            this.rotation += 2;
        }

        if (whatToDo.equals("left")) {
            this.rotation -= 2;
            //System.out.println("left");
        }

        if (whatToDo.equals("standstill")) {

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                // handle the up arrow
                moveCommand = "up";
                break;
            case KeyEvent.VK_RIGHT:
                // Handles the right rotation
                moveCommand ="right";
                break;
            case KeyEvent.VK_LEFT:
                // Handles the left action
                moveCommand = "left";
                break;
            default:
                moveCommand = "standstill";
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch ( keyCode ) {
            // Activates the stop function at the right time
            case KeyEvent.VK_UP:
                // handle the up arrow
                moveCommand = "up";
                break;
            case KeyEvent.VK_RIGHT:
                // Handles the right rotation
                moveCommand ="up";
                break;
            case KeyEvent.VK_LEFT:
                // Handles the left action
                moveCommand = "up";
                break;
            default:
                moveCommand = "up";
                break;
        }
    }
}
