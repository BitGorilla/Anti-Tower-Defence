package oscarTest;

import Main.GameManager;
import formatters.Animator;
import formatters.XMLReader;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    private Window window;
    private GameManager manager;
    private XMLReader reader;
    private GamePanel gamePanel;

    ActionListener startButtonPressed = e -> startUp();
    ActionListener pausPressed = e -> pausGame();
    ActionListener addCreature1Pressed = e -> addCreature1();
    ActionListener addCreature2Pressed = e -> addCreature2();

    private int tickRate = 30;
    private int fps = 60;
    private int windowWidth = 700;

    public Controller() throws IOException {
        reader = new XMLReader(windowWidth);
        reader.setSource(new FileInputStream(new File("/Users/oscar/Documents" +
                "/Skola/15. AppJava/Projekt/Anti-Tower-Defence/src/XMLBuilder" +
                "/Maps/mapMedium.xml")));
        manager = new GameManager(reader.getMaps(), tickRate);
        gamePanel = new GamePanel(windowWidth/reader.getWidth(),fps);
        showWindow();
        startDraw();
    }

    private void showWindow() {
            SwingUtilities.invokeLater(()-> {
                window = new Window(gamePanel,
                        new MenuPanel(startButtonPressed, pausPressed,
                                addCreature1Pressed
                                , addCreature2Pressed));
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
        manager.addCreature(1);
    }

    private void addCreature2() {
        manager.addCreature(2);
    }

    private void startDraw() {
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                gamePanel.updateObjects(manager.getGameObjectsToDraw());
                gamePanel.updateLasers(manager.getLaserPositionsToDraw());
                gamePanel.updateHealthBars(manager.getHealthbarsToDraw());
                gamePanel.repaint();
            }
        }, 10, 1000/fps);
    }

    public static void main(String[] args) throws IOException {
        Controller c = new Controller();
    }
}
