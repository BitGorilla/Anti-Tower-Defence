package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a dialog window to display game instructions.
 *
 * @author id15msd
 */
public class HelpDialog {
    private final int ROWS = 10;

    /**
     * Constructor of class.
     * Creates a JDialog and JEditorPane which game instructions are added to.
     */
    public HelpDialog() {
        JDialog jdialog = new JDialog();
        jdialog.setPreferredSize(new Dimension(500,500));
        JEditorPane textArea = new JEditorPane("text/html", "");
        textArea.setEditable(false);

        String s = "<h1>How to play</h1>"+
                        "<p>The goal of the game is to get ten(10) creatures " +
                "to the end of the path by not getting eliminated by the " +
                "towers that shoot lasers.</p>" +
                "<p>To spawn creatures, press one of the creature buttons " +
                "on the right side of the game window.</p>" +
                "<p>A Portal creature can  spawn a portal on its position " +
                "by pressing the spawn portal button while a portal creature" +
                " is on the path. The portal becomes a shortcut for all " +
                "creatures.</p><br>" +
                "<b>Some path tiles are different:</b><br>" +
                "<p>On some tiles places, creatues move slower or faster. " +
                "There are also tiles where you can change the path the" +
                "creatures are taking by pressing on the tile.</p>" +
                "<b>If you win:</b><br>" +
                "<p>Input your username to compare your score with other " +
                "users!</p>";

        textArea.setText(s);

        jdialog.add(textArea);

        jdialog.pack();
        jdialog.setVisible(true);

    }

}
