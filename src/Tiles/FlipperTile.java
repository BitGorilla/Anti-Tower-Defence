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
        System.out.println(getDirection());
        Direction dir = getDirection();
        switch (dir){
            case EAST: setDirection(Direction.WEST);
            break;
            case WEST: setDirection(Direction.EAST);
            break;
            case NORTH: setDirection(Direction.SOUTH);
            break;
            case SOUTH: setDirection(Direction.NORTH);
            break;
        }
        System.out.println(getDirection());
    }
}
