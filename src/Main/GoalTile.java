package Main;

public class GoalTile extends Tile implements TileInterface {

    public GoalTile(Direction direction, Position centerPos,
                     Position upperLeft, Position lowerRight) {
        super(direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {
        creature.setGoaled();
    }
}
