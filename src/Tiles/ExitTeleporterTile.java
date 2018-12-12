package Tiles;
import Main.*;
import Creatures.Creature;
import Main.Direction;
import Main.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Created by jontor on 2018-12-10.
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

    @Override
    public void landOn(Creature creature) {

    }
}
