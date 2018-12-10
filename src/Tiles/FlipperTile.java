package Tiles;

import Creatures.Creature;
import Main.Direction;
import Main.Position;

import java.awt.*;

/**
 * Created by jontor on 2018-12-10.
 */
public class FlipperTile extends Tile implements TileInterface {
    public FlipperTile(Image image, Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {

    }

    public void flipDirection(){
        Direction dir = getDirection();
        switch (dir){
            case EAST: setDirection(Direction.WEST);
            case WEST: setDirection(Direction.EAST);
            case NORTH: setDirection(Direction.SOUTH);
            case SOUTH: setDirection(Direction.NORTH);
        }
    }
}
