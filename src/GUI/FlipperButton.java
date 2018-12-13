package GUI;

import Main.Position;

import javax.swing.*;

public class FlipperButton extends JButton {
    Position pos;

    public FlipperButton(Position pos) {
        this.pos = pos;
        this.setToolTipText("FLIP ME");
    }

    public Position getPos() {
        return pos;
    }
}
