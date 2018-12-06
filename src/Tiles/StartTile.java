package Tiles;

import Creatures.Creature;
import Main.Direction;
import Main.Position;

public class StartTile extends Tile implements TileInterface {

    public StartTile(Direction direction, Position centerPos,
                     Position upperLeft, Position lowerRight) {
        super(direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        creature.setCurrentSpeed(creature.getCurrentSpeed()/2);
    }
}
