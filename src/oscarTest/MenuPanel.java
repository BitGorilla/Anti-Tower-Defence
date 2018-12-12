package oscarTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    JLabel creditLabel = new JLabel();
    JLabel userName = new JLabel();

    public MenuPanel(ActionListener startButtonPressed,
                     ActionListener pausPressed, ActionListener addCreature1,
                     ActionListener addCreature2, ActionListener addCreature3
            , ActionListener placePortal) {
        setLayout(new GridLayout(6,0));
        setPreferredSize(new Dimension(200,100));
        setBackground(Color.blue);

        JLabel creditLabel = new JLabel();
        creditLabel.setHorizontalTextPosition(JLabel.CENTER);
        creditLabel.setPreferredSize(new Dimension(100,30));
        updateCredits(1);

        JButton start = new JButton();
        start.setPreferredSize(new Dimension(100,30));
        start.setText("Start");
        start.addActionListener(startButtonPressed);
        add(start);

        JButton paus = new JButton();
        paus.setPreferredSize(new Dimension(100,100));
        paus.setText("Paus");
        paus.addActionListener(pausPressed);
        add(paus);

        JButton creature1 = new JButton();
        creature1.setPreferredSize(new Dimension(100,100));
        creature1.setText("Creature1");
        creature1.addActionListener(addCreature1);
        add(creature1);

        JButton creature2 = new JButton();
        creature2.setPreferredSize(new Dimension(100,100));
        creature2.setText("Creature2");
        creature2.addActionListener(addCreature2);
        add(creature2);

        userName = new JLabel("User Name");
        userName.setFont(new Font("Verdana", 1, 20));
        add(userName);

        JButton creature3 = new JButton();
        creature3.setPreferredSize(new Dimension(100,100));
        creature3.setText("Creature3");
        creature3.addActionListener(addCreature3);
        add(creature3);

        JButton portal = new JButton();
        portal.setPreferredSize(new Dimension(100,100));
        portal.setText("Creature3");
        portal.addActionListener(placePortal);
        add(portal);
    }

    public void setUserName(String username) {
        userName.setText(username);
        add(userName);
    }


    public void updateCredits(int credit) {
        creditLabel.setText(Integer.toString(credit));
        add(creditLabel);
    }
}
