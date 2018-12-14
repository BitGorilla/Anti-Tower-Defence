package tiles;

import creatures.Creature;
import creatures.Grunt;
import creatures.PortalusTotalus;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

public class SpikeTile extends Tile implements TileInterface{

    private int damageMultiplier = 2;
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
    public SpikeTile(Image image, Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        if(creature.getClass() != PortalusTotalus.class)
            creature.setCurrentHealth(creature.getCurrentHealth()-
                    creature.getCurrentSpeed()*damageMultiplier);
    }
}
