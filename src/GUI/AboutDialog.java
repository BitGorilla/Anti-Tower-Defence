package GUI;
import javax.swing.*;
import java.awt.*;

/**
 * A pop up dialog that is shown when the "About" button is pushed in the
 * drop down menu in the menubar in the gui window. The dialog contains a
 * short presentation about the game developers and the project.
 * @author id15lbn
 * @since 2018-12-13
 */
public class AboutDialog {


    public AboutDialog()
    {

        JDialog jdialog = new JDialog();
        jdialog.setPreferredSize(new Dimension(500,200));
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        textArea.append("About Us\n");
        textArea.append("This Anti Tower Defence game is the result of a " +
                "project \n");
        textArea.append("in the course Applikationsutveckling i Java at Umeå " +
                "university.\n");
        textArea.append("The game is build by Martin Sjölund, Oscar Heimdahl," +
                "\n" +
                "Jonathan Smedborn och Linnea Berggren.");

        jdialog.add(textArea);
        jdialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jdialog.pack();
        jdialog.setVisible(true);

    }
}
