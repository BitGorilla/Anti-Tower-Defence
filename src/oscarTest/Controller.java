package oscarTest;

import Main.GameInstance;
import Main.GameManager;
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
    private XMLReader reader;
    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    private FlipperPanel flipperPanel;
    private GameInstance currentGameInstance;


    ActionListener startButtonPressed = e -> startUp();
    ActionListener pausPressed = e -> pausGame();
    ActionListener addCreature1Pressed = e -> addCreature1();
    ActionListener addCreature2Pressed = e -> addCreature2();
    ActionListener flipperPressed = e -> flipFlipperTile(e);

    private int tickRate = 30;
    private int fps = 60;
    private int gameWidth = 700;
    private ArrayList<Position> flipperTilePositions;

    public Controller() throws IOException {
        reader = new XMLReader(gameWidth);
        reader.setSource(new FileInputStream(new File("src/XMLBuilder" +
                "/maps/mapFlipper.xml")));
        manager = new GameManager(reader.getMaps(), tickRate);
        currentGameInstance = manager.getCurrentGameInstance();
        flipperTilePositions = currentGameInstance.getFlipperTilePositions();
        gamePanel = new GamePanel(gameWidth /reader.getWidth()/2,fps, gameWidth);
        menuPanel = new MenuPanel(startButtonPressed, pausPressed,
                addCreature1Pressed, addCreature2Pressed);
        flipperPanel = new FlipperPanel(flipperTilePositions, flipperPressed,
                gameWidth, gameWidth /reader.getWidth());
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

    private void startDraw() {
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                menuPanel.updateCredits(currentGameInstance.getCredits());
                gamePanel.updateObjects(currentGameInstance.getGameObjectsToDraw());
                gamePanel.updateLasers(currentGameInstance.getLaserPositionsToDraw());
                gamePanel.updateHealthBars(currentGameInstance.getHealthBarsToDraw());
                gamePanel.repaint();
            }
        }, 10, 1000/fps);
    }

    private void flipFlipperTile(ActionEvent actionEvent) {
        FlipperButton flipperButton = (FlipperButton) actionEvent.getSource();
        flipperButton.getPos().print();
        currentGameInstance.flipTile(flipperButton.getPos());
        System.out.println("FLIPPING STUFF");
    }

    public static void main(String[] args) throws IOException {
        Controller c = new Controller();
    }
}
