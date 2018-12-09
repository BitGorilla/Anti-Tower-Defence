package Main;

import formatters.XMLReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private ArrayList<Map> maps;
    private Timer timer;
    private int tickRate;
    private GameInstance currentGameInstance;
    boolean paused = true;

    public GameManager(ArrayList<Map> maps, int tickRate) {
        this.maps = maps;
        //30
        this.tickRate = tickRate;
        currentGameInstance = new GameInstance(maps.get(0));
    }

    public void startGame() {
        if(paused) {
            paused = false;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    updateGame();
                }
            }, 1000, 1000 / tickRate);
        }
    }

    public GameInstance getCurrentGameInstance() {
        return currentGameInstance;
    }

    public void stopGame() {
        if(timer != null) {
            timer.cancel();
            paused = true;
        }
    }

    public ArrayList<GameObject> getGameObjectsToDraw() {
        return currentGameInstance.getGameObjectsToDraw();
    }

    public ArrayList<Laser> getLaserPositionsToDraw() {
        return currentGameInstance.getLaserPositionsToDraw();
    }

    public ArrayList<Healthbar> getHealthbarsToDraw() {
        return currentGameInstance.getHealthBarsToDraw();
    }

    public void addCreature(int type) {
        if(!paused) {
            switch (type) {
                case 1:
                    currentGameInstance.addCreature(1);
                    break;
                case 2:
                    currentGameInstance.addCreature(2);
                    break;
            }
        }
    }

    public int getCredits() {
        return currentGameInstance.getCredits();
    }

    private void updateGame() {
        currentGameInstance.update();
    }

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
                objects.get(objects.size()-1).getPosition().print();
                //GM.currentGameInstance.addCreature(2);
            }}, 1000, 1000);
    }
}
