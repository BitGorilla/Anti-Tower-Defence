import java.util.ArrayList;

public class SlowTile extends Tile implements TileInterface {

    public SlowTile(ArrayList<Position> area) {
        super(area);
    }

    @Override
    public void landOn(CreatureInterface creature) {
        creature.setCurrentSpeed(creature.getCurrentSpeed()/2);
    }
}
