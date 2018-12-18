package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the dialog that is shown when a user fail a level. It
 * contains a text that says that it is Game Over and gives the user the
 * options to restart the game from the first level or quit the game.
 * @author id15lbn, oi16ohn
 * @since 2018-12-10
 */

public class MapWonPanel {

    /**
     * Constructor of class.
     */
    public MapWonPanel() {

    }

    /**
     * Creates and shows panel for when a map is won.
     *
     * @param nextLevel ActionListener for the button "Continue to next level".
     * @param restartLevel ActionListener for the button "PLay this level
     *                     again".
     */
    public void show(ActionListener nextLevel, ActionListener restartLevel) {

        String btnString1 = "Play this level again";
        String btnString2 = "Continue to next level";

        //Create an array of the text and components to be displayed.
        String msgString = "You won against the towers!\n" +
                "Choose one option:";
        Object[] array = {msgString};
        //Create an array specifying the number of dialog buttons
        //and their text.
        Object[] options = {btnString2, btnString1};

        int result = JOptionPane.showOptionDialog(null, array,
                "Congratulations!",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("./TestImages/cross-esw-slow.png"),
                options,
                options[0]);
        switch (result) {
            case 0:
                nextLevel.actionPerformed(new ActionEvent(this,
                        ActionEvent.ACTION_PERFORMED, null));
                break;
            case 1:
                restartLevel.actionPerformed(new ActionEvent(this,
                        ActionEvent.ACTION_PERFORMED, null));
                break;
        }
    }
}
