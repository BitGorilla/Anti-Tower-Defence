package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

/**
 * Tile representing the start of a map. This is where newly added
 * creatures will be spawned.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class StartTile extends Tile implements TileInterface {

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
    public StartTile(Image image, Direction direction, Position centerPos,
                     Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    /**
     * Blank landOn, no affect on creatures on this tile.
     * @param creature
     */
    @Override
    public void landOn(Creature creature) {
    }
}
