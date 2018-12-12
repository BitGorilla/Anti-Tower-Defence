package formatters;
import Main.GameObject;
import Main.Healthbar;
import Main.Laser;
import Main.Position;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Animator extends JComponent {

    private ArrayList<GameObject> drawables;
    private ArrayList<Laser> lasers;
    private ArrayList<Healthbar> healthbars;
    private int offset;
    private int tickPerSecond;

    /**
     * Constructor of class.
     *
     * @param offset distance from center to edges of objects to draw.
     * @param fps Update speed.
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
    public void updateObjects(ArrayList<GameObject> objects){
        drawables = objects;
    }

    /**
     * Updates laser list.
     * @param lasers list of lasers.
     */
    public void updateLasers(ArrayList<Laser> lasers){
        this.lasers = lasers;
    }

    public void updateHealthBars(ArrayList<Healthbar> healthbars) {
        this.healthbars = healthbars;
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

        for (int i = 0; i < lasers.size(); i += 2) {
            Position lineStart = lasers.get(i).getLineStart();
            Position lineEnd = lasers.get(i).getLineEnd();
            g.setColor(lasers.get(i).getColor());
            g2d.drawLine(lineStart.getX(),lineStart.getY(),lineEnd.getX(),
                    lineEnd.getY());
        }

        for (int i = 0; i < healthbars.size(); i++) {
            Position position = healthbars.get(i).getPosition();
            g.setColor(healthbars.get(i).getMaxHealthColor());
            g2d.fillRect(position.getX(),position.getY(),
                    healthbars.get(i).getMaxHealthWidth(),
                    healthbars.get(i).getMaxHealthHeight());
            g.setColor(healthbars.get(i).getCurrentHealthColor());
            g2d.fillRect(position.getX(),position.getY(),
                    healthbars.get(i).getCurrentHealthWidth(),
                    healthbars.get(i).getCurrentHealthHeight());
        }
    }

    //TODO remove method?
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
