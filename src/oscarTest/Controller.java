package oscarTest;

import Main.GameInstance;
import Main.GameManager;
import Main.Map;
import Main.Position;
import formatters.XMLReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    private Window window;
    private GameManager manager;
    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    private FlipperPanel flipperPanel;


    ActionListener startButtonPressed = e -> startUp();
    ActionListener pausPressed = e -> pausGame();
    ActionListener addCreature1Pressed = e -> addCreature1();
    ActionListener addCreature2Pressed = e -> addCreature2();
    ActionListener addCreature3Pressed = e -> addCreature3();
    ActionListener placePortalPressed = e -> placePortal();
    ActionListener flipperPressed = e -> flipFlipperTile(e);
    ActionListener nextMapPressed = e -> nextMap();


    private int tickRate = 30;
    private int fps = 60;
    private ArrayList<Position> flipperTilePositions;
    private int gamePanelWidth;
    private int tileDimension;

    public Controller(ArrayList<Map> maps, int gamePanelWidth, int tileDimension) {
        manager = new GameManager(maps, tickRate);
        this.gamePanelWidth = gamePanelWidth;
        this.tileDimension = tileDimension;
        buildFlipperPanel();
        buildGamePanel();
        buildMenuPanel();
        buildWindow();
        startDraw();
    }

    private void buildWindow() {
            SwingUtilities.invokeLater(()-> {
                window = new Window(gamePanel, menuPanel, flipperPanel);
                window.showWindow();
            });
    }

    private void buildGamePanel() {
        gamePanel = new GamePanel(gamePanelWidth /tileDimension/2,fps,
                gamePanelWidth);
    }

    private void buildMenuPanel() {
        menuPanel = new MenuPanel(startButtonPressed, pausPressed,
                addCreature1Pressed, addCreature2Pressed, addCreature3Pressed
                , placePortalPressed);
    }

    private void buildFlipperPanel() {
        flipperTilePositions = manager.getFlipperTilePositions();
        if (flipperPanel == null) {
            flipperPanel = new FlipperPanel(flipperTilePositions, flipperPressed,
                    gamePanelWidth, gamePanelWidth / tileDimension);
        }
        else {
            System.out.println("Updatingflippers");
            flipperPanel.updateFlippers(flipperTilePositions);
        }
    }

    private void nextMap() {
        manager.setNextMap();
        buildFlipperPanel();
    }

    private void startUp() {
        System.out.println("starting");
        manager.startGame();
    }

    private void pausGame() {
        nextMap();
        manager.stopGame();
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
                    menuPanel.updateCredits(manager.getCredits());
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


    public static void main(String[] args) throws IOException {
        int gameWidth = 700;
        XMLReader reader;
        reader = new XMLReader(gameWidth);

        if (args.length == 0) {
            reader.setSource(new FileInputStream(new File("src/XMLBuilder" +
                    "/maps/levels/levels.xml")));
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
}
