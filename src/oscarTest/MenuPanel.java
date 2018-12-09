package oscarTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    public MenuPanel(ActionListener startButtonPressed,
                     ActionListener pausPressed, ActionListener addCreature1,
                     ActionListener addCreature2) {
        setLayout(new GridLayout(4,0));
        setPreferredSize(new Dimension(200,100));
        setBackground(Color.blue);
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
    }
}
