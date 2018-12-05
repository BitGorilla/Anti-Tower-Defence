import java.util.ArrayList;

public class SlowTile extends Tile implements TileInterface {

    public SlowTile(Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(CreatureInterface creature) {
        creature.setCurrentSpeed(creature.getCurrentSpeed()/2);
    }
}
