package GUI;

import Creatures.Grunt;
import Creatures.PortalusTotalus;
import Creatures.SpeedDemon;
import formatters.ImageLoader;
import sun.tools.jstat.Alignment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    JLabel creditLabel;
    JLabel scoreLabel;

    public MenuPanel(ActionListener addCreature1, ActionListener addCreature2,
                     ActionListener addCreature3, ActionListener placePortal) {
        setLayout(new GridLayout(8,0));
        GridBagConstraints c;
        setPreferredSize(new Dimension(200,700));

        Font f = new Font("Courier New", Font.PLAIN, 15);
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
                PortalusTotalus.COST + "<br>Speed: "+PortalusTotalus.SPEED+"<br>HP: "+
                PortalusTotalus.MAXHEALTH+"</html>");
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

    public void updateStats(int credit, int score) {
        creditLabel.setText("<html><b> " + "$$$: </b>" +Integer.toString(credit)+"</html>");
        add(creditLabel);

        scoreLabel.setText("<html><b> " + "Score: </b>" +Integer.toString(score)+
                "</html>");
        add(scoreLabel);
    }
}
