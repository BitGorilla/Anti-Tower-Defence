package Tiles;

import Creatures.Creature;
import Main.CenterPositionCalculator;
import Main.Direction;
import Main.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Created by jontor on 2018-12-09.
 */
public class EntryTeleporterTile extends Tile implements TileInterface {
    private Position portalLocation;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "portal.png");

    public EntryTeleporterTile(Direction direction, Position centerPos) {
        super(image, direction, centerPos, new Position(centerPos.getX() - 5,
                centerPos.getY() -5), new Position(centerPos.getX() + 5,
                centerPos.getY() + 5));
    }

    @Override
    public void landOn(Creature creature) {
        if(portalLocation != null) {
            creature.setPosition(portalLocation);
        }
    }

    public void setPortalLocation(Position portalLocation){
        this.portalLocation = portalLocation;
    }

}
