package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

/**
 * Tile with no purpose other than filling unused space on game field.
 * @author oi16ohn, oi16jsn
 * @since 2018-12-18
 */
public class BlankTile extends Tile implements TileInterface {

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
    public BlankTile(Image image, Direction direction, Position centerPos,
                     Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    /**
     * Blank LandOn method, is not to affect creatures that walks on it.
     * @param creature, create to not be affected.
     */
    @Override
    public void landOn(Creature creature) {
    }
}
