package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    JLabel creditLabel = new JLabel();

    public MenuPanel(ActionListener addCreature1, ActionListener addCreature2,
                     ActionListener addCreature3, ActionListener placePortal) {
        setLayout(new GridLayout(3,0));
        setPreferredSize(new Dimension(200,700));
        JLabel creditLabel = new JLabel();
        creditLabel.setHorizontalTextPosition(JLabel.CENTER);
        updateCredits(1);

        JButton creature1 = new JButton();
        creature1.setText("Speed Demon");
        creature1.addActionListener(addCreature1);
        add(creature1);

        JButton creature2 = new JButton();
        creature2.setText("Grunt");
        creature2.addActionListener(addCreature2);
        add(creature2);

        JButton creature3 = new JButton();
        creature3.setText("Summon Portalus");
        creature3.addActionListener(addCreature3);
        creature3.setToolTipText("Our lord and saviour");
        add(creature3);

        JButton portal = new JButton();
        portal.setText("Portal");
        portal.addActionListener(placePortal);
        add(portal);
    }

    public void updateCredits(int credit) {
        creditLabel.setText(Integer.toString(credit));
        add(creditLabel);
    }
}
