package Main;

import formatters.ImageLoader;
import formatters.XMLReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO write the purpose of the class.
 */
public class GameManager {
    private ArrayList<Map> maps;
    private Timer timer;
    private int tickRate;
    private GameInstance currentGameInstance;
    boolean paused = true;
    int mapIndex;
    boolean mapWon;

    /**
     * Constructor of the class.
     *
     * @param maps List of maps to manage.
     * @param tickRate How fast to update the game.
     */
    public GameManager(ArrayList<Map> maps, int tickRate) {
        this.maps = maps;
        //30
        this.tickRate = tickRate;
        this.mapIndex = 0;
        setNextMap();
    }

    public void setNextMap(){
        mapWon = false;
        currentGameInstance = new GameInstance(maps.get(mapIndex));
        mapIndex++;
    }

    /**
     * Start the game.
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

    public ArrayList<Position> getFlipperTilePositions(){
        return currentGameInstance.getFlipperTilePositions();
    }

    /**
     * Stops the game.
     */
    public void stopGame() {
        if(timer != null) {
            timer.cancel();
            paused = true;
        }
    }

    /**
     *
     * @return A list of GameObject objects to draw.
     */
    public ArrayList<GameObject> getGameObjectsToDraw() {
        return currentGameInstance.getGameObjectsToDraw();
    }

    /**
     *
     * @return A list of positions to draw a laser between.
     */
    public ArrayList<Laser> getLaserPositionsToDraw() {
        return currentGameInstance.getLaserPositionsToDraw();
    }

    /**
     *
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
     *
     * @return The current credits of the game instance.
     */
    public int getCredits() {
        return currentGameInstance.getCredits();
    }

    /**
     * Updates all game objects.
     */
    private void updateGame() {
        currentGameInstance.update();
    }

    //TODO remove?
    public static void main(String[] args) throws IOException, InterruptedException {
        XMLReader reader = new XMLReader(1000);
        reader.setSource(new FileInputStream(new File(
                "XMLBuilder/Maps/mapBig.xml")));
        ArrayList<Map> maps = reader.getMaps();
        GameManager GM = new GameManager(maps,10);
        GM.startGame();
        GM.currentGameInstance.addCreature(1);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ArrayList<GameObject> objects = GM.getGameObjectsToDraw();
                //GM.currentGameInstance.addCreature(2);
            }}, 1000, 1000);
    }

    public void flipTile(Position flipTilePosition){
        currentGameInstance.flipTile(flipTilePosition);
    }

    public void placePortal(){
        currentGameInstance.placePortal();
    }

    public boolean isMapWon() {
        return mapWon;
    }

    public void restartGame() {
        mapIndex = 0;
        mapWon = false;
        setNextMap();
    }

    public boolean allLevelsWon() {
        return mapWon && mapIndex == maps.size();
    }

    public String getCurrentMapName(){
        return currentGameInstance.getMapName();
    }

}
