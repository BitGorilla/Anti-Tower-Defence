package gui;

import creatures.Grunt;
import creatures.PortalusTotalus;
import creatures.SpeedDemon;
import formatters.ImageLoader;
//import sun.tools.jstat.Alignment;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * MenuPanel contains all the buttons in the qui window where the user can
 * add creatures or place portals to the game field. The panel have three
 * buttons for creatures Speed Demon, Grunt and Portalus Totalus and one for
 * placing portals. It also shows the amount of current credits and score
 * below the buttons.
 * @author
 * @since 2018-12-14
 */

public class MenuPanel extends JPanel {

    private JLabel creditLabel;
    private JLabel scoreLabel;

    public MenuPanel(ActionListener addCreature1, ActionListener addCreature2,
                     ActionListener addCreature3, ActionListener placePortal,
                     String name) {

        setLayout(new GridLayout(9,0));
        setPreferredSize(new Dimension(200,700));
        Font f = new Font("Courier New", Font.PLAIN, 15);
        Font f2 = new Font("Courier New", Font.PLAIN, 25);

        JLabel mapName = new JLabel(name,SwingConstants.CENTER);
        mapName.setFont(f2);
        add(mapName);

        JButton button = new JButton();
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(f);
        button.setText("<html><b>Speed Demon</b><br>Cost:  " +
                SpeedDemon.COST + "<br>Speed: "+SpeedDemon.SPEED+"<br>HP: "+
                SpeedDemon.MAXHEALTH+"</html>");
        button.setIcon(new ImageIcon(SpeedDemon.image));
        button.addActionListener(addCreature1);
        add(button);

        button = new JButton();
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(f);
        button.setText("<html><b>Grunt</b><br>Cost:  " +
                Grunt.COST + "<br>Speed: "+Grunt.SPEED+"<br>HP: "+
                Grunt.MAXHEALTH+"</html>");
        button.setIcon(new ImageIcon(Grunt.image));
        button.addActionListener(addCreature2);
        add(button);

        button = new JButton();
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(f);
        button.setText("<html><b>PortalusTotalus</b><br>Cost:  " +
                PortalusTotalus.COST + "<br>Speed: "+ PortalusTotalus.SPEED +
                "<br>HP: "+ PortalusTotalus.MAXHEALTH +"</html>");
        button.setIcon(new ImageIcon(PortalusTotalus.image));
        button.addActionListener(addCreature3);
        add(button);

        button = new JButton();
        button.setFont(f);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIcon(new ImageIcon(ImageLoader.getImageLoader().getImage(
                "portal.png")));
        button.setText("<html><b>Place Portal</b></html>");
        button.addActionListener(placePortal);
        add(button);

        creditLabel = new JLabel("",SwingConstants.CENTER);
        creditLabel.setFont(f);

        scoreLabel = new JLabel("",SwingConstants.CENTER);
        creditLabel.setFont(f);
    }

    /**
     * Update the credits and scores on the game window
     * @param credit current credit
     * @param score current score
     */
    public void updateStats(int credit, int score) {
        creditLabel.setText("<html><b> " + "$$$: </b>" +Integer.toString(credit)
                + "</html>");
        add(creditLabel);

        scoreLabel.setText("<html><b> " + "Score: </b>" +Integer.toString(score)
                + "</html>");
        add(scoreLabel);
    }
}
