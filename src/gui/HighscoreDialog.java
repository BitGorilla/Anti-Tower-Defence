package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * This class is the dialog that shows the high score list from the database
 * in a JTable.
 * @author id15lbn, id15msd
 * @since 2018-12-10
 */
public class HighscoreDialog {
    private final int ROWS = 10;

    public HighscoreDialog(ArrayList<String[]> highscore){

        String[][] scores = new String[highscore.size()][3];
        int i = 0;
        for (String[] s: highscore) {
            scores[i] = s;
            i++;
        }

        Object[] columnNames = { "User name", "Map name", "Score" };
        final JTable table = new JTable(scores, columnNames) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                Dimension d = getPreferredSize();
                int n = getRowHeight();
                return new Dimension(d.width, (n * ROWS));
            }
        };

        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(400,400));
        jPanel.setLayout(new GridLayout());
        JScrollPane sp = new JScrollPane(table);
        jPanel.add(sp);
        JDialog jdialog = new JDialog();
        jdialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jdialog.setContentPane(jPanel);

        jdialog.pack();
        jdialog.setVisible(true);


    }


}