package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the dialog that is shown when a user fail a level. It
 * contains a text that says that it is Game Over and gives the user the
 * options to restart the game from the first level or quit the game.
 * @author id15lbn
 * @since 2018-12-13
 */
public class LoserDialog {

    public LoserDialog() {
    }

    public String show(ActionListener restartGame, ActionListener quitPressed) {
        String option = new String();

        JLabel text = new JLabel();

        String btnString1 = "Restart game";
        String btnString2 = "Quit game";

        String msgString = "Game Over!\n" + "Choose one option:";
        Object[] array = {msgString};
        Object[] options = {btnString1, btnString2};

        int result = JOptionPane.showOptionDialog(null, array,
                "GAME OVER",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("./TestImages/cross-esw-slow.png"),
                options,
                options[0]);
        switch (result) {
            case 0:
                option = "Restart game";
                restartGame.actionPerformed(new ActionEvent(this,
                        ActionEvent.ACTION_PERFORMED, null));
                break;
            case 1:
                option = "Quit game";
                quitPressed.actionPerformed(new ActionEvent(this,
                        ActionEvent.ACTION_PERFORMED, null));
                break;
        }
        return option;

    }
}
