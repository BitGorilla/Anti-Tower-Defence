package formatters;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animator implements JComponent {

    private ArrayList<GameObject> drawables;

    public Animator(ArrayList<GameObject> objects){
        drawables = objects;
    }

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
