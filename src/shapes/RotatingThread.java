/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;

/**
 * Code to control automatica rotation on Shape
 *
 * @author Mike
 */
public class RotatingThread extends Thread {
    public int count = 1;
    public WireFrame myCube;
    public volatile boolean t = true;
    private boolean allDone = true;

    /**
     * RotatingThread constructor
     *
     * @param   myCube  Defined User Shape
     */
    public RotatingThread(WireFrame myCube) {
        this.myCube = myCube;
    }

    /**
     * Restarts Thread (Rotation)
     */
    public void restart() {
        allDone = true;
    }

    /**
     * Stops Thread (Rotation)
     */
    public void kill() {
        allDone = false;
    }

    /**
     * Override Thread superclass run method
     */
    @Override
    public void run() {
        while(t) {
            if(!allDone) {
                try {
                    Thread.sleep(1);
                } catch(InterruptedException e) {
                    System.out.println("Naughty!");
                }
            } else {

                try {
                    myCube.rotateX(1);
                    myCube.rotateY(1);
                    myCube.rotateZ(1);
                    try {
                        Thread.sleep(10);
                    } catch(InterruptedException e) {
                        System.out.println("Naughty!");
                    }
                } catch(NullPointerException e) {
                    System.out.println("Null");
                }
            }
        }
    }
}
