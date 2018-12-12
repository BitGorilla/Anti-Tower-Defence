package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Linnea on 2018-12-12.
 */
public class HighscoreDialog {

    public HighscoreDialog(ArrayList<String[]> highscore ){

        int ROWS = 10;

        Object[][] data = {{ highscore }};
        Object[] columnNames = { "User name", "Map name", "Score" };
        final JTable table = new JTable(data, columnNames) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                Dimension d = getPreferredSize();
                int n = getRowHeight();
                return new Dimension(d.width, (n * ROWS));
            }
        };

        JPanel jPanel = new JPanel();
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
