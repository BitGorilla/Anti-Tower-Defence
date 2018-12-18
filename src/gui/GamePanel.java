package gui;
import gameLogic.GameObject;
import gameLogic.Healthbar;
import gameLogic.Laser;
import gameLogic.Position;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Game panel is the panel that is the game field and draws the game objects
 * and the game map.
 * @author
 * @since 2018-12-10
 */

public class GamePanel extends JComponent {

    private ArrayList<GameObject> drawables = new ArrayList<>();
    private ArrayList<Laser> lasers = new ArrayList<>();
    private ArrayList<Healthbar> healthbars = new ArrayList<>();
    private int offset;
    private int tickPerSecond;

    /**
     * Constructor of class.
     *
     * @param offset Distance from center to edge of a game object.
     * @param fps TODO remove parameter?
     * @param gameWidth Width of the game panel in pixels.
     */
    public GamePanel(int offset, int fps, int gameWidth){
        this.offset = offset;
        tickPerSecond = fps;
        setBounds(0,0,gameWidth,gameWidth);
        setBackground(Color.darkGray);
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
     * Updates laser list in class.
     * @param lasers Lasers to update.
     */
    public void updateLasers(ArrayList<Laser> lasers){
        this.lasers = lasers;
    }

    /**
     * Updates healthbars in class.
     * @param healthbars Healthbars to update.
     */
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


        for (GameObject obj : drawables) {
                int x = obj.getPosition().getX();
                int y = obj.getPosition().getY();
                g2d.drawImage(obj.getImage(), x - offset, y - offset, null);
        }

        for (int i = 0; i < lasers.size(); i += 2) {
            Position lineStart = lasers.get(i).getLineStart();
            Position lineEnd = lasers.get(i).getLineEnd();
            ((Graphics2D) g).setStroke(new BasicStroke(5));
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

}
