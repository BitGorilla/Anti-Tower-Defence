package GUI;

import Main.DropDownMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    JLayeredPane layeredPane = new JLayeredPane();
    MapWonPanel mapWonPanel;
    ActionListener nextLevel;
    ActionListener restartLevel;

    public Window(int gamePanelWidth, DropDownMenu dropDownMenu,
                  GamePanel gamePanel,
                  MenuPanel menuPanel, FlipperPanel flipperPanel,
                  ActionListener nextLevel) {
        this.nextLevel = nextLevel;
        add(menuPanel, BorderLayout.EAST);
        setJMenuBar(dropDownMenu);
        layeredPane.add(gamePanel,Integer.valueOf(1));
        layeredPane.add(flipperPanel,Integer.valueOf(2));

        layeredPane.setPreferredSize(new Dimension(gamePanelWidth,gamePanelWidth));
        add(layeredPane);

        setPreferredSize(new Dimension(gamePanelWidth+200,
                gamePanelWidth+ 40));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public void showWindow() {
        setVisible(true);
    }

    public void showMapWon() {
        mapWonPanel = new MapWonPanel();
        mapWonPanel.show(nextLevel, restartLevel);
    }
}