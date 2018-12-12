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
    private GameInstance currentGameInstance;


    ActionListener startButtonPressed = e -> startUp();
    ActionListener pausPressed = e -> pausGame();
    ActionListener addCreature1Pressed = e -> addCreature1();
    ActionListener addCreature2Pressed = e -> addCreature2();
    ActionListener addCreature3Pressed = e -> addCreature3();
    ActionListener placePortalPressed = e -> placePortal();
    ActionListener flipperPressed = e -> flipFlipperTile(e);

    private int gamePanelWidth;
    private int tickRate = 30;
    private int fps = 60;
    private ArrayList<Position> flipperTilePositions;

    public Controller(ArrayList<Map> maps, int gamePanelWidth, int tileDimension) throws IOException {
        this.gamePanelWidth = gamePanelWidth;
        manager = new GameManager(maps, tickRate);
        currentGameInstance = manager.getCurrentGameInstance();
        flipperTilePositions = currentGameInstance.getFlipperTilePositions();
        gamePanel = new GamePanel(gamePanelWidth /tileDimension/2,fps,
                gamePanelWidth);
        menuPanel = new MenuPanel(startButtonPressed, pausPressed,
                addCreature1Pressed, addCreature2Pressed, addCreature3Pressed
                , placePortalPressed);
        flipperPanel = new FlipperPanel(flipperTilePositions, flipperPressed,
                gamePanelWidth, gamePanelWidth /tileDimension);
        showWindow();
        startDraw();
    }

    private void showWindow() {
            SwingUtilities.invokeLater(()-> {
                window = new Window(gamePanel, menuPanel, flipperPanel);
                window.showWindow();
            });
    }

    private void startUp() {
        System.out.println("starting");
        manager.startGame();
    }

    private void pausGame() {
        manager.stopGame();
    }

    private void addCreature1() {
        new Thread (()-> currentGameInstance.addCreature(1)).start();
    }

    private void addCreature2() {
        currentGameInstance.addCreature(2);
    }

    private void addCreature3() {
        currentGameInstance.addCreature(3);
    }

    private void startDraw() {
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(()-> {
                    menuPanel.updateCredits(currentGameInstance.getCredits());
                    gamePanel.updateObjects(currentGameInstance.getGameObjectsToDraw());
                    gamePanel.updateLasers(currentGameInstance.getLaserPositionsToDraw());
                    gamePanel.updateHealthBars(currentGameInstance.getHealthBarsToDraw());
                    gamePanel.repaint();
                });
            }
        }, 10, 1000/fps);
    }

    private void flipFlipperTile(ActionEvent actionEvent) {
        FlipperButton flipperButton = (FlipperButton) actionEvent.getSource();
        currentGameInstance.flipTile(flipperButton.getPos());
    }

    private void placePortal() {
        currentGameInstance.placePortal();
    }


    public static void main(String[] args) throws IOException {
        int gameWidth = 700;
        XMLReader reader;
        reader = new XMLReader(gameWidth);

        if (args.length == 0) {
            reader.setSource(new FileInputStream(new File("src/XMLBuilder" +
                    "/maps/mapFlipper.xml")));
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
