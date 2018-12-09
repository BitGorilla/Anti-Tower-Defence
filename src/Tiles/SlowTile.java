package Tiles;

import Creatures.Creature;
import Main.Direction;
import Main.Position;

import java.awt.*;

public class SlowTile extends Tile implements TileInterface {

    public SlowTile(Image image, Direction direction, Position centerPos,
                    Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        int speed = creature.getCurrentSpeed()/2;
        if (speed > 0)
            creature.setCurrentSpeed(speed);
        else
            creature.setCurrentSpeed(1);
    }
}
