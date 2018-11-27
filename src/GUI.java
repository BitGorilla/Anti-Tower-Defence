import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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


    public GUI(String title){

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500, 1000));

        // Build panels
        JPanel upperPanel = buildMenu();
        JPanel gamePanel = buildGamePanel();
        JPanel userPanel = buildUserPanel();

        //Add panels to the frame
        frame.add(upperPanel);
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
     * Components of the middle panel
     *      - Game panel
     * @return JPanel
     */
    private JPanel buildGamePanel() {

        JPanel gamePanel = new JPanel();

        //Put every image from xml in a table in background?

        return gamePanel;
    }

    /**
     * Components of the lower panel
     *      - User panel
     * @return JPanel
     */
    private JPanel buildUserPanel() {

        JPanel userPanel = new JPanel();

        //Put every image from xml in a table in background?

        return userPanel;
    }


}

