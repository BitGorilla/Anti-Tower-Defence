package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

/**
 * Tile representing a goal. A creature which reaches this tile has reached its
 * goal.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class GoalTile extends Tile implements TileInterface {

    /**
     * Constructor of the class.
     *
     * @param image The image of the object that is to be drawn.
     * @param direction The direction to send creatures who reaches the center.
     * @param centerPos The center position of the object relative to the game
     *                  field.
     * @param upperLeft The upper left position of the object relative to the
     *                  game field.
     * @param lowerRight The lower right position of the object relative to the
     *                   game field.
     */
    public GoalTile(Image image, Direction direction, Position centerPos,
                    Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    /**
     * Creatures that is positioned on this tile are set to Goaled.
     * @param creature, creature that is position on this tile.
     */
    @Override
    public void landOn(Creature creature) {
        creature.setGoaled();
    }
}
