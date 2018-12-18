package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;

/**
 * @author
 * @since 2018-12-18
 */
public class TowerTile extends Tile implements TileInterface {
    private boolean builtOn = false;

    public TowerTile(Image image, Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {

    }

    public boolean isBuiltOn() {
        return builtOn;
    }

    public void setBuiltOn(boolean bool) {
        builtOn = bool;
    }
}
