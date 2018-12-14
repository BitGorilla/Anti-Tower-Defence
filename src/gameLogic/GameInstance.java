package gameLogic;

import creatures.Creature;
import creatures.Grunt;
import creatures.PortalusTotalus;
import creatures.SpeedDemon;
import tiles.*;
import towers.CleavesYouInPieces;
import towers.LazerToTheFazer;
import towers.SharpShooter;
import towers.Tower;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Class with the purpose of holding and updating one mapinstance of the model.
 * Contains and updates all tiles, towers, creatures that are active in the
 * mapinstance. Given a map it can add towers and creatures to its tiles and
 * then update their interactions with the world.
 *
 * @author oi16jsn, oi16ohn
 * @since 14/12-19
 */
public class GameInstance {

    private ArrayList<Tower> towers = new ArrayList<>();
    private CopyOnWriteArrayList<Creature> creatures =
            new CopyOnWriteArrayList<>();
    private PortalusTotalus portalusTotalus;
    private ArrayList<Tile> tiles = new ArrayList<>();
    private ArrayList<Laser> lasers = new ArrayList<>();
    private ArrayList<TowerTile> towerTiles = new ArrayList<>();
    private Position startPosition = null;
    private Direction startDirection;
    private String name;
    private int credits;
    private int goaledCreatures;
    private int winCondition = 10;
    private int creaturesCreated = 0;


    /**
     * Constructor to the class and initiates a gameinstance. Extracts special
     * tiles from the map, sets the startcredit and spawns towers at half of
     * the given towertiles in the map.
     * @param map, Map object to be brought to life.
     */
    public GameInstance(Map map) {
        this.tiles.addAll(map.getTiles());
        this.name = map.getName();
        this.credits = map.getStartCredit();
        goaledCreatures = 0;
        findStart();
        findTowerTiles();
        placeTowers();
        update();
    }

    /**
     * Calculates and returns the current score for the gameinstance.
     * @return int calculated by a million divided by the amount
     * of creatures spawned.
     */
    public int getScore(){
        if (creaturesCreated == 0)
            return 0;
        return 10000000/creaturesCreated;
    }

    /**
     * Loops through the tiles and sets the start tile.
     */
    private void findStart() {
        for (Tile tile: tiles) {
            if(tile.getClass() == StartTile.class) {
                startDirection = tile.getDirection();
                startPosition = tile.getCenterPos();
            }
        }
    }

    /**
     * Adds the given amount of credits to the gameinstance.
     * @param earnedCredits, int representing the amount of credits to be added.
     */
    private void earnCredits(int earnedCredits){
        credits += earnedCredits;
    }

    /**
     * Spawns a random towertype on half of the maps towertiles.
     */
    private void placeTowers() {
        int numberOfTowers = (int) ((double)towerTiles.size()/2);

        for (int i = 0; i < numberOfTowers; i++) {
            addTower((int) (Math.random() * (3)) +1);
        }
    }

    /**
     * Checks if the map has been won.
     * A map is won if the required amount of creatures has been goaled.
     * @return boolean, true if map is won, false if not.
     */
    public boolean mapWon(){
        return goaledCreatures >= winCondition;
    }

    /**
     * Checks if the game is over. Game is over if no creatures are alive and
     * there are no credits to buy more creatures.
     * @return boolean, true if gameOver, false otherwise.
     */
    public boolean gameOver() {
        return creatures.isEmpty() && credits < SpeedDemon.COST;
    }

    /**
     * Loops through all tiles and extracts the centerpositions of
     * those of flipperTile type.
     * @return Arraylist<Position>, Arraylist of the flipperTiles
     * centerpositions.
     */
    public ArrayList<Position> getFlipperTilePositions() {
        ArrayList<Position> positions = new ArrayList<>();
        for (Tile tile: tiles) {
            if(tile.getClass() == FlipperTile.class) {
                positions.add(new Position(tile.getCenterPos().getX(),
                        tile.getCenterPos().getY()));
            }
        }
        return positions;
    }

