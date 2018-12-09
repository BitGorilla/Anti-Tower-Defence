package Main;
import formatters.Animator;

import javax.swing.*;
import java.awt.*;

public class GameFieldTest {

    JFrame frame;
    JPanel panel;

    public GameFieldTest(){
        frame = new JFrame("Test");
        frame.setSize(300, 300);
        panel = new JPanel();
        panel.setSize(100, 100);

        frame.add(panel, BorderLayout.CENTER);
    }

    public void getAnimator(Animator a){
        panel.add(a);
    }

    public void show(){
        frame.setVisible(true);
    }


}
