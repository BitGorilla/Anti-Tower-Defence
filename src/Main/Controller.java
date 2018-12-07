package Main;

import javax.swing.*;

/**
 * Created by Linnea on 2018-12-07.
 */
public class Controller {

    private GUI gui;
    //private GameManager gameM;

    public Controller(){
        createGUI();
        createGameManager();
    }

    public void createGUI(){

        SwingUtilities.invokeLater(() -> {
            gui = new Main.GUI("Anti Defence Game");
            gui.show();
        });

    }

    public void createGameManager(){

    }


}
