package Main;

import formatters.Animator;
import formatters.XMLReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controller {

    private GUI gui;
    private GameManager gameM;
    private String levelName;
    private int windowWidth;
    private XMLReader reader;
    private ArrayList<Map> maps;
    private Animator animator;

    public Controller(){
        createGUI();
        this.reader = createXMLReader();
        //this.maps = reader.buildMaps();
        this.gameM = createGameManager(maps);
        //addGrantActionList(gui);
        this.levelName = getLevelName();
        //this.windowWidth = reader.;
        //this.animator = new Animator()
        //setLevelNameInGUI();
    }

    public void createGUI(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GUI("Anti Tower Defence", animator, windowWidth);
                addSpeedDemonActionList();
                addGrantActionList();
                gui.show();
            }
        });
    }

    public XMLReader createXMLReader(){
        XMLReader reader = new XMLReader(windowWidth);
        return reader;
    }

    public GameManager createGameManager(ArrayList<Map> maps){
        GameManager gm = new GameManager(maps);
        return gm;
    }

    private String getLevelName(){
        String str = "Levelname";
        //reader.
        return str;
        //return map.getName();
    }

    private void setCreditsToGUI(){
       // gui.setCredits(10000);
    }

    /*private void setLevelNameInGUI(){
        gui.setLevelName(getLevelName());
    }*/

    private void addGrantActionList() {
        ActionListener actionListGrunt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Grant button is pressed");

                // Add more grant trupps in game set up before start
            }
        };
        gui.addActionListenerGrant(actionListGrunt);
    }

    private void addSpeedDemonActionList() {
        ActionListener actionListSpeedDemon = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Speed demon button is pressed");

                // Add more speed demon trupps in game set up before start
            }
        };
        gui.addActionListenerSpeed(actionListSpeedDemon);
    }


}
