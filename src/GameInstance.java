import java.util.ArrayList;

public class GameInstance {

    private ArrayList<Position> path;
    private ArrayList<Tower> towers;
    private ArrayList<Creature> creatures;

    public GameInstance() {

    }

    private void moveCreatures() {
        for (Creature creature: creatures) {
            creature.moveTo(creature.getPosition()+creature.getCurrentSpeed());
        }
    }

    private void damageCreaturesIfPossible() {
        for (Tower tower: towers) {
            for (Creature creature: creatures) {
                if(tower.positionInRange())
            }
        }
    }
}
