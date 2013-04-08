/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;

/**
 *
 * @author Mike
 */
public class Dodecahedron extends Shape {

    // Initialise vertices for shape
    private Point3D[] vertices = new Point3D[20];

    // Initialise faces for shape
    private int[][] faces = new int[12][5];

    // Extra definition for cartesan co-ordinates
    final double d = 0.4;
    final double x = 0.25;
    final double s = d + x;

    /**
    * Tetrahedron constructor
    */
    public Dodecahedron() {

        System.out.println("X is: " + x);   

        vertices[0]  = new Point3D(d,d,d);
        vertices[1]  = new Point3D(d,d,-d);
        vertices[2]  = new Point3D(d,-d,-d);
        vertices[3]  = new Point3D(d,-d,d);
        vertices[4]  = new Point3D(-d,d,d);
        vertices[5]  = new Point3D(-d,d,-d);
        vertices[6]  = new Point3D(-d,-d,-d);
        vertices[7]  = new Point3D(-d,-d,d);
        vertices[8]  = new Point3D(s,0,x);
        vertices[9]  = new Point3D(s,0,-x);
        vertices[10] = new Point3D(-s,0,x);
        vertices[11] = new Point3D(-s,0,-x);
        vertices[12] = new Point3D(0,-x,s);
        vertices[13] = new Point3D(0,x,s);
        vertices[14] = new Point3D(0,-x,-s);
        vertices[15] = new Point3D(0,x,-s);
        vertices[16] = new Point3D(x,s,0);
        vertices[17] = new Point3D(-x,s,0);
        vertices[18] = new Point3D(x,-s,0);
        vertices[19] = new Point3D(-x,-s,0);

        faces[0][0] = 8;
        faces[0][1] = 9;
        faces[0][2] = 1;
        faces[0][3] = 16;
        faces[0][4] = 0;

        faces[1][0] = 9;
        faces[1][1] = 8;
        faces[1][2] = 3;
        faces[1][3] = 18;
        faces[1][4] = 2;

        faces[2][0] = 16;
        faces[2][1] = 17;
        faces[2][2] = 4;
        faces[2][3] = 13;
        faces[2][4] = 0;

        faces[3][0] = 17;
        faces[3][1] = 16;
        faces[3][2] = 1;
        faces[3][3] = 15;
        faces[3][4] = 5;

        faces[4][0] = 11;
        faces[4][1] = 10;
        faces[4][2] = 4;
        faces[4][3] = 17;
        faces[4][4] = 5;

        faces[5][0] = 10;
        faces[5][1] = 11;
        faces[5][2] = 6;
        faces[5][3] = 19;
        faces[5][4] = 7;

        faces[6][0] = 18;
        faces[6][1] = 19;
        faces[6][2] = 7;
        faces[6][3] = 12;
        faces[6][4] = 3;

        faces[7][0] = 19;
        faces[7][1] = 18;
        faces[7][2] = 2;
        faces[7][3] = 14;
        faces[7][4] = 6;

        faces[8][0] = 14;
        faces[8][1] = 15;
        faces[8][2] = 1;
        faces[8][3] = 9;
        faces[8][4] = 2;

        faces[9][0] = 15;
        faces[9][1] = 14;
        faces[9][2] = 6;
        faces[9][3] = 11;
        faces[9][4] = 5;

        faces[10][0] = 12;
        faces[10][1] = 13;
        faces[10][2] = 0;
        faces[10][3] = 8;
        faces[10][4] = 3;

        faces[11][0] = 13;
        faces[11][1] = 12;
        faces[11][2] = 7;
        faces[11][3] = 10;
        faces[11][4] = 4;


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
        return 12;
    }
}
