package formatters;
import Creatures.Creature;
import Main.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Animator extends JComponent {

    private ArrayList<GameObject> drawables;
    private int offset;
    private int tickPerSecond;

    /**Constructor of class.
     *
     */
    public Animator(int offset, int fps){
        this.offset = offset;
        tickPerSecond = fps;
    }

    /**
     * Updates the GameObject list.
     *
     * @param objects ArrayList of GameObjects
     */
    public void changeObjects(ArrayList<GameObject> objects){
        drawables = objects;
    }

    /**
     * Creates Graphics objects of the GameObject objects and draws them.
     *
     * @param g Graphics object
     */

    public void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for(GameObject obj:drawables) {
            int x = obj.getPosition().getX();
            int y = obj.getPosition().getY();
            g2d.drawImage(obj.getImage(), x-offset, y-offset,null);
        }
    }

    public void startTicker(){
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, 1000/tickPerSecond);
    }
}