    /**
     * Loops through all tiles and sets those of towerTile type to the
     * towerTiles list.
     */
    private void findTowerTiles() {
        for (Tile tile: tiles) {
            if(tile.getClass() == TowerTile.class) {
                towerTiles.add((TowerTile) tile);
                ((TowerTile) tile).setBuiltOn(false);
            }
        }
    }

    /**
     * Updates the gameinstance. Moves, damages, affects, kills and goals
     * creatures and fires the towers.
     */
    public void update() {
        resetCreatureStats();
        affectCreatureOnTile();
        moveCreatures();
        handleCreaturesInGoal();
        damageCreaturesIfPossible();
        deleteCreatureIfDead();
    }

    /**
     * Resets all creatures to their base stats.
     */
    private void resetCreatureStats() {
        for (Creature creature: creatures) {
            creature.setDefaultStats();
        }
    }


    /**
     * Adds a tower on a random towerTile that is not already built on.
     * @param towerType, int representing the tower type.
     */
    public void addTower(int towerType) {
        ArrayList<TowerTile> emptyTowerTiles = new ArrayList<>();
        int random;
        Position pos;
        for (TowerTile tile: towerTiles) {
            if(!tile.isBuiltOn()) {
                emptyTowerTiles.add(tile);
            }
        }

        if (emptyTowerTiles.size() > 0) {
            random = (int) (Math.random() * (emptyTowerTiles.size()));
            TowerTile tt = emptyTowerTiles.get(random);
            pos = tt.getCenterPos();
            switch (towerType) {
                case 1:
                    towers.add(new SharpShooter(pos));
                    tt.setBuiltOn(true);
                    break;
                case 2:
                    towers.add(new LazerToTheFazer(pos));
                    tt.setBuiltOn(true);
                    break;
                case 3:
                    towers.add(new CleavesYouInPieces(pos));
                    tt.setBuiltOn(true);
                    break;
                default:
                    System.err.println("No tower type of that int (addTower)");
            }
        }
    }

    /**
     * Adds a creature to the creature list.
     * @param creatureType, int representing the type of creature to be created.
     */
    public void addCreature(int creatureType) {
        Position pos = new Position(startPosition.getX(), startPosition.getY());
        switch (creatureType) {
            case 1:
                if(credits >= SpeedDemon.COST) {
                    creatures.add(new SpeedDemon(pos, startDirection));
                    credits -= SpeedDemon.COST;
                }
                break;
            case 2:
                if(credits >= Grunt.COST) {
                    creatures.add(new Grunt(pos, startDirection));
                    credits -= Grunt.COST;
                }
                break;
            case 3:
                if(credits >= PortalusTotalus.COST && portalusTotalus == null){
                    portalusTotalus = (new PortalusTotalus(pos, startDirection));
                    creatures.add(portalusTotalus);
                    credits -= PortalusTotalus.COST;
                }
                break;
        }
        creaturesCreated++;
    }

    /**
     * Moves and directs all creatures one timestep forward.
     */
    private void moveCreatures() {
        for (Creature creature: creatures) {
            for (int i = 0; i < creature.getCurrentSpeed(); i++) {
                changeDirectionIfNeeded(creature);
                creature.move();
            }
        }
        movePortalusTotalusers();

    }

    /**
     * Moves and directs the portalusTotalus if he's alive.
     */
    private void movePortalusTotalusers(){
        if(portalusTotalus != null){
            for (int i = 0; i < PortalusTotalus.SPEED; i++) {
                changeDirectionIfNeeded((Creature) portalusTotalus);
                portalusTotalus.move();
                if(portalusTotalus.getTeleportCountDown() == 0){
                    tiles.add(portalusTotalus.createExitTeleporterTile());
                }
            }
            if(portalusTotalus.isDead()){
                creatures.remove(portalusTotalus);
                portalusTotalus = null;
            }
        }

    }

    /**
     * Tries to place a entryTeleporterTile on the position of Totalusportalus.
     */
    public void placePortal(){
        if(portalusTotalus != null) {
            tiles.add(portalusTotalus.createEntryTeleporterTile());
        }
    }

