package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Linnea on 2018-12-13.
 */
public class LoserDialog {

    public LoserDialog() {
    }

    public String show(ActionListener restartGamePressed, ActionListener quitPressed) {
        String option = new String();

        JLabel text = new JLabel();

        String btnString1 = "Restart game";
        String btnString2 = "Quit game";

        //Create an array of the text and components to be displayed.
        String msgString = "Game Over!\n" +
                "Choose one option:";
        Object[] array = {msgString};
        //Create an array specifying the number of dialog buttons
        //and their text.
        Object[] options = {btnString1, btnString2};

        int result = JOptionPane.showOptionDialog(null, array,
                "Congratulations!",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("./TestImages/cross-esw-slow.png"),
                options,
                options[0]);
        switch (result) {
            case 0:
                option = "Restart game";
                restartGamePressed.actionPerformed(new ActionEvent(this,
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
