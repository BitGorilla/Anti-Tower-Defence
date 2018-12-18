package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * @author
 * @since 2018-12-18
 */
public class EntryTeleporterTile extends Tile implements TileInterface {
    private Position portalLocation;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "portal.png");

    public EntryTeleporterTile(Direction direction, Position centerPos) {
        super(image, direction, centerPos, new Position(centerPos.getX() - 10,
                centerPos.getY() -10), new Position(centerPos.getX() + 10,
                centerPos.getY() + 10));
    }

    @Override
    public void landOn(Creature creature) {
        if(portalLocation != null) {
            creature.setPosition(new Position(portalLocation.getX(),portalLocation.getY()));
        }
    }

    public void setPortalLocation(Position portalLocation){
        this.portalLocation = portalLocation;

    }

}
