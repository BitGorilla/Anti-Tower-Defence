import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameInstance {

    private ArrayList<Position> path;
    private ArrayList<Tower> towers;
    private CopyOnWriteArrayList<Creature> creatures;
    private ArrayList<Tile> tiles;

    public GameInstance() {

    }

    public void update() {
        moveCreatures();
        affectCreatureOnTile();
        handleCreaturesInGoal();
        damageCreaturesIfPossible();
    }

    private void moveCreatures() {
        for (Creature creature: creatures) {
            creature.moveTo(creature.getPosition()+creature.getCurrentSpeed());
        }
    }

    private void affectCreatureOnTile() {
        for (Creature creature: creatures) {
            for (Tile tile: tiles) {
                for (Position position: tile.getArea()) {
                    if(path.get(creature.getPosition()).equals(position)) {
                        try {
                            tile.getClass().getMethod("landOn").invoke(creature);
                        } catch (IllegalAccessException e) {
                            System.err.println("Cant access landOn method!");
                        } catch (InvocationTargetException e) {
                            System.err.println("landOn threw an exception!");
                        } catch (NoSuchMethodException e) {
                            System.out.println("No method with landOn name found!");
                        }
                    }
                }  // <-- parallelltrapets :D
            }
        }
    }

    private void damageCreaturesIfPossible() {
        for (Tower tower: towers) {
            if(tower.readyToShoot()) {
                for (Creature creature : creatures) {
                    if(tower.positionInRange(path.get(creature.getPosition()))) {
                        creature.setCurrentHealth(creature.getCurrentHealth() - tower.shoot());
                        deleteCreatureIfDead(creature);
                        break;
                    }
                }
            }
        }
    }

    private void handleCreaturesInGoal() {
        for (Creature creature: creatures){
            if(creature.inGoal()) {
                //TODO add score
                creatures.remove(creature);
            }
        }
    }

    private void deleteCreatureIfDead(Creature creature) {
        if(creature.isDead())
            creatures.remove(creature);
    }
}
