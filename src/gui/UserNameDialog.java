package gui;

import javax.swing.*;

/**
 * @author id15lbn, id15msd
 */
public class UserNameDialog {

    String username;

    public UserNameDialog() {

        JTextField textField = new JTextField(10);

        String btnString1 = "Save";
        String btnString2 = "Cancel";

        //Create an array of the text and components to be displayed.
        String msgString1 = "Enter your username:";
        Object[] array = {msgString1, textField};
        //Create an array specifying the number of dialog buttons
        //and their text.
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
                System.out.println("cancel");
                break;
        }

    }

    public String getUserNameInput(){
        return username;
    }
}