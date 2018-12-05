package Main;

import formatters.XMLReader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameInstance {

    private ArrayList<Position> path;
    private ArrayList<Tower> towers = new ArrayList<>();
    private CopyOnWriteArrayList<Creature> creatures = new CopyOnWriteArrayList<>();
    private ArrayList<Tile> tiles = new ArrayList<>();

    public GameInstance(ArrayList<Position> path) {
        this.path = path;
    }

    public void update() {
        moveCreatures();
        affectCreatureOnTile();
        handleCreaturesInGoal();
        damageCreaturesIfPossible();
    }

    public void addTower(int towerType, Position pos) {
        switch (towerType) {
            case 1:
                towers.add(new SharpShooter(pos));
                break;
            default:
                System.err.println("No tower type of that int (addTower)");
        }
    }

    public void addCreature(int creatureType) {
        switch (creatureType) {
            case 1:
                creatures.add(new SpeedDemon( new Position(0,0)));
                break;
            case 2:
                creatures.add(new Grunt( new Position(0,0)));
                break;
            default:
                System.err.println("No creature type of that int (addCreature)");
        }
    }

    private void moveCreatures() {
        for (Creature creature: creatures) {
            for (int i = 0; i < creature.getCurrentSpeed(); i++) {
                creature.move();
            }
        }
    }

    private void affectCreatureOnTile() {
        for (Creature creature : creatures) {
            for (Tile tile : tiles) {
                if (tile.positionOnTile(creature.getPosition())) {
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

    private void damageCreaturesIfPossible() {
        for (Tower tower: towers) {
            tower.reduceCooldown();
            if(tower.readyToShoot()) {
                for (Creature creature : creatures) {
                    if(tower.positionInRange(creature.getPosition())) {
                        System.out.println("FIREING AT CREATURE: " + creatures.indexOf(creature));
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

    public void printAll() {
        for (Creature creature: creatures) {
            creature.printStats();
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        XMLReader reader = new XMLReader();
        File file = new File("XMLBuilder/map2.xml");
        reader.setSource(new FileInputStream(file));
        reader.next();
    }
}
