import java.util.ArrayList;

public class SlowTile extends DefaultTile implements TileInterface {

    public SlowTile(ArrayList<Position> area) {
        super(area);
    }

    @Override
    public void landOn(Creature creature) {
        creature.setCurrentSpeed(creature.getCurrentSpeed()/2);
    }
}
