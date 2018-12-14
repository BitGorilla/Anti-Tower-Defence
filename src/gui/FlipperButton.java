package gui;

import gameLogic.Position;

import javax.swing.*;

/**
 * Flipper button is a button class for the tiles that have a flip path
 * functionality.
 * @author
 * @since 2018-12-10
 */

public class FlipperButton extends JButton {
    Position pos;

    public FlipperButton(Position pos) {
        this.pos = pos;
        this.setToolTipText("FLIP ME");
    }

    /**
     * Get the position of the button.
     * @return the buttons position
     */
    public Position getPos() {
        return pos;
    }
}
