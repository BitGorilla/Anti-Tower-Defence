package Tiles;

import Creatures.Creature;
import Main.Direction;
import Main.Position;

import java.awt.*;

public class GoalTile extends Tile implements TileInterface {

    public GoalTile(Image image, Direction direction, Position centerPos,
                    Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        creature.setGoaled();
    }
}
