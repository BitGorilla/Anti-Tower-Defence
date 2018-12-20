package creatures;

import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Grunt is a type of creature that extends the class Creature.
 * Creatures are the objects which the player sends out to reach the goal.
 * @author oi16jsn, oi16ohn
 * @since 2018-11-29
 */
public class Grunt extends Creature {

    public static final int MAXHEALTH = 500;
    public static final int SPEED = 3;
    public static final int COST = 100;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "grunt.png");

    public Grunt(Position pos, Direction dir) {
        super(pos, image, dir, SPEED, MAXHEALTH, COST);
        super.setCurrentHealth(MAXHEALTH);
        resetStats();

    }

    /**
     * Reset the stats of the creature.
     */
    private void resetStats() {
        super.setCurrentSpeed(SPEED);
    }
}
