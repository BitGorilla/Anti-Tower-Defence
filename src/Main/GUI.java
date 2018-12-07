package Main;

import formatters.Animator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class GUI {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private String levelName;
    private JButton gruntButton;
    private JButton speedDemonButton;



    public GUI(String title){

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500, 1000));
        //levelName = setLevelName();
        levelName = "levelname";

        // Build panels
        JPanel upperPanel = buildMenu();
        JPanel levelPanel = buildLevelPanel();
        JPanel gamePanel = buildGamePanel();
        JPanel userPanel = buildUserPanel();


        //Add panels to the frame
        frame.add(upperPanel);
        frame.add(levelPanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(userPanel, BorderLayout.EAST);

        frame.pack();

    }

    //Should only be called on EDT
    public void show() {
        frame.setVisible(true);
    }


    /**
     * Components of the upper panel
     *      - Menu bar
     * @return JPanel
     */
    private JPanel buildMenu() {

        JPanel upperPanel = new JPanel();

        menuBar = new JMenuBar();
        Font f = new Font("sans-serif", Font.PLAIN, 20);
        UIManager.put("Menu.font", f);

        //Build the first menu.
        menu1 = new JMenu("Game Menu");
        menu1.setMnemonic(KeyEvent.VK_A);
        menu1.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu1);

        //Group of JMenuItems in menu 1
        menuItem1 = new JMenuItem("New Game / Restart", KeyEvent.VK_T);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem1.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu1.add(menuItem1);

        menuItem1 = new JMenuItem("Level: X", KeyEvent.VK_T);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem1.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu1.add(menuItem1);

        menuItem1 = new JMenuItem("Pause / Resume", KeyEvent.VK_T);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem1.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu1.add(menuItem1);

        menuItem1 = new JMenuItem("Mute / Unmute", KeyEvent.VK_T);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem1.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu1.add(menuItem1);

        menuItem1 = new JMenuItem("Quit", KeyEvent.VK_T);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem1.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu1.add(menuItem1);


        //Build the second menu.
        menu2 = new JMenu("Info");
        menu2.setMnemonic(KeyEvent.VK_A);
        menu2.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu2);

        //Group of JMenuItems in menu 2
        menuItem2 = new JMenuItem("About",KeyEvent.VK_T);
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem2.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu2.add(menuItem2);

        menuItem2 = new JMenuItem("Help",KeyEvent.VK_T);
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem2.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu2.add(menuItem2);

        menuItem2 = new JMenuItem("High Score List",KeyEvent.VK_T);
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem2.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu2.add(menuItem2);

        frame.setJMenuBar(menuBar);

        return upperPanel;
    }

    /**
     * Components of the upper panel
     *      - Game panel
     * @return JPanel
     */
    private JPanel buildLevelPanel() {

        JPanel levelPanel = new JPanel();
        JLabel jlabel = new JLabel(levelName);
        jlabel.setFont(new Font("Verdana",1,20));
        levelPanel.add(jlabel);

        return levelPanel;
    }

    public void setLevelName(String name){
        levelName = name;
    }

    /**
     * Components of the middle panel
     *      - Game panel, animator view
     * @return JPanel
     */
    private JPanel buildGamePanel() {

        JPanel gamePanel = new JPanel();

        //Put every image from xml in a table in background
        //Animator

        return gamePanel;
    }

    /**
     * Components of the panel to the right of game panel
     *      - User panel with buttons
     * @return JPanel
     */
    private JPanel buildUserPanel() {

        JPanel userPanel = new JPanel();

        JLabel userName = new JLabel("User Name");
        userName.setFont(new Font("Verdana",1,20));
        userPanel.add(userName);

        JLabel credits = new JLabel(Integer.toString(setCredits(1000)));
        credits.setFont(new Font("Verdana",1,20));
        userPanel.add(credits);

        gruntButton = new JButton("Add more grant trupps");
        userPanel.add(gruntButton);

        speedDemonButton = new JButton("Add more grant trupps");
        userPanel.add(speedDemonButton);


        return userPanel;
    }

    public int setCredits(int credits){
        return credits;
    }

    public void addActionListenerGrant(ActionListener actionListAddGrant){
        gruntButton.addActionListener(actionListAddGrant);
    }

    public void addActionListenerSpeed(ActionListener actionListAddSpeedDemon){
        speedDemonButton.addActionListener(actionListAddSpeedDemon);
    }



}

