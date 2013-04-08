/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;

/**
 *
 * @author Mike
 */
public abstract class Shape {

    private Point3D vertices[];
    private int faces[][];

    /**
     * Shape Constructor
     */
    public Shape() {

    }

    /**
     * Set cartesian coordinates for shape
     *
     * @param   i   Index for vertices
     * @param   p   Create Point3D
     */
    public abstract void setVertex(int i, Point3D p);

    /**
     * Getter for vertices.
     *
     * @param   i   Index for vertices
     * @return      The specified vertex
     */
    public abstract Point3D getVertex(int i);

    /**
     * Getter for faces
     *
     * @param   i   Index for vertices
     * @return      The specified vertex
     */
    public abstract int[] getFace(int i);

    /**
     * Returns the number of faces on the cube
     *
     * @return      Number of faces (6)
     */
    public abstract int getNumFace();

    /**
     * Gets an int for the amount of vertices for the cube
     *
     * @return      The amount of vertices in the cube
     */
    public abstract int getNumOfVertices();
    
}
