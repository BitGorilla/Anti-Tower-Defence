package creatures;

import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Speed demon is a type of creature that extends the class Creature.
 * Creatures are the objects which the player sends out to reach the goal.
 * Speed demon have more speed then the other creatures.
 * @author io16jsn, io16ohl
 * @since 2018-11-29
 */
public class SpeedDemon extends Creature {

    public static final int MAXHEALTH = 130;
    public static final int SPEED = 15;
    public static final int COST = 50;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "speedDemon.png");

    public SpeedDemon(Position pos, Direction dir) {
        super(pos, image, dir, SPEED, MAXHEALTH, COST);
        setCurrentHealth(MAXHEALTH);
    }
}
