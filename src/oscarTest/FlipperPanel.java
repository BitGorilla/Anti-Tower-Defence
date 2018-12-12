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
    private int buttonWidth;
    ActionListener flipperPressed;

    public FlipperPanel(ArrayList<Position> positions,
                        ActionListener flipperPressed, int panelWidth, int buttonWidth) {
        this.flipperPressed = flipperPressed;
        this.buttonWidth = buttonWidth;
        this.positions = positions;
        setBounds(0,0,panelWidth,panelWidth);
        setPreferredSize(new Dimension(panelWidth, panelWidth));
        setOpaque(false);
        setLayout(null);
        setButtons();
    }

    private void setButtons() {
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
            flipperButtons.add(flipperButton);
        }
    }

    public void updateFlippers(ArrayList<Position> positions) {
        for (JButton flipper  : flipperButtons ) {
            this.remove(flipper);
        }
        flipperButtons = new ArrayList<>();
        this.positions = positions;
        setButtons();
    }
}
