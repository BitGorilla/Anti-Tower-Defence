package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;
import java.util.Random;

/**
 * Created by jontor on 2018-12-14.
 */
public class MisdirectionTile extends Tile implements TileInterface {
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
    public MisdirectionTile(Image image, Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        int random = new Random().nextInt(Direction.values().length);
        setDirection(Direction.values()[random]);
    }
}
