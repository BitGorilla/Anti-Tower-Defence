package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

/**
 * Created by jontor on 2018-12-13.
 */
public class SpeedTile extends Tile implements TileInterface {
    /**
     * Constructor of the class.
     *
     * @param image      Image representing the object.
     * @param direction  The direction to send creatures who reaches the center.
     * @param centerPos  The center position of the object relative to the game
     *                   field.
     * @param upperLeft  The upper left position of the object relative to the
     *                   game field.
     * @param lowerRight The lower right position of the object relative to the
     */
    public SpeedTile(Image image, Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        int speed = creature.getCurrentSpeed()*2;
        if (speed > 0)
            creature.setCurrentSpeed(speed);
        else
            creature.setCurrentSpeed(1);
    }
}
