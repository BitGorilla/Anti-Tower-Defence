package Main;

import formatters.Animator;
import formatters.XMLReader;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class TestController {

    private GameFieldTest gui;
    private GameManager manager;
    private XMLReader reader;
    private Animator animator;

    private int fps = 60;
    private int tickRate = 30;
    private int windowWidth = 700;

    public TestController() throws IOException {
        reader = new XMLReader(windowWidth);
        reader.setSource(new FileInputStream(new File("/Users/oscar/Documents" +
                "/Skola/15. AppJava/Projekt/Anti-Tower-Defence/src/XMLBuilder" +
                "/Maps/mapBigWithTowers.xml")));
        manager = new GameManager(reader.getMaps(), tickRate);

        animator = new Animator(calcOffset(), fps);

        createGUI();
        manager.startGame();
        startDraw();
    }

    public void createGUI(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GameFieldTest(windowWidth);
                gui.setAnimator(animator);
                gui.show();
            }
        });
    }

    private int calcOffset(){
        return windowWidth/reader.getWidth()/2;
    }

    public void startDraw(){
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                animator.updateObjects(manager.getGameObjectsToDraw());
                animator.updateLasers(manager.getLaserPositionsToDraw());
                animator.updateHealthBars(manager.getHealthbarsToDraw());
                animator.repaint();
            }
        }, 0, 1000/fps);
    }
}
