package creatures;

import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Speed demon is a type of creature that extends the class Creature.
 * Creatures are the objects which the player sends out to reach the goal.
 * Speed demon have more speed then the other creatures.
 * @author oi16jsn, oi16ohn
 * @since 2018-11-29
 */
public class SpeedDemon extends Creature {

    public static final int MAXHEALTH = 160;
    public static final int SPEED = 10;
    public static final int COST = 40;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "speedDemon.png");

    /**
     * Constructor of class.
     * @param pos Position of this object.
     * @param dir Direction of this object.
     */
    public SpeedDemon(Position pos, Direction dir) {
        super(pos, image, dir, SPEED, MAXHEALTH, COST);
        setCurrentHealth(MAXHEALTH);
    }
}
