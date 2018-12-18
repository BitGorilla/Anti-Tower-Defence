package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

/**
 * Tile which increases the speed of creatures on it.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class SpeedTile extends Tile implements TileInterface {
    /**
     * Constructor of the class.
     *
     * @param image      Image representing the object.
     * @param direction  The direction to send creatures who reaches the center.
     * @param centerPos  The center position of the object relative to the game
     *                   field.
     * @param upperLeft  The upper left position of the object relative to the
     *                   game field.
     * @param lowerRight The lower right position of the object relative to the
     */
    public SpeedTile(Image image, Direction direction, Position centerPos,
                     Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    /**
     * Increases the speed of the creatures that are on the tile.
     * @param creature, creature that is on the tile.
     */
    @Override
    public void landOn(Creature creature) {
        int speed = creature.getCurrentSpeed()*3;
        if (speed > 0)
            creature.setCurrentSpeed(speed);
        else
            creature.setCurrentSpeed(1);
    }
}
