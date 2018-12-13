package Main;

import formatters.Animator;
import formatters.XMLReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controller2 {
    /*

    private GUI gui;
    private GameManager gameM;
    private String levelName;
    private int windowWidth;
    private XMLReader reader;
    private ArrayList<Map> maps;
    private Animator animator;

    public Controller2(){
        createGUI();
        this.reader = createXMLReader();
        //this.maps = reader.buildMaps();
        //this.gameM = createGameManager(maps);
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
                gui = new GUI("Anti Tower Defence", windowWidth);
                addActionListenerUsernameInput(gui.userName.getText());
                addSpeedDemonActionList();
                addGrantActionList();
                gui.setAnimator(animator);
                gui.show();
            }
        });
    }

    public XMLReader createXMLReader(){
        XMLReader reader = new XMLReader(windowWidth);
        return reader;
    }

    /*public GameManager createGameManager(ArrayList<Map> maps){
        GameManager gm = new GameManager(maps, tickRate);
        return gm;
    }*/

    /*
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

    /*

    private void addActionListenerUsernameInput(String userInput){
        ActionListener actionListUsername = (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = userInput;
                //Put username in database
                // Set the userName Label to username
                gui.userName.setText(data);
            }
        });
    }

    private void addGrantActionList() {
        ActionListener actionListGrunt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gameM.getCurrentGameInstance().addCreature(2);

                // Add more grants
            }
        };
        gui.addActionListenerGrant(actionListGrunt);
    }

    private void addSpeedDemonActionList() {
        ActionListener actionListSpeedDemon = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Speed demon button is pressed");

                // Add more speed demons
            }
        };
        gui.addActionListenerSpeed(actionListSpeedDemon);
    }

*/
}

