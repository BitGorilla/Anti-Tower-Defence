package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Drop down menu is the menu at the top of the gui window. It contains to
 * menus, the first contains Restart, Start/Pause and Quit and the second
 * contains About the game, Help instructions and High score list that shows
 * the high score from the database.
 * @author id15lbn, oi16ohn
 * @since 2018-12-10
 */
public class DropDownMenu extends JMenuBar{

    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private ActionListener pausePressed;
    private ActionListener startPressed;
    private JMenuItem pauseStart = new JMenuItem();
    private boolean pause;

    /**
     * Constructor of class. Creates the dropdown menu.
     *
     * @param restartGame ActionListener for the button "Restart Game".
     * @param pausePressed ActionListener for the button "Pause".
     * @param startPressed ActionListener for the button "Start".
     * @param quitPressed ActionListener for the button "Quit".
     * @param highcorePressed ActionListener for the button "High Score List".
     */
    public DropDownMenu(ActionListener restartGame,
                        ActionListener pausePressed,
                        ActionListener startPressed,
                        ActionListener quitPressed,
                        ActionListener highcorePressed) {
        this.pausePressed = pausePressed;
        this.startPressed = startPressed;
        Font f = new Font("sans-serif", Font.PLAIN, 15);
        UIManager.put("Menu.font", f);

        //Build the first menu.
        menu1 = new JMenu("Game Menu");
        menu1.setMnemonic(KeyEvent.VK_A);
        getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        add(menu1);

        //Group of JMenuItems in menu 1
        menuItem1 = new JMenuItem("Restart");
        menuItem1.addActionListener(restartGame);
        menu1.add(menuItem1);

        pauseStart = new JMenuItem("Start");
        pauseStart.addActionListener(startPressed);
        menu1.add(pauseStart);
        pause = false;

        menuItem1 = new JMenuItem("Quit");
        menuItem1.addActionListener(quitPressed);
        menu1.add(menuItem1);

        //Build the second menu.
        menu2 = new JMenu("Info");
        add(menu2);

        //Group of JMenuItems in menu 2
        menuItem2 = new JMenuItem("About",KeyEvent.VK_T);
        menuItem2.addActionListener(e -> new AboutDialog());
        menu2.add(menuItem2);

        menuItem2 = new JMenuItem("Help",KeyEvent.VK_T);
        menuItem2.addActionListener(e -> new HelpDialog());
        menu2.add(menuItem2);

        menuItem2 = new JMenuItem("High Score List",KeyEvent.VK_T);
        menuItem2.addActionListener(highcorePressed);
        menu2.add(menuItem2);
    }

    /**
     * Change the the text in the drop down when pushing the button.
     * From Start to Pause or from Pause to Start.
     */
    public void changePausStart() {
        if(pause) {
            pauseStart.removeActionListener(pausePressed);
            pauseStart.setText("Start");
            pauseStart.addActionListener(startPressed);
            pause = false;
        } else {
            pauseStart.removeActionListener(startPressed);
            pauseStart.setText("Pause");
            pauseStart.addActionListener(pausePressed);
            pause = true;
        }
    }
}
