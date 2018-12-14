package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

public class StartTile extends Tile implements TileInterface {

    public StartTile(Image image, Direction direction, Position centerPos,
                     Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        //creature.setCurrentSpeed(creature.getCurrentSpeed()/2);
    }
}
