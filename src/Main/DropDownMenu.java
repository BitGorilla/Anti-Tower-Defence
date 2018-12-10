package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Linnea on 2018-12-10.
 */
public class DropDownMenu extends JMenuBar{

    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;

    public DropDownMenu(){

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


    }

    public JMenuBar getMenyBar(){
        return menuBar;
    }


}
