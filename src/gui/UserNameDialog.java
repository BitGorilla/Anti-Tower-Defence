package gui;

import javax.swing.*;

/**
 * UserNameDialog is the pop up dialog that is shown when a user have
 * finished all the levels and is ready to write in the username to save the
 * score in the database and hopefully be in the top of the high score list.
 * @author id15lbn, id15msd
 * @since 2018-12-10
 */
public class UserNameDialog {

    private String username;

    public UserNameDialog() {

        JTextField textField = new JTextField(10);

        String btnString1 = "Save";
        String btnString2 = "Cancel";

        String msgString1 = "Enter your username:";
        Object[] array = {msgString1, textField};
        Object[] options = {btnString1, btnString2};

        int result = JOptionPane.showOptionDialog(null, array, "VICTORY!",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("./TestImages/cross-esw-slow.png"),
                options,
                options[0]);
        switch (result) {
            case 0:
                username = textField.getText();
                break;
            case 1:
                username = "";
                break;
        }

    }

    /**
     * Returns the username that is written in the input field.
     * @return username
     */
    public String getUserNameInput(){
        return username;
    }
}