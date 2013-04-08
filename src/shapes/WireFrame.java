package shapes;

import java.awt.*;

/**
 * This class draws a 'userShape'. The userShape is drawn as an orthographic
 * projection (therefore allowing us to simply ignore the z dimension).
 *
 * @author Mike
 */
public class WireFrame extends Canvas {
    private Shape userShape;
    private int width;
    private int height;
    private int e = 300;
    private int d = 170;

    /**
     * Wireframe Constructor
     *
     * @param   width   Width
     * @param   height  Height
     */
    public WireFrame(int width,int height) { 
        createCube();
        this.width = width;
        this.height = height;
        setSize(width, height);
    }

    /**
     *
     */
    public void objToWorld() {
        for(int i = 0; i < userShape.getNumOfVertices(); i++) {
            Point3D p3d = userShape.getVertex(i);
            userShape.setVertex(i, new Point3D(p3d.getX()*150,
                    p3d.getY()*150, p3d.getZ()*150));
        }
    }

    /**
     * Rotation on the x axis
     *
     * @param   angle   Angle to go in
     */
    public void rotateX(double angle) {
        double rad = Math.toRadians(angle);
        double sinA = Math.sin(rad);
        double cosA = Math.cos(rad);
        
        double matrix[][] = {
            {1,0,0,0},
            {0,cosA,-sinA,0},
            {0,sinA,cosA,0},
            {0,0,0,1}
        };
        
        for(int i = 0; i < userShape.getNumOfVertices(); i++) {
            Point3D point = userShape.getVertex(i);
            double[][] multi = {{point.getX(),point.getY(),point.getZ(),1}};
            double[][] result = matrixMul(multi, matrix);
            point = new Point3D(result[0][0], result[0][1], result[0][2]);
            userShape.setVertex(i, point);
        }
        repaint();
    }

    /**
     * Rotation on the y axis
     *
     * @param   angle   Angle to go in
     */
    public void rotateY(double angle) {
        double rad = Math.toRadians(angle);
        double sinA = Math.sin(rad);
        double cosA = Math.cos(rad);
        
        double matrix[][] = {
            {cosA, 0, sinA, 0},
            {0, 1, 0, 0},
            {-sinA, 0, cosA, 0},
            {0, 0, 0, 1}
        };
        
        for(int i = 0; i < userShape.getNumOfVertices(); i++) {
            Point3D point = userShape.getVertex(i);
            double[][] multi = {{point.getX(),point.getY(),point.getZ(),1}};
            double[][] result = matrixMul(multi,matrix);
            point = new Point3D(result[0][0], result[0][1], result[0][2]);
            userShape.setVertex(i, point);
        }
        repaint();
    }

    /**
     * Rotation on the z axis
     *
     * @param   angle   Angle to go in
     */
    public void rotateZ(double angle) {
        double rad = Math.toRadians(angle);
        double sinA = Math.sin(rad);
        double cosA = Math.cos(rad);
        
        double matrix[][] = {
            {cosA,-sinA,0,0},
            {sinA,cosA,0,0},
            {0,0,1,0},
            {0,0,0,1}
        };
        
        for(int i = 0; i < userShape.getNumOfVertices(); i++) {
            Point3D point = userShape.getVertex(i);
            double[][] multi = {{point.getX(),point.getY(),point.getZ(),1}};
            double[][] result = matrixMul(multi,matrix);
            point = new Point3D(result[0][0], result[0][1], result[0][2]);
            userShape.setVertex(i, point);
        }
        repaint();
    }

    /**
     * Performs Matrix Multiplication
     *
     * @param   m1  First two-dimensional matrix
     * @param   m2  Second two-dimensional matrix
     * @return      Something?
     */
    public double[][] matrixMul(double[][] m1, double[][] m2) {

        // Get the number of rows and columns in m1 and m2
        int m1rows = m1.length;
        int m1cols = m1[0].length;
        int m2rows = m2.length;
        int m2cols = m2[0].length;

        if (m1cols != m2rows) {
            return null;
        }

        double[][] result = new double[m1rows][m2cols];

        // Multiply each row of m1
        for(int i=0; i < m1rows; i++) {
            // By each column of b
            for(int j = 0; j < m2cols; j++) {
                // Multiplication consists of a number of mRows additions
                for (int k = 0; k < m1cols; k++) {
                    result[i][j] += m1[i][k]*m2[k][j];
                }
            }
        }
        return result;
    }

    /*public void worldToScreen(double z) {
        
    }*/

    /**
     * Creates a new Cube shape on command
     */
    public void createCube() {
        userShape = new Cube();
        this.objToWorld();
        repaint();
    }

    /**
     * Creates a new Pyramid shape on command
     */
    public void createPyramid() {
        userShape = new Pyramid();
        this.objToWorld();
        repaint();
    }

    /**
     * Creates a new Tetrahedron shape on command
     */
    public void createTetrahedron() {
        userShape = new Tetrahedron();
        this.objToWorld();
        repaint();
    }

    /**
     * Creates a new Dodecahedron shape on command
     */
    public void createDodecahedron() {
        userShape = new Dodecahedron();
        this.objToWorld();
        repaint();
    }

    /**
     * Perspective on shape
     *
     * @param   v   Cartesian co-ordinates of shape
     * @param   d   Duh?
     * @return      Perspective co-ordinates
     */
    public Point3D perspectiveOnShape(Point3D v, double d) {
        double x, y, z, zd;
        x = v.getX();
        y = v.getY();
        z = v.getZ();
        zd = (z+350)/d;

        return new Point3D(x/zd, y/zd, d);
    }

    /**
     * Paint Shape to Screen
     *
     * @param   g   Graphics Context
     */
    public void paint(Graphics g) {
       Point3D jp, kp;

        for(int i = 0; i < userShape.getNumFace(); i++) {
           int[] data = userShape.getFace(i);
           for(int j = 0; j < data.length; j++) {
               int k = (j + 1) % data.length;
               //double x1 = d/(e*userShape.getVertex(j).getZ());
               //double x2 = d/(e*userShape.getVertex(k).getZ());

               jp = userShape.getVertex(data[j]);
               kp = userShape.getVertex(data[k]);

               kp = this.perspectiveOnShape(kp, 300);
               jp = this.perspectiveOnShape(jp, 300);

               g.drawLine((int)jp.getX() + getWidth() / 2,
                          (int)jp.getY() + getHeight() / 2,
                          (int)kp.getX() + getWidth() / 2,
                          (int)kp.getY()+ getHeight() / 2);
           }
       }
    }
}

   