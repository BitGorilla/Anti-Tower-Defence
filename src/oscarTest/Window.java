package oscarTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    public Window(GamePanel gamePanel,
                  MenuPanel menuPanel) {
        add(gamePanel, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.EAST);
        setPreferredSize(new Dimension(900,700));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public void showWindow() {
        setVisible(true);
    }
}
