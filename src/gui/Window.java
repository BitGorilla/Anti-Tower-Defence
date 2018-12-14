package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {
    JLayeredPane layeredPane = new JLayeredPane();
    MapWonPanel mapWonPanel;
    ActionListener nextLevel;
    ActionListener restartLevel;
    ActionListener restartGame;
    ActionListener quit;

    public Window(int gamePanelWidth,
                  GamePanel gamePanel,
                  MenuPanel menuPanel, FlipperPanel flipperPanel,
                  ActionListener nextLevel, ActionListener restartLevel,
                  ActionListener restartGameLoserPressed, ActionListener
                          quitPressed) {
        this.nextLevel = nextLevel;
        this.restartLevel = restartLevel;
        this.restartGame = restartGameLoserPressed;
        this.quit =  quitPressed;
        add(menuPanel, BorderLayout.EAST);
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

    public void showLoserDialog() {
        LoserDialog loserDialog = new LoserDialog();
        loserDialog.show(restartGame, quit);
    }

    public void showHighscoreDialog(ArrayList<String[]> scores){
        new HighscoreDialog(scores);
    }

    public void updateDropDown(DropDownMenu dropDownMenu) {
        setJMenuBar(dropDownMenu);
    }
}

