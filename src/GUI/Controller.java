package GUI;

import Main.*;
import formatters.XMLReader;
import highscore.Highscores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class Controller {

    private Window window;
    private GameManager manager;
    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    private FlipperPanel flipperPanel;
    private DropDownMenu dropDownMenu;
    private String usernameToDB;


    ActionListener startButtonPressed    = e -> startUp();
    ActionListener pausPressed          = e -> pausGame();
    ActionListener addCreature1Pressed = e -> addCreature1();
    ActionListener addCreature2Pressed = e -> addCreature2();
    ActionListener addCreature3Pressed = e -> addCreature3();
    ActionListener placePortalPressed = e -> placePortal();
    ActionListener flipperPressed = e -> flipFlipperTile(e);
    ActionListener nextMapPressed = e -> nextMap();
    ActionListener restartGamePressed = e -> restartGame();
    ActionListener restartGameLoserPressed = e -> restartGameLoser();
    ActionListener quitPressed = e -> quitGame();
    ActionListener highscorePressed = e -> showHighscore();



    private int tickRate = 30;
    private int fps = 60;
    private ArrayList<Position> flipperTilePositions;
    private int gamePanelWidth;
    private int tileDimension;
    private boolean mapWonIsShown = false;
    private boolean loserDialogIsShown = false;
    private boolean userNameDialogShown =  false;
    public Controller(ArrayList<Map> maps, int gamePanelWidth, int tileDimension) {
        manager = new GameManager(maps, tickRate);
        this.gamePanelWidth = gamePanelWidth;
        this.tileDimension = tileDimension;
        buildFlipperPanel();
        buildGamePanel();
        buildMenuPanel();
        buildDropDown();
        buildWindow();
        startDraw();
    }

    private void buildWindow() {
            SwingUtilities.invokeLater(()-> {
                window = new Window(gamePanelWidth,dropDownMenu, gamePanel,
                        menuPanel, flipperPanel, nextMapPressed,
                        restartGamePressed, restartGameLoserPressed,
                        quitPressed);
                window.showWindow();
            });
        startUp();
    }

    private void buildGamePanel() {
        gamePanel = new GamePanel(gamePanelWidth /tileDimension/2,fps,
                gamePanelWidth);
    }

    private void buildMenuPanel() {
        menuPanel = new MenuPanel(addCreature1Pressed, addCreature2Pressed, addCreature3Pressed
                , placePortalPressed);
    }

    private void buildFlipperPanel() {
        flipperTilePositions = manager.getFlipperTilePositions();
        if (flipperPanel == null) {
            flipperPanel = new FlipperPanel(flipperTilePositions, flipperPressed,
                    gamePanelWidth, gamePanelWidth / tileDimension);
        }
        else {
            flipperPanel.updateFlippers(flipperTilePositions);
        }
    }

    private void buildDropDown() {
        dropDownMenu = new DropDownMenu(restartGamePressed, pausPressed, startButtonPressed,
                quitPressed, highscorePressed);
    }

    private void nextMap() {
        mapWonIsShown = false;
        manager.setNextMap();
        buildFlipperPanel();
    }

    private void startUp() {
        manager.startGame();
    }

    private void pausGame() {
        manager.stopGame();
    }

    private void quitGame() {
        System.exit(1);
    }

    private void addCreature1() {
        new Thread (()-> manager.addCreature(1)).start();
    }

    private void addCreature2() {
        manager.addCreature(2);
    }

    private void addCreature3() {
        manager.addCreature(3);
    }

    private void startDraw() {
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(()-> {
                    if (manager.isMapWon()) {
                        if(manager.allLevelsWon() && !userNameDialogShown) {
                            userNameDialogShown = true;
                            //window.showVictoryPopUp();
                            UserNameDialog userNameDialog =
                                    new UserNameDialog();
                            usernameToDB = userNameDialog.getUserNameInput();

                            HighScoreInserter putter = new HighScoreInserter();
                            putter.execute();
                        }
                        else if (!mapWonIsShown && !userNameDialogShown) {
                            mapWonIsShown = true;
                            window.showMapWon();
                        }
                    }

                    if (manager.getGameOver() && !loserDialogIsShown){
                        loserDialogIsShown = true;
                        window.showLoserDialog();
                    }
                    //menuPanel.updateCredits(manager.getCredits());

                    menuPanel.updateStats(manager.getCredits(), manager.getScore());
                    gamePanel.updateObjects(manager.getGameObjectsToDraw());
                    gamePanel.updateLasers(manager.getLaserPositionsToDraw());
                    gamePanel.updateHealthBars(manager.getHealthbarsToDraw());
                    gamePanel.repaint();
                });
            }
        }, 10, 1000/fps);
    }

    private void flipFlipperTile(ActionEvent actionEvent) {
        FlipperButton flipperButton = (FlipperButton) actionEvent.getSource();
        manager.flipTile(flipperButton.getPos());
    }

    private void placePortal() {
        manager.placePortal();
    }

    private void restartGame() {
        userNameDialogShown = false;
        mapWonIsShown = false;
        manager.restartGame();
    }

    private void restartGameLoser() {
        loserDialogIsShown = false;
        manager.restartGame();
    }


    public static void main(String[] args) throws IOException {
        int gameWidth = 700;
        XMLReader reader;
        reader = new XMLReader(gameWidth);

        if (args.length == 0) {
            reader.setSource(new FileInputStream(new File("src/XMLBuilder" +
                    "/Maps/mapArray2.xml")));
        }
        else if (args.length == 1 && args[0].endsWith(".xml")) {
            reader.setSource(new FileInputStream(new File(args[0])));
        }
        else {
            System.err.println("The program only takes one argument, an .xml " +
                    "file containing the maps.\nIf no arguments are given " +
                    "the " +
                    "default maps are run.");
            System.exit(1);
        }
        Controller controller = new Controller(reader.getMaps(), gameWidth,
                reader.getWidth());
    }

    public void showHighscore(){
        HighScoreFetcher fetcher = new HighScoreFetcher();
        fetcher.execute();
    }

    /**
     * Fetches highscores from database via SwingWorker.
     */
    public class HighScoreFetcher extends SwingWorker<ArrayList<String[]>,
            Integer>{

        @Override
        protected ArrayList<String[]> doInBackground(){
            ArrayList<String[]> scoreList = new ArrayList<>();

            Highscores highscores = null;
            try {
                highscores = new Highscores();
                System.out.println(manager.getCurrentMapName());
                scoreList = highscores.getHighscores(
                        manager.getCurrentMapName());

                highscores.closeCon();
                return scoreList;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void done(){

            try {
                ArrayList<String[]> scoreList = get();
                window.showHighscoreDialog(scoreList);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Inserts a highscore in the database via SwingWorker.
     */
    public class HighScoreInserter extends SwingWorker<Integer, Integer>{

        @Override
        protected Integer doInBackground(){
            try {
                Highscores highscores = new Highscores();
                highscores.insertScore(usernameToDB,
                        manager.getCurrentMapName()
                        ,manager.getScore());
                highscores.closeCon();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return 1;
        }

        @Override
        protected void done(){

        }
    }
}
