package Main;

import formatters.Animator;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Linnea on 2018-12-09.
 */
public class ControllerGUI {

    //private Animator ani = new Animator(ArrayList);
    private GUI gui;
    private int windowWidth;


    public ControllerGUI(){
        windowWidth = 400;
        createGUI();

    }

    public void createGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GUI("Anti Tower Defence", windowWidth);
                //gui.setAnimator(ani);
                gui.show();

                String test = getUserName();
                //System.out.println(test);
                setUserNameInGUI(test);
                System.out.println(gui.winnerDialog());
            }
        });
    }

    private String getUserName(){
        String usern = gui.userNameDialog();
        //Run sql script
        return usern;
    }

    private void setUserNameInGUI(String username){
        gui.setUserName(username);
    }

    private void showWinnerDialog(){
        gui.winnerDialog();
    }
}
