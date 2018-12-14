package tiles;

import creatures.Creature;
import creatures.SpeedDemon;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

/**
 * Created by jontor on 2018-12-14.
 */
public class RegenerationTile extends Tile implements TileInterface {
    private int regenerationRate = 10;
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
    public RegenerationTile(Image image, Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        creature.setCurrentHealth(creature.getCurrentHealth() + regenerationRate);
        if(creature.getCurrentHealth() > creature.getMaxHealth()){
            creature.setCurrentHealth(creature.getMaxHealth());
        }
    }
}
