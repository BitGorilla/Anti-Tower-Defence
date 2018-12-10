package Tiles;

import Creatures.Creature;
import Main.Direction;
import Main.Position;

import java.awt.*;

/**
 * Created by jontor on 2018-12-09.
 */
public class TeleporterTile extends Tile implements TileInterface {
    private int teleportDistance = 50;

    public TeleporterTile(Image image, Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    //TODO Can't change direction..
    @Override
    public void landOn(Creature creature) {
        for (int i = 0; i < teleportDistance ; i++) {
            creature.move();
        }
    }

}
