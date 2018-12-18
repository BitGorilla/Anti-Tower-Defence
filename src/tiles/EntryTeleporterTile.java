package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Tile which if connected to a exitTeleporterTile teleports a creature there
 * if its landOn method is invoked.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class EntryTeleporterTile extends Tile implements TileInterface {
    private Position portalLocation;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "portal.png");

    /**
     * Constructor of the class.
     * @param direction The direction to send creatures who reaches the center.
     * @param centerPos The center position of the object relative to the game
     *                  field.
     */
    public EntryTeleporterTile(Direction direction, Position centerPos) {
        super(image, direction, centerPos, new Position(centerPos.getX() -10,
                centerPos.getY() -10), new Position(centerPos.getX() + 10,
                centerPos.getY() + 10));
    }

    /**
     * If this tile is has a portallocation it will teleport any creature that
     * steps on it to that portallocation.
     * @param creature, the creature that is on the tile.
     */
    @Override
    public void landOn(Creature creature) {
        if(portalLocation != null) {
            creature.setPosition(new Position(portalLocation.getX(),
                    portalLocation.getY()));
        }
    }

    /**
     * Sets the position of the exit portallocation. Should be a
     * exitTeleporterTiles center position.
     * @param portalLocation, Position to teleport creatures to.
     */
    public void setPortalLocation(Position portalLocation){
        this.portalLocation = portalLocation;

    }

}
