package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Window is the main gui of ths game. It contains all the panels and shows
 * the different dialog pop ups when buttons is pushed in the drop down menu.
 * @author
 * @since
 */
public class Window extends JFrame {
    private JLayeredPane layeredPane = new JLayeredPane();
    private MapWonPanel mapWonPanel;
    private ActionListener nextLevel;
    private ActionListener restartLevel;
    private ActionListener restartGame;
    private ActionListener quit;

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

        layeredPane.setPreferredSize(new Dimension(gamePanelWidth,
                gamePanelWidth));
        add(layeredPane);

        setPreferredSize(new Dimension(gamePanelWidth+200,
                gamePanelWidth+ 40));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    /**
     * Shows the gui window by setting the JFrame visibility to true.
     */
    public void showWindow() {
        setVisible(true);
    }

    /**
     * Creates a new victory pop up and show it.
     */
    public void showMapWon() {
        mapWonPanel = new MapWonPanel();
        mapWonPanel.show(nextLevel, restartLevel);
    }

    /**
     * Creates a new loser pop up and show it.
     */
    public void showLoserDialog() {
        LoserDialog loserDialog = new LoserDialog();
        loserDialog.show(restartGame, quit);
    }

    /**
     * Creates a new high score pop up and show it.
     * @param scores the data from the database
     */
    public void showHighscoreDialog(ArrayList<String[]> scores){
        new HighscoreDialog(scores);
    }

    /**
     * Update the drop down menubar when the button title change from Start
     * to Pause or from Pause to Start.
     * @param dropDownMenu the menu at the top at the gui window
     */
    public void updateDropDown(DropDownMenu dropDownMenu) {
        setJMenuBar(dropDownMenu);
    }
}

