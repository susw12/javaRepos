
package mrgonzalez.sujayswain.ps11;

public class Ship extends GameObject {
    private double turnSpeed = 180.0;
    private double accelerateSpeed = 250.0;
    private double slowingSpeed = .95;
    private boolean leftTurning = false, rightTurning = false, acceling = false;

    /**
     * Creates Ship
     *
     * Creates ship within mesh and hitbox range. <p>
     *
     * @param x start x
     * @param y start y
     * @return Ship s
     */
    public Ship(double x, double y) {
        this.x = x; this.y = y;
        this.direction = 0;


        int numPoints;
        Point[] points;
        double r, dir;

        numPoints = 50;
        points = new Point[numPoints];
        for (int i = 0; i < numPoints; i++) {
            dir = 2 * Math.PI * i / numPoints;
            r = -30 *( Math.pow( Math.cos(5 * dir), 2 ) * Math.sin(dir) + 0.3);
            double pointX = r * Math.cos(dir - Math.PI / 2);
            double pointY = r * Math.sin(dir  - Math.PI / 2);
            points[i] = new Point(pointX, pointY);
        }
        this.mesh = new Polygon(points, new Point(x,y), 0);

        numPoints = 50;
        points = new Point[numPoints];
        for (int i = 0; i < numPoints; i++) {
            dir = 2 * Math.PI * i / numPoints;
            r = -30 *( Math.pow( Math.cos(5 * dir), 2 ) * Math.sin(dir) + 0.3);
            double pointX = r * Math.cos(dir - Math.PI / 2);
            double pointY = r * Math.sin(dir  - Math.PI / 2);
            points[i] = new Point(pointX, pointY);
        }
        this.hitBox = new Polygon(points, new Point(x,y), 0);

        setMaxR();
    }

    public void leftTurn() {
        leftTurning = true;
        rightTurning = false;
    }

    public void stopleftTurn() {
        leftTurning = false;
    }

    public void rightTurn() {
        rightTurning = true;
        leftTurning = false;
    }

    public void stoprightTurn() {
        rightTurning = false;
    }

    public void accelerate() {
        acceling = true;
    }

    public void stopAccelerate() {
        acceling = false;
    }

    /**
     * Ticks
     *
     * Accelerates, applies friction, and turns.
     *
     * <p>
     *
     * @param screenWidth width of screen
     * @param screenHeight height of screen
     *
     */
    public void tick(int screenWidth, int screenHeight) {
        super.tick();
        if (leftTurning) direction -= turnSpeed / 60;
        if (rightTurning) direction += turnSpeed / 60;
        if (acceling) {
            this.xv += accelerateSpeed * Math.cos(Math.toRadians(direction)) / 60;
            this.yv += accelerateSpeed * Math.sin(Math.toRadians(direction)) / 60;
        }
    }
}