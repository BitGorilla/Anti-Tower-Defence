package Main;

import formatters.ImageLoader;
import formatters.XMLReader;

import javax.imageio.ImageReader;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    private ArrayList<Map> maps;
    private Timer timer = new Timer();
    private static final int TICKSPERSECOND = 1;
    private GameInstance currentGameInstance;

    public GameManager(ArrayList<Map> maps) {
        this.maps = maps;
        currentGameInstance = new GameInstance(maps.get(0));
    }

    public void startGame() {
        currentGameInstance.addCreature(1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateGame();
            }}, 1000, 1000/TICKSPERSECOND);
    }

    public GameInstance getCurrentGameInstance() {
        return currentGameInstance;
    }

    public void stopGame() {
        timer.cancel();
    }

    public ArrayList<GameObject> getWhatToDraw() {
        return currentGameInstance.getWhatToDraw();
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
        GameManager GM = new GameManager(maps);
        GM.startGame();
        GM.currentGameInstance.addCreature(1);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ArrayList<GameObject> objects = GM.getWhatToDraw();
                objects.get(objects.size()-1).getPosition().print();
                //GM.currentGameInstance.addCreature(2);
            }}, 1000, 1000/TICKSPERSECOND);
    }
}
