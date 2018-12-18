package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

/**
 * Tile class representing a tile where one tower can be built.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class TowerTile extends Tile implements TileInterface {
    private boolean builtOn = false;

    /**
     * Constructor of the class.
     *
     * @param image Image representing the object.
     * @param direction The direction to send creatures who reaches the center.
     * @param centerPos The center position of the object relative to the game
     *                  field.
     * @param upperLeft The upper left position of the object relative to the
     *                  game field.
     * @param lowerRight The lower right position of the object relative to the
     *                   game field.
     */
    public TowerTile(Image image, Direction direction, Position centerPos,
                     Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    /**
     * Blank landOn, creatures on this tile are not to be affected.
     * @param creature, creature on the tile.
     */
    @Override
    public void landOn(Creature creature) {

    }

    /**
     * Checks if the tile has a tower built on it.
     * @return boolean, true if tile is built on, false otherwise.
     */
    public boolean isBuiltOn() {
        return builtOn;
    }

    /**
     * Sets the builton attribute of the tile.
     * @param bool, true if the tile is to be builton, false otherwise.
     */
    public void setBuiltOn(boolean bool) {
        builtOn = bool;
    }
}
