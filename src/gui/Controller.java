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

/**
 * Controller is responsible for actionListeners in the gui, building the gui
 * and handles the communication between the game model and the gui.
 * @author id15lbn, id15mnd
 * @since 2018-12-10
 */

public class Controller {

    private Window window;
    private GameManager manager;
    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    private FlipperPanel flipperPanel;
    private DropDownMenu dropDownMenu;
    private String usernameToDB;

    private ActionListener startButtonPressed    = e -> startUp();
    private ActionListener pausePressed          = e -> pauseGame();
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
    public Controller(ArrayList<Map> maps, int gamePanelWidth,
                      int tileDimension) {
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

    /**
     * Starting the EDT thread and build a gui with all the panels.
     */
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

    /**
     * Build the game panel, the game field.
     */
    private void buildGamePanel() {
        gamePanel = new GamePanel(gamePanelWidth /tileDimension/2,fps,
                gamePanelWidth);
    }

    /**
     * Build the menu panel that contains the buttons in the gui.
     */
    private void buildMenuPanel() {
        menuPanel = new MenuPanel(addCreature1Pressed, addCreature2Pressed, addCreature3Pressed
                , placePortalPressed, manager.getCurrentMapName());

    }

    /**
     * Build the game buttons panel for the game field, contains the buttons
     * that makes it possible to change path in game.
     */
    private void buildFlipperPanel() {
        flipperTilePositions = manager.getFlipperTilePositions();
        if (flipperPanel == null) {
            flipperPanel = new FlipperPanel(flipperTilePositions,
                    flipperPressed, gamePanelWidth, gamePanelWidth /
                    tileDimension);
        }
        else {
            flipperPanel.updateFlippers(flipperTilePositions);
        }
    }

    /**
     * Build the dropdown menu in the top of the gui.
     */
    private void buildDropDown() {
        dropDownMenu = new DropDownMenu(restartGamePressed, pausePressed,
                startButtonPressed, quitPressed, highscorePressed);
    }

    /**
     * Sets a new game map to the gui.
     */
    private void nextMap() {
        mapWonIsShown = false;
        manager.setNextMap();
        buildFlipperPanel();
    }

    /**
     * Start game and change the title in the dropdown menu to "pause".
     */
    private void startUp() {
        manager.startGame();
        dropDownMenu.changePausStart();
    }

    /**
     * Pause game and change the title in the dropdown menu to "start".
     */
    private void pauseGame() {
        manager.stopGame();
        window.remove(dropDownMenu);
        dropDownMenu.changePausStart();
    }

    /**
     *  Quit game and close the game window.
     */
    private void quitGame() {
        System.exit(1);
    }

    /**
     * Starts a new thread when the a creature button is pressed by user.
     */
    private void addCreature1() {
        new Thread (()-> manager.addCreature(1)).start();
    }

    /**
     * Starts a new thread when the a creature button is pressed by user.
     */
    private void addCreature2() {
        manager.addCreature(2);
    }

    /**
     * Starts a new thread when the a creature button is pressed by user.
     */
    private void addCreature3() {
        manager.addCreature(3);
    }

    /**
     * Draws the game field depending on situation.
     * Shows popup dialogs (write user name when game is done to insert i
     * high score list, show victory dialog when level is done or losing
     * dialog if user lost the game)
     */
    private void startDraw() {
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(()-> {
                    if (manager.isMapWon()) {
                        if(manager.allLevelsWon() && !userNameDialogShown) {
                            userNameDialogShown = true;
                            UserNameDialog userNameDialog =
                                    new UserNameDialog();
                            usernameToDB = userNameDialog.getUserNameInput();

                            if (usernameToDB.equals("")) {
                                HighScoreInserter inserter =
                                        new HighScoreInserter();
                                inserter.execute();
                            }
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

                    menuPanel.updateStats(manager.getCredits(),
                            manager.getScore());
                    gamePanel.updateObjects(manager.getGameObjectsToDraw());
                    gamePanel.updateLasers(manager.getLaserPositionsToDraw());
                    gamePanel.updateHealthBars(manager.getHealthbarsToDraw());
                    gamePanel.repaint();
                });
            }
        }, 10, 1000/fps);
    }

    /**
     * Flipping a tile when user push the flipp tile button.
     */
    private void flipFlipperTile(ActionEvent actionEvent) {
        FlipperButton flipperButton = (FlipperButton) actionEvent.getSource();
        manager.flipTile(flipperButton.getPos());
    }

    /**
     * Place a portal on a tile when user push the place portal button.
     */
    private void placePortal() {
        manager.placePortal();
    }

    /**
     * Restart the game to level 1 and sets dialog variable to false.
     */
    private void restartGame() {
        userNameDialogShown = false;
        mapWonIsShown = false;
        manager.restartGame();
    }

    /**
     * Restart the game to level 1 and sets dialog variable to false.
     */
    private void restartGameLoser() {
        loserDialogIsShown = false;
        manager.restartGame();
    }

    /**
     * The main method of the game takes in a xml-file with levels and starts
     * a XML reader and starts a new controller.
     * @param args xml-file with levels
     * @throws IOException
     */
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
                System.err.println("The program only takes one argument, " +
                        "an .xml file containing the maps.\n" +
                        "If no arguments are given the default maps are run.");
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

    /**
     * Execute the SQL query to get the high score list in SQL Database to
     * show the user the high score list when high score button is pushed in
     * the drop down menu.
     */
    private void showHighscore(){
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
