package oscarTest;

import Main.Position;

import javax.swing.*;

public class FlipperButton extends JButton {
    Position pos;

    public FlipperButton(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }
}