    /**
     * If a creature stands on a centerposition of a tile it changes its
     * direction to the one of that tiles.
     * @param creature, the creature to check.
     */
    private void changeDirectionIfNeeded(Creature creature) {
        for (Tile tile: tiles) {
            if (creature.getPosition().equals(tile.getCenterPos())) {
                creature.setDirection(tile.getDirection());
            }
        }
    }

    /**
     * Affects the creature depending on the tile it stands ons landOn method
     */
    private void affectCreatureOnTile() {
        for (Creature creature : creatures) {
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

    /**
     * Loops through all towers, checking if they are ready to shoot and if a
     * creature is in its range and if so fires at the creature damaging it.
     */
    private void damageCreaturesIfPossible() {
        reduceLaserLifeSpan();
        for (Tower tower: towers) {
            tower.reduceCooldown();
            if(tower.readyToShoot()) {
                for (Creature creature : creatures) {
                    if(tower.positionInRange(creature.getPosition())) {
                        creature.setCurrentHealth(creature.getCurrentHealth() -
                                tower.shoot());
                        lasers.add(new Laser(tower.getPosition(),
                                creature.getPosition(), tower.getLaserColor()));
                        break;
                    }
                }
            }
        }
    }

    /**
     * Reduces the lifetimer of a laser.
     */
    private void reduceLaserLifeSpan() {
        Laser laser;
        for (int i = 0; i < lasers.size(); i++) {
            laser = lasers.get(i);
            if (laser.getLifeTime() > 0)
                laser.reduceLifeTime();
            else
                lasers.remove(laser);
        }
    }

    /**
     * Loops through all creatures checking if they have been goaled.
     * If goaled it is removed from the creatures list and goaledcreatures
     * is incremented.
     */
    private void handleCreaturesInGoal() {
        for (Creature creature: creatures){
            if(creature.inGoal()) {
                goaledCreatures++;
                creatures.remove(creature);
            }
        }
    }

    /**
     * Loops through all creatures checking if they are dead. If dead the
     * creature is removed from creature list and credits are earned.
     */
    private void deleteCreatureIfDead() {
        for (Creature creature: creatures) {
            if (portalusTotalus != null) {
                if (portalusTotalus.isDead()) {
                    if (portalusTotalus.getTeleportCountDown() > 0)
                        tiles.remove(portalusTotalus.getEntryTeleporterTile());

                    portalusTotalus = null;
                }
            }
            if (creature.isDead()) {
                earnCredits(creature.getCost() / 2);
                creatures.remove(creature);

            }
        }
    }

    /**
     * Flips a flipTile at a given position.
     * @param tilePosition Position of the center of a fliptile.
     */
    public void flipTile(Position tilePosition) {
        for (int i = 0; i < tiles.size(); i++) {
            if(tilePosition.equals(tiles.get(i).getCenterPos())) {
                FlipperTile flipTile = (FlipperTile) tiles.get(i);
                flipTile.flipDirection();
            }
        }
    }

    /**
     * creating and returning an arraylist of all gameobjects.
     * @return
     */
    public synchronized ArrayList<GameObject> getGameObjectsToDraw() {
        ArrayList<GameObject> objectsToDraw = new ArrayList<>();
        objectsToDraw.addAll(tiles);
        objectsToDraw.addAll(towers);
        objectsToDraw.addAll(creatures);
        return objectsToDraw;
    }

    /**
     * Getter of Arraylist of lasers to draw.
     * @return Arraylist of lasers.
     */
    public synchronized ArrayList<Laser> getLaserPositionsToDraw() {
        return lasers;
    }

    /**
     * Getter of Arraylist of all healthbars to draw.
     * @return Arraylist of healthbars.
     */
    public synchronized ArrayList<Healthbar> getHealthbarsToDraw() {
        ArrayList<Healthbar> healthbarsToDraw = new ArrayList<>();
        for (Creature creature: creatures) {
            healthbarsToDraw.add(creature.getHealthbar());
        }
        return healthbarsToDraw;
    }

    /**
     * Getter of the credits.
     * @return int representing the number of credits available.
     */
    public synchronized int getCredits() {
        return credits;
    }

    /**
     * Getter of the name of the current map.
     * @return String of the name of the map.
     */
    public String getMapName(){
        return name;
    }
}