package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a dialog window to display game instructions.
 *
 * @author id15msd
 * @since 2018-12-13
 */
public class HelpDialog {

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
                        "<p>The goal of the game is to get creatures to " +
                "the end of the path with as much HP as possible. The " +
                "towers along the path will shoot the creatures and you " +
                "will have to get a certain amount of HP across the " +
                "finish line to continue to the next level!</p>" +
                "<p>To spawn creatures, press one of the creature buttons " +
                "on the right side of the game window.</p>" +
                "<p>A Portal creature can  spawn a portal on its position " +
                "by pressing the spawn portal button while a portal creature" +
                " is on the path. The next portal will be placed " +
                "automatically after a fixed period of time." +
                " The portal becomes a shortcut for all creatures.</p><br>" +
                "<b>Some path tiles are different:</b><br>" +
                "<p>On some tiles places, creatures move slower or faster. " +
                "There are also tiles where you can change the path the" +
                "creatures are taking by pressing on the tile.</p>" +
                "<b>If you win:</b><br>" +
                "<p>Write your username to place your score among other " +
                "users! You'll find all high scores in the info tab!</p>";

        textArea.setText(s);
        jdialog.add(textArea);
        jdialog.pack();
        jdialog.setVisible(true);

    }

}
