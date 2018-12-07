package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Linnea on 2018-12-07.
 */
public class Controller {

    private GUI gui;
    //private GameManager gameM;

    public Controller(){
        createGUI();
        createGameManager();
        //addGrantActionList(gui);
    }

    public void createGUI(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GUI("Anti Tower Defence");
                addSpeedDemonActionList();
                addGrantActionList();
                gui.show();
            }
        });
    }

    public void createGameManager(){

    }

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
