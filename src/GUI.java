import com.sun.javaws.jnl.XMLFormat;
import formatters.XMLReader;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Created by Linnea on 2018-11-27.
 */
public class GUI {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JPanel upperPanel;
    private JPanel gamePanel;
    private JPanel userPanel;
    private int rows;
    private int cols;
    private int nr;
    private JButton switchButton;
    private JButton gruntButton;
    private JButton speedDemonButton;


    public GUI(int nr, String title){

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500, 1000));

        this.nr = nr;

        // Build panels
        JPanel upperPanel = buildMenu();
        JPanel gamePanel = buildGamePanel(nr);
        JPanel userPanel = buildUserPanel();

        //Add panels to the frame
        frame.add(upperPanel);
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(userPanel, BorderLayout.WEST);

        showWinningDialog();


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
     * Components of the middle panel
     *      - Game panel
     * @return JPanel
     */
    private JPanel buildGamePanel(int nr) {

        JPanel gamePanel = new JPanel();

        this.rows = nr;
        this.cols = nr;


        JTable gameTable = new JTable(rows, cols);
        //JTable gameTable = new JTable();
        //gameTable.setRowHeight(nr);

        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream
                    ("./images/StarCreature.png"));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            gamePanel.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }


        DefaultTableModel dtm = (DefaultTableModel) gameTable.getModel();

        String img2 = "./images/StarCreature.png";

        //adding data into new row of table
        //dtm.addRow(img2, img2, img2);

        //using custom renderer in column 1 (column where image should be put)
        gameTable.getColumnModel().getColumn(1).setCellRenderer(new
                ImageRenderer());

        gamePanel.add(gameTable);

        return gamePanel;
    }

    /**
     * Components of the lower panel
     *      - User panel
     * @return JPanel
     */
    private JPanel buildUserPanel() {

        JPanel userPanel = new JPanel();

        switchButton = new JButton("Switch path");
        userPanel.add(switchButton);

        gruntButton = new JButton("Add more grant trupps");
        userPanel.add(gruntButton);

        speedDemonButton = new JButton("Add more grant trupps");
        userPanel.add(speedDemonButton);

        return userPanel;
    }


    public void addActionListenerSwitch(ActionListener actionListSwitchPath){
        switchButton.addActionListener(actionListSwitchPath);
    }

    public void addActionListenerGrant(ActionListener actionListAddGrant){
        gruntButton.addActionListener(actionListAddGrant);
    }

    public void addActionListenerSpeed(ActionListener actionListAddSpeedDemon){
        speedDemonButton.addActionListener(actionListAddSpeedDemon);
    }


    // You won dialog window

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


    }

}

