package gameLogic;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class with the responisibility of holding and highlevel managing the model
 * part of the system. All connection between the controller and the model in
 * the game goes through this class. Holds all read maps, the currentgame
 * instance of a map and knows if the current map has been won or lost and can
 * change map.
 * @author oi16jsn, oi16ohn
 * @since 18/12-19
 */
public class GameManager {
    private ArrayList<Map> maps;
    private Timer timer;
    private int tickRate;
    private GameInstance currentGameInstance;
    int score;
    boolean paused = true;
    int mapIndex;
    boolean mapWon;
    boolean updatedScoreAtWin = false;

    /**
     * Constructor of the class. Initiates the game to the first map in
     * the Map arraylist and sets the updaterate of the gamelogic.
     *
     * @param maps List of maps to manage.
     * @param tickRate How fast to update the game.
     */
    public GameManager(ArrayList<Map> maps, int tickRate) {
        this.maps = maps;
        this.tickRate = tickRate;
        this.mapIndex = 0;
        setNextMap();
    }

    /**
     * Changes the current map by creating a new instance of currentGameInstance
     * from the next map in the map ArrayList. Before changing map the current
     * score on that map is extracted from the gameinstance.
     */
    public void setNextMap(){
        mapWon = false;
        if(currentGameInstance !=null) {
            score += currentGameInstance.getScore();
        }
        currentGameInstance = new GameInstance(maps.get(mapIndex));
        mapIndex++;
    }

    /**
     * Starts the timer that updates the gameinstance for each timestep.
     * How long a timestep is is decided from the contructor of gamemanager.
     */
    public void startGame() {
        if(paused) {
            paused = false;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (currentGameInstance.mapWon()) {
                        mapWon = true;
                    }
                    updateGame();
                }
            }, 1000, 1000 / tickRate);
        }
    }

    /**
     * Getter for the arraylist of the positions for all flipperTiles
     * in the current gameInstance.
     * @return Arraylist of positions, each position representing the
     * centerposition of a flippertile in the current gameinstance.
     */
    public ArrayList<Position> getFlipperTilePositions(){
        return currentGameInstance.getFlipperTilePositions();
    }

    /**
     * Stops the game, cancels the timer updating the gamelogic.
     */
    public void stopGame() {
        if(timer != null) {
            timer.cancel();
            paused = true;
        }
    }

    /**
     * Getter for the gameOver attribute in the currentGameInstance.
     * @return boolean, true if game is over, false otherwise.
     */
    public Boolean getGameOver(){
        return currentGameInstance.gameOver();
    }

    /**
     * Getter for all the gameObjects in the current gameInstance.
     * @return A list of GameObject objects to draw.
     */
    public ArrayList<GameObject> getGameObjectsToDraw() {
        return currentGameInstance.getGameObjectsToDraw();
    }

    /**
     * Getter for all laserPositions in the current gameInstance.
     * @return A list of positions to draw a laser between.
     */
    public ArrayList<Laser> getLaserPositionsToDraw() {
        return currentGameInstance.getLaserPositionsToDraw();
    }

    /**
     * Getter for all healthBars in the curren gameInstance.
     * @return A list of healthbars to draw.
     */
    public ArrayList<Healthbar> getHealthbarsToDraw() {
        return currentGameInstance.getHealthbarsToDraw();
    }

    /**
     * Adds a creature to the game instance.
     * @param type Which type of creature to add.
     */
    public void addCreature(int type) {
        if(!paused) {
            switch (type) {
                case 1:
                    currentGameInstance.addCreature(1);
                    break;
                case 2:
                    currentGameInstance.addCreature(2);
                    break;
                case 3: currentGameInstance.addCreature(3);
            }
        }
    }

    /**
     * Getter for the current amount of credits.
     * @return The current credits of the game instance.
     */
    public int getCredits() {
        return currentGameInstance.getCredits();
    }

    /**
     * Updates the current gameInstance one timestep.
     */
    private void updateGame() {
        currentGameInstance.update();
    }


    /**
     * Changes the direction of the flipper tile at the given position.
     *
     * @param flipTilePosition Position of the flipper tile.
     */
    public void flipTile(Position flipTilePosition){
        currentGameInstance.flipTile(flipTilePosition);
    }

    /**
     * Places portal from portal creature.
     */
    public void placePortal(){
        currentGameInstance.placePortal();
    }

    /**
     * Checks if the current map has been won.
     * @return The win state of the current game.
     */
    public boolean isMapWon() {
        return mapWon;
    }

    /**
     * Restarts the game.
     */
    public void restartGame() {
        mapIndex = 0;
        mapWon = false;
        setNextMap();
        score = 0;
    }

    /**
     * Checks if all levels are won.
     * @return True if all levels are won.
     */
    public boolean allLevelsWon() {
        boolean allWon = mapWon && mapIndex == maps.size();
        if(allWon && !updatedScoreAtWin) {
            score += currentGameInstance.getScore();
            updatedScoreAtWin = true;
        }
        return mapWon && mapIndex == maps.size();
    }

    /**
     * @return The current name of the map played.
     */
    public String getCurrentMapName(){
        return currentGameInstance.getMapName();
    }

    /**
     * @return The score of the current game.
     */
    public int getScore() {
        return score;
    }

    /**
     * @return The win progress of the game played in score points.
     */
    public int getWinProgress() {
        return currentGameInstance.getWinProgress();
    }

    /**
     * @return How many points it takes to win the game.
     */
    public int getWinCondition() {
        return currentGameInstance.getWinCondition();
    }
}
