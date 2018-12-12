package oscarTest;

import Main.DropDownMenu;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(GamePanel gamePanel,
                  MenuPanel menuPanel, FlipperPanel flipperPanel) {

        add(menuPanel, BorderLayout.EAST);
        setJMenuBar(new DropDownMenu());
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(gamePanel,Integer.valueOf(1));
        layeredPane.add(flipperPanel,Integer.valueOf(2));
        layeredPane.setPreferredSize(new Dimension(700,700));
        //layeredPane.add(flipperPanel, Integer.valueOf(2));
        add(layeredPane);
        //add(gamePanel, BorderLayout.CENTER);
        //add(flipperPanel);
        setPreferredSize(new Dimension(900,800));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public void showWindow() {
        setVisible(true);
    }
}
