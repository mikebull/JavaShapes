package shapes;

/**
 * Point3D.java
 *
 * @author mjpbull
 */
public class Point3D {
    
    private double x;
    private double y;
    private double z;

    /**
     * Getter for x co-ordinate
     *
     * @return      x co-ordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Setter for x co-ordinate
     *
     * @param   x   x co-ordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter for y co-ordinate
     *
     * @return      y co-ordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Setter for y co-ordinate
     *
     * @param   y   y co-ordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter for z co-ordinate
     *
     * @return      z co-ordinate
     */
    public double getZ() {
        return z;
    }

    /**
     * Setter for z co-ordinate
     *
     * @param   z   z co-ordinate
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Point3D Constructor
     *
     * @param   x   x co-ordinate
     * @param   y   y co-ordinate
     * @param   z   z co-ordinate
     */
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
