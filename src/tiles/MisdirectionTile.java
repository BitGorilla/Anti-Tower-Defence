package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;
import java.util.Random;

/**
 * Tile which randomly switches its direction for each time its landOn method
 * is invoked.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class MisdirectionTile extends Tile implements TileInterface {
    /**
     * Constructor of the class.
     *
     * @param image      Image representing the object.
     * @param dir  The direction to send creatures who reaches the center.
     * @param centerPos  The center position of the object relative to the game
     *                   field.
     * @param upperLeft  The upper left position of the object relative to the
     *                   game field.
     * @param lowerRight The lower right position of the object relative to the
     */
    public MisdirectionTile(Image image, Direction dir, Position centerPos,
                            Position upperLeft, Position lowerRight) {
        super(image, dir, centerPos, upperLeft, lowerRight);
    }

    /**
     * Randomly chooses a new direction to send creatures that walks on the
     * tile.
     * @param creature, creature that is on the tile.
     */
    @Override
    public void landOn(Creature creature) {
        int random = new Random().nextInt(Direction.values().length);
        setDirection(Direction.values()[random]);
    }
}
