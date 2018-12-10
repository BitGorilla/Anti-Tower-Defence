package Main;

import java.awt.*;

/**
 * The laser is the projectile of the towers. The laser is drawn as a line
 * between the tower and the creature it is shooting.
 */
public class Laser {

    private Position lineStart;
    private Position lineEnd;
    private int lifeTime;
    private Color color;

    /**
     * Constructor of class.
     *
     * @param lineStart Start position of the laser.
     * @param lineEnd End position of the laser.
     * @param color Color of the laser.
     */
    public Laser(Position lineStart, Position lineEnd, Color color) {
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
        this.color = color;
        lifeTime = 10;
    }

    /**
     *
     * @return The start position of the laser.
     */
    public Position getLineStart() {
        return lineStart;
    }

    /**
     *
     * @return the end position of the laser.
     */
    public Position getLineEnd() {
        return lineEnd;
    }

    /**
     *
     * @return The life time of the laser.
     */
    public int getLifeTime() {
        return lifeTime;
    }

    /**
     * Reduces the life time of the laser.
     */
    public void reduceLifeTime() {
        lifeTime--;
    }

    /**
     *
     * @return The color of the laser.
     */
    public Color getColor() {
        return color;
    }
}
