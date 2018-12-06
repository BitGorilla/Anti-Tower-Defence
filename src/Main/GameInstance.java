package Main;

import Creatures.Creature;
import Creatures.Grunt;
import Creatures.SpeedDemon;
import Tiles.*;
import Towers.SharpShooter;
import Towers.Tower;
import formatters.XMLReader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameInstance {

    private ArrayList<Tower> towers = new ArrayList<>();
    private CopyOnWriteArrayList<Creature> creatures = new CopyOnWriteArrayList<>();
    private ArrayList<Tile> tiles;
    private Position startPosition = null;
    private Direction startDirection;

    public GameInstance(ArrayList<Tile> tiles) {
        this.tiles = tiles;
        for (Tile tile: tiles) {
            if(tile.getClass() == StartTile.class) {
                startDirection = tile.getDirection();
                startPosition = tile.getCenterPos();
            }
        }
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
                creatures.add(new SpeedDemon(startPosition, startDirection));
                break;
            case 2:
                creatures.add(new Grunt(startPosition, startDirection));
                break;
            default:
                System.err.println("No creature type of that int (addCreature)");
        }
    }

    private void moveCreatures() {
        for (Creature creature: creatures) {
            for (int i = 0; i < creature.getCurrentSpeed(); i++) {
                creature.move();
                //WARNING ORDO WARNING jontor
                changeDirectionIfNeeded(creature);
            }
        }
    }

    private void changeDirectionIfNeeded(Creature creature) {
        for (Tile tile: tiles) {
            if (creature.getPosition().equals(tile.getCenterPos()))
                creature.setDirection(tile.getDirection());
        }
    }

    private void affectCreatureOnTile() {
        for (Creature creature : creatures) {
            creature.setCurrentSpeed(10);
            for (Tile tile : tiles) {
                if (tile.positionOnTile(creature.getPosition())) {
                    try {
                        Method landOn = tile.getClass().getMethod("landOn",
                                Creature.class);
                        landOn.invoke(tile,creature);
                    } catch (NoSuchMethodException e) {
                        System.out.println("No method with landOn name found!");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
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
        XMLReader reader = new XMLReader(800);
        File file = new File("XMLBuilder/map2.xml");
        reader.setSource(new FileInputStream(file));
        Map map = reader.buildMap();
        GameInstance GI = new GameInstance(map.getTiles());
        GI.addCreature(1);
        GI.printAll();
        Creature ourGuy = GI.creatures.get(0);
        while(!ourGuy.inGoal()){
            GI.update();
            ourGuy.printStats();
        }
    }
}
