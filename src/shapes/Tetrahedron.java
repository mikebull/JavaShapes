/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

package shapes;

/**
*
* @author Mike
*/
public class Tetrahedron extends Shape {

    // Initialise vertices for shape
    private Point3D[] vertices = new Point3D[4];

    // Initialise faces for shape
    private int[][] faces = new int[4][3];

    /**
    * Tetrahedron constructor
    */
    public Tetrahedron() {

        vertices[0]= new Point3D(0.5,0.5,0.5);
        vertices[1]= new Point3D(-0.5,-0.5,0.5);
        vertices[2]= new Point3D(-0.5,0.5,-0.5);
        vertices[3]= new Point3D(0.5,-0.5,-0.5);

        faces[0][0] = 0;
        faces[0][1] = 2;
        faces[0][2] = 1;

        faces[1][0] = 0;
        faces[1][1] = 1;
        faces[1][2] = 3;

        faces[2][0] = 2;
        faces[2][1] = 0;
        faces[2][2] = 3;

        faces[3][0] = 1;
        faces[3][1] = 2;
        faces[3][2] = 3;

    }

    /**
     * Setter for vertices
     *
     * @param   i   Index for vertices
     * @param   p   Create Point3D
     */
    public void setVertex(int i, Point3D p) {
        vertices[i] = p;
    }

    /**
     * Getter for vertices.
     *
     * @param   i   Index for vertices
     * @return      The specified vertex
     */
    public Point3D getVertex(int i) {
        return vertices[i];
    }

    /**
     * Gets an int for the amount of vertices for the cube
     *
     * @return      The amount of vertices in the cube
     */
    public int getNumOfVertices() {
        return vertices.length;
    }

    /**
     * Getter for faces
     *
     * @param   i   Index for vertices
     * @return      The specified vertex
     */
    public int[] getFace(int i) {
        return faces[i];
    }

    /**
     * Returns the number of faces on the pyramid
     *
     * @return      Number of faces (6)
     */
    public int getNumFace() {
        return 4;
    }

}
