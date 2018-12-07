package formatters;
import Main.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animator extends JComponent {

    private ArrayList<GameObject> drawables;

    /**Constructor of class.
     *
     * @param objects Arraylist of GameObjects to draw.
     */
    public Animator(ArrayList<GameObject> objects){
        drawables = objects;
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
            g2d.drawImage(obj.getImage(), x, y,null);
        }
    }
}
