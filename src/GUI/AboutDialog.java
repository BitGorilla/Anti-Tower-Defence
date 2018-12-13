package GUI;
import javax.swing.*;
import java.awt.*;


public class AboutDialog {

            //this.getContentPane().setLayout(new FlowLayout());
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
