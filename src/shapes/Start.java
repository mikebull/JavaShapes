package shapes;

import java.awt.*;
import java.awt.event.*;

/**
 * This class just constructs a window in which a wire frame model can
 * be displayed.  The window has 3 buttons, which don't appear to do anything
 * as yet.  The main behaviour all takes place in the WireFrame class.
 *
 * @author Mike
 */
public class Start extends Frame implements WindowListener, ActionListener {
    
    // Buttons for Rotations and creating Shapes
    private Button xRot;
    private Button yRot;
    private Button zRot;
    private Button reset;
    private Button cube;
    private Button pyramid;
    private Button tetrahedron;
    private Button dodecahedron;
    private Button go;

    // Define shape
    private WireFrame myShape;

    // Initialise shape
    private RotatingThread t1;

    // Define button colour
    public static final Color[] buttonColour = {Color.black,Color.red};

    /**
     * Start the Program
     */
    public Start() {
        super("First Window");
        addWindowListener(this);
        Dimension d = this.getToolkit().getScreenSize();
        setSize(d.width-100,d.height-100);

        // Define height and width of shape
        myShape = new WireFrame(d.width-100, d.height-100);
        
        // Define and start thread for rotating
        t1 = new RotatingThread(myShape);
        t1.start();

        add("Center", myShape);

        // Define panel
        Panel bottomPanel = new Panel();

        // Add buttons
        xRot = new Button("Rotate x");
        yRot = new Button("Rotate y");
        zRot = new Button("Rotate z");
        cube = new Button("Cube");
        pyramid = new Button("Pyramid");
        tetrahedron = new Button("Tetrahedron");
        dodecahedron = new Button("Dodecahedron");
        reset = new Button("Reset");
        go = new Button ("Go");

        // Listen out for events on these buttons
        xRot.addActionListener(this);
        yRot.addActionListener(this);
        zRot.addActionListener(this);
        cube.addActionListener(this);
        pyramid.addActionListener(this);
        tetrahedron.addActionListener(this);
        dodecahedron.addActionListener(this);
        reset.addActionListener(this);
        go.addActionListener(this);

        // Add buttons to panel
        bottomPanel.add(xRot);
        bottomPanel.add(yRot);
        bottomPanel.add(zRot);
        bottomPanel.add(cube);
        bottomPanel.add(pyramid);
        bottomPanel.add(tetrahedron);
        bottomPanel.add(dodecahedron);
        bottomPanel.add(go);
        bottomPanel.add(reset);
        add("South",bottomPanel);
    }

    /**
     * Button Actions
     *
     * @param   ae  Action
     */
    public void actionPerformed(ActionEvent ae) {
        // Define button
        Button clickedButton;

        // Get source of button
        clickedButton = (Button)ae.getSource();

        // Define button actions
        if (clickedButton == reset) {
            t1.kill();
        } else if (clickedButton == xRot) {
            myShape.rotateX(10);
        } else if (clickedButton == yRot) {
            myShape.rotateY(10);
        } else if (clickedButton == zRot) {
            myShape.rotateZ(10);
        } else if (clickedButton == go) {
            t1.restart();
        } else if (clickedButton == cube) {
            myShape.createCube();
        } else if (clickedButton == pyramid) {
            myShape.createPyramid();
        } else if (clickedButton == tetrahedron) {
            myShape.createTetrahedron();
        } else if (clickedButton == dodecahedron) {
            myShape.createDodecahedron();
        }
    }

    /**
     * Window Listener Implementation
     * windowClosing is the only window event that cause action
     *
     * @param   e   Event
     */
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowClosed(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}

    /**
     * Make Start Object runnable in Main Method
     *
     * @param   args
     */
    public static void main(String[] args) {
        Start f = new Start();
        f.setVisible(true);
    }

}