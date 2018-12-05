import formatters.XMLReader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {

    private GUI gui;
    //private GameManager model;

    //GameManager model ska in i controllen också
    public Controller(GUI gui){

        this.gui = gui;

        addSwitchActonList(gui);

        addGrantActionList(gui);

        addSpeedDemonActionList(gui);




    }

    private void addSwitchActonList(GUI gui) {
        ActionListener actionListSwitchPath = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Switch button is pressed");

                // switch path logic in model and put new path to gui
            }
        };
        gui.addActionListenerSwitch(actionListSwitchPath);
    }

    private void addGrantActionList(GUI gui) {
        ActionListener actionListSwitchPath = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Grant button is pressed");

                // Add more grant trupps in game set up before start
            }
        };
        gui.addActionListenerGrant(actionListSwitchPath);
    }

    private void addSpeedDemonActionList(GUI gui) {
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
