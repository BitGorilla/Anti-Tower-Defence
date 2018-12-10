package oscarTest;

import Main.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlipperPanel extends JPanel {

    private ArrayList<JButton> flipperButtons = new ArrayList<>();
    private ArrayList<Position> positions;
    private Image image = null;

    public FlipperPanel(ArrayList<Position> positions,
                        ActionListener flipperPressed, int panelWidth, int buttonWidth) {
        positions.get(0).print();
        this.positions = positions;
        setBounds(0,0,panelWidth,panelWidth);
        setPreferredSize(new Dimension(panelWidth, panelWidth));
        setOpaque(false);
        setLayout(null);
        setButtons(buttonWidth, flipperPressed);
    }

    private void setButtons(int buttonWidth, ActionListener flipperPressed) {
        FlipperButton flipperButton;
        Position pos;
        for (int i = 0; i < positions.size(); i++) {
            positions.get(i).print();
            flipperButton = new FlipperButton(positions.get(i));
            pos = new Position(positions.get(i).getX(),
                    positions.get(i).getY());
            pos.addVector(new Position(-buttonWidth/2,-buttonWidth/2));
            flipperButton.setBorder(null);
            flipperButton.setBounds(pos.getX(),pos.getY(),
                    buttonWidth, buttonWidth);
            flipperButton.addActionListener(flipperPressed);
            add(flipperButton);
        }
    }
}
