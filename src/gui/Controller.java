package gui;

import formatters.XMLReader;
import gameLogic.GameManager;
import gameLogic.Map;
import gameLogic.Position;
import highscore.Highscores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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


    private ActionListener startButtonPressed    = e -> startUp();
    private ActionListener pausPressed          = e -> pausGame();
    private ActionListener addCreature1Pressed = e -> addCreature1();
    private ActionListener addCreature2Pressed = e -> addCreature2();
    private ActionListener addCreature3Pressed = e -> addCreature3();
    private ActionListener placePortalPressed = e -> placePortal();
    private ActionListener flipperPressed = e -> flipFlipperTile(e);
    private ActionListener nextMapPressed = e -> nextMap();
    private ActionListener restartGamePressed = e -> restartGame();
    private ActionListener restartGameLoserPressed = e -> restartGameLoser();
    private ActionListener quitPressed = e -> quitGame();
    private ActionListener highscorePressed = e -> showHighscore();

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
                window = new Window(gamePanelWidth, gamePanel,
                        menuPanel, flipperPanel, nextMapPressed,
                        restartGamePressed, restartGameLoserPressed,
                        quitPressed);
                window.updateDropDown(dropDownMenu);
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
                , placePortalPressed, manager.getCurrentMapName());
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
        dropDownMenu.changePausStart();
    }

    private void pausGame() {
        manager.stopGame();
        window.remove(dropDownMenu);
        dropDownMenu.changePausStart();
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

                    if (manager.getGameOver() && !loserDialogIsShown && !mapWonIsShown){
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
        int gameWidth = 800;
        XMLReader reader;
        reader = new XMLReader(gameWidth);

        try {
            if (args.length == 0) {
                reader.setSource(new FileInputStream(new File("src/xmlBuilder" +
                        "/Maps/levels.xml")));
            } else if (args.length == 1 && args[0].endsWith(".xml")) {
                reader.setSource(new FileInputStream(new File(args[0])));
            } else {
                System.err.println("The program only takes one argument, an .xml " +
                        "file containing the maps.\nIf no arguments are given " +
                        "the " +
                        "default maps are run.");
                System.exit(1);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not find that file!");
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
     *
     * @author id15msd
     */
    public class HighScoreFetcher extends SwingWorker<ArrayList<String[]>,
            Integer>{

        /**
         * Gets highscores with the current map name. Scores are returned as an
         * ArrayList with String[].
         *
         * @return ArrayList with scores as a String[].
         */
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

        /**
         * Takes the ArrayList with scores and calls a method in the gui to
         * display them on a dialog window.
         */
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
     *
     * @author id15msd
     */
    public class HighScoreInserter extends SwingWorker<Integer, Integer>{

        /**
         * Inserts a score to the database via the Highscore-class.
         *
         * @return Unused Integer.
         */
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
    }
}
