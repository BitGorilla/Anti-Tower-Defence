package Tiles;

import Creatures.Creature;
import Main.Direction;
import Main.Position;

public class BlankTile extends Tile implements TileInterface {

    public BlankTile(Direction direction, Position centerPos,
                     Position upperLeft, Position lowerRight) {
        super(direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        creature.setCurrentSpeed(creature.getCurrentSpeed()/2);
    }
}
