package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Linnea on 2018-12-10.
 */
public class DropDownMenu extends JMenuBar{

    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private ActionListener pausPressed;
    private ActionListener startPressed;
    private JMenuItem pausStart = new JMenuItem();
    private boolean paus;

    public DropDownMenu(ActionListener restartGame,
                        ActionListener pausPressed,
                        ActionListener startPressed,
                        ActionListener quitPressed,
                        ActionListener highcorePressed) {
        this.pausPressed = pausPressed;
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

        pausStart = new JMenuItem("Start");
        pausStart.addActionListener(startPressed);
        menu1.add(pausStart);
        paus = false;

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

    public void changePausStart() {
        if(paus) {
            pausStart.removeActionListener(pausPressed);
            pausStart.setText("Start");
            pausStart.addActionListener(startPressed);
            paus = false;
        } else {
            pausStart.removeActionListener(startPressed);
            pausStart.setText("Pause");
            pausStart.addActionListener(pausPressed);
            paus = true;
        }
    }
}
