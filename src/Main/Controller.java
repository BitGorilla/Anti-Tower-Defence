package Main;

import formatters.Animator;
import formatters.ImageLoader;
import formatters.XMLReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {

    private GameFieldTest gui;
    private GameManager manager;
    private String levelName;
    private int windowWidth;
    private XMLReader reader;
    private ArrayList<Map> map;
    private Animator animator;

    public Controller() throws IOException {
        animator = new Animator();
        ImageLoader.getImageLoader().setScale(150);

        reader = new XMLReader(300);
        reader.setSource(new FileInputStream(new File("/Users/martinsjolund/IdeaProjects/Anti-Tower-Defence/src/mapSmall.xml")));
        manager = new GameManager(reader.getMaps());
        animator.changeObjects(manager.getWhatToDraw());

        createGUI();
        manager.startGame();
        ticker();
    }

    public void createGUI(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GameFieldTest();
                gui.setAnimator(animator);
                gui.show();
            }
        });
    }

    private void ticker(){
        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                animator.changeObjects(manager.getWhatToDraw());
            }
        }, 0, 200);
    }



}
