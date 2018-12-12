package Main;


import formatters.Animator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class GUI {

    public JFrame frame;
    private JPanel gamePanel;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private String levelName;
    public JLabel userName;
    private String username;
    private JButton inputButton;
    private JButton gruntButton;
    private JButton speedDemonButton;
    private int windowWidth;


    public GUI(String title, int windowWidth) {

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500, 1000));
        //levelName = setLevelName();
        levelName = "levelname";
        this.windowWidth = windowWidth;

        // Build panels
//        JPanel upperPanel = buildMenu();
        JPanel levelPanel = buildLevelPanel();
        gamePanel = buildGamePanel();
        JPanel userPanel = buildUserPanel();


        //Add panels to the frame
        //frame.add(upperPanel);
        frame.add(levelPanel, BorderLayout.NORTH);
        frame.add(userPanel, BorderLayout.EAST);

        frame.add(gamePanel, BorderLayout.CENTER);

        //showWinningDialog();

        frame.pack();

    }

    //Should only be called on EDT
    public void show() {
        frame.setVisible(true);
    }


    /**
     * Components of the upper panel
     * - Menu bar
     *
     * @return JPanel
     */
/*    private JPanel buildMenu() {

        JPanel upperPanel = new JPanel();
       // DropDownMenu ddMeny = new DropDownMenu();

        upperPanel.add(ddMeny);
        frame.setJMenuBar(ddMeny);

        return upperPanel;
    }*/

    /**
     * Components of the center panel
     * - Game panel
     *
     * @return JPanel
     */
    private JPanel buildLevelPanel() {

        JPanel levelPanel = new JPanel();
        JLabel jlabel = new JLabel(levelName);
        jlabel.setFont(new Font("Verdana", 1, 20));
        levelPanel.add(jlabel);

        return levelPanel;
    }

    public void setLevelName(String name) {
        levelName = name;
    }

    public void setAnimator(Animator animator) {
        gamePanel.add(animator);
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.pack();
    }

    /**
     * Components of the middle panel
     * - Game panel, animator view
     *
     * @return JPanel
     */
    private JPanel buildGamePanel() {
        JPanel gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(windowWidth, windowWidth));
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        return gamePanel;
    }

    /**
     * Components of the panel to the right of game panel
     * - User panel with buttons
     *
     * @return JPanel
     */
    private JPanel buildUserPanel() {

        JPanel userPanel = new JPanel();
        userPanel.setBounds(61, 11, 81, 140);
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));

        userName = new JLabel("User Name");
        userName.setFont(new Font("Verdana", 1, 20));
        userPanel.add(userName);

        JTextField userInput = new JTextField("Type in your user name");
        inputButton = new JButton("Send");
        userPanel.add(userInput, BorderLayout.SOUTH);
        userPanel.add(inputButton, BorderLayout.WEST);

        JLabel credits = new JLabel(Integer.toString(setCredits(1000)));
        credits.setFont(new Font("Verdana", 1, 20));
        userPanel.add(credits);

        gruntButton = new JButton("Add more grant trupps");
        userPanel.add(gruntButton);

        speedDemonButton = new JButton("Add more grant trupps");
        userPanel.add(speedDemonButton);

        return userPanel;
    }

    public int setCredits(int credits) {
        return credits;
    }

    public void addActionListenerUsernameInput(ActionListener
                                                       actionListUsername) {
        inputButton.addActionListener(actionListUsername);
    }

    public void addActionListenerGrant(ActionListener actionListAddGrant) {
        gruntButton.addActionListener(actionListAddGrant);
    }

    public void addActionListenerSpeed(ActionListener actionListAddSpeedDemon) {
        speedDemonButton.addActionListener(actionListAddSpeedDemon);
    }


    public void showWinningDialog() {

        Object[] options = {"Play this level again",
                "Continue to next level"};
        int n = JOptionPane.showOptionDialog(frame,
                "You won against the towers!",
                "Congratzzzzz",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title

        UIManager.put("JOptionPane.minimumSize", new Dimension(1000, 1000));
    }


    public String userNameDialog() {

        JTextField textField = new JTextField(10);

        String btnString1 = "Save";
        String btnString2 = "Cancel";

        //Create an array of the text and components to be displayed.
        String msgString1 = "Type your username:";
        Object[] array = {msgString1, textField};
        //Create an array specifying the number of dialog buttons
        //and their text.
        Object[] options = {btnString1, btnString2};

        int result = JOptionPane.showOptionDialog(null, array, "Please choose" +
                        " a username",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("./TestImages/cross-esw-slow.png"),
                options,
                options[0]);
        switch (result) {
            case 0:
                username = textField.getText();
                System.out.println("Save to database");
                System.out.println(username);
                break;
            case 1:
                System.out.println("cancel");
                break;
        }
        return username;
    }

    public void setUserName(String username) {
        userName.setText(username);
    }

    public String winnerDialog() {
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
        Object[] options = {btnString1, btnString2};

        int result = JOptionPane.showOptionDialog(null, array,
                "Congratulations!",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("./TestImages/cross-esw-slow.png"),
                options,
                options[0]);
        switch (result) {
            case 0:
                //System.out.println("Play again");
                option = "play again";
                break;
            case 1:
                //System.out.println("cancel");
                option = "next level";
                break;

        }
        return option;
    }

    public String loserDialog() {
        String option = new String();

        String btnString1 = "Play this level again";
        String btnString2 = "Close game";

        //Create an array of the text and components to be displayed.
        String msgString = "Oh no! You lose against the towers!\n" +
                "Choose one option:";
        Object[] array = {msgString};
        //Create an array specifying the number of dialog buttons
        //and their text.
        Object[] options = {btnString1, btnString2};

        int result = JOptionPane.showOptionDialog(null, array, "You lost",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                new ImageIcon("./TestImages/cross-esw-slow.png"),
                options,
                options[0]);
        switch (result) {
            case 0:
                //System.out.println("Play again");
                option = "play again";
                break;
            case 1:
                //System.out.println("cancel");
                option = "Close game";
                break;

        }
        return option;
    }

    public void aboutDialog() {

        //Create an array of the text and components to be displayed.
        String msgString = "Oh no! You lose against the towers!\n" +
                "Choose one option:";
        Object[] array = {msgString};

        JOptionPane.showInternalMessageDialog(null, array,
                "About the game", JOptionPane.INFORMATION_MESSAGE);

    }
}



