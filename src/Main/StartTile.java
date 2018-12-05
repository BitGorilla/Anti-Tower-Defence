package Main;

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
