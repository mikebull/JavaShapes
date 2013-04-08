package shapes;

/**
 * Cube.java
 *
 * @author mjpbull
 */
public class Cube extends Shape {

    // Initialise vertices for shape
    private Point3D[] vertices = new Point3D[8];

    // Initialise faces for shape
    private int[][] faces = new int[6][4];

    /**
     * Cube Constructor
     */
    public Cube() {
       
       vertices[0] = new Point3D(0.5, -0.5, -0.5);
       vertices[1] = new Point3D(0.5, 0.5, -0.5);
       vertices[2] = new Point3D(-0.5, 0.5, -0.5);
       vertices[3] = new Point3D(-0.5, -0.5, -0.5);

       vertices[4] = new Point3D(0.5, -0.5, 0.5);
       vertices[5] = new Point3D(0.5, 0.5, 0.5);
       vertices[6] = new Point3D(-0.5, 0.5, 0.5);
       vertices[7] = new Point3D(-0.5, -0.5, 0.5);

       faces[0][0] = 0;
       faces[0][1] = 1;
       faces[0][2] = 2;
       faces[0][3] = 3;

       faces[1][0] = 0;
       faces[1][1] = 3;
       faces[1][2] = 7;
       faces[1][3] = 4;

       faces[2][0] = 2;
       faces[2][1] = 3;
       faces[2][2] = 7;
       faces[2][3] = 6;

       faces[3][0] = 1;
       faces[3][1] = 2;
       faces[3][2] = 6;
       faces[3][3] = 5;

       faces[4][0] = 0;
       faces[4][1] = 1;
       faces[4][2] = 5;
       faces[4][3] = 4;

       faces[5][0] = 4;
       faces[5][1] = 5;
       faces[5][2] = 6;
       faces[5][3] = 7;

    }

    /**
     * Set cartesian coordinates for cube
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
     * Returns the number of faces on the cube
     *
     * @return      Number of faces (6)
     */
    public int getNumFace() {
        return 6;
    }
    
}
