package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Tileclass for representing the exit to a entryTeleporterTile. Creatures
 * teleported from the connected entryteleporterTile will land here.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class ExitTeleporterTile extends Tile implements TileInterface{

    public static final Image image = ImageLoader.getImageLoader().getImage(
            "portal.png");

    /**
     * Constructor of the class.
     *
     * @param direction  The direction to send creatures who reaches the center.
     * @param centerPos  The center position of the object relative to the game
     *                   field.
     */
    public ExitTeleporterTile(Direction direction, Position centerPos) {
        super(image, direction, centerPos, new Position(centerPos.getX() - 5,
                centerPos.getY() -5), new Position(centerPos.getX() + 5,
                centerPos.getY() + 5));
    }

    /**
     * Blank landOn, nothing to happen to creatures on this tile.
     * @param creature, creature that is on Tile.
     */
    @Override
    public void landOn(Creature creature) {

    }
}
