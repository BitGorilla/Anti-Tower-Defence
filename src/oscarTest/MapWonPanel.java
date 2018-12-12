package oscarTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapWonPanel {
    public MapWonPanel() {

    }

    public String show(ActionListener nextLevel, ActionListener restartLevel) {
        String option = new String();

        JLabel text = new JLabel();

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
                option = "play again";
                nextLevel.actionPerformed(new ActionEvent(this,
                        ActionEvent.ACTION_PERFORMED, null));
                break;
            case 1:
                option = "next level";
                restartLevel.actionPerformed(new ActionEvent(this,
                        ActionEvent.ACTION_PERFORMED, null));
                break;
        }
        return option;
    }
}
