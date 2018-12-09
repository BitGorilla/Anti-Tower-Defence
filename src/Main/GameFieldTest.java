package Main;
import formatters.Animator;

import javax.swing.*;
import java.awt.*;

public class GameFieldTest {

    JFrame frame;
    JPanel panel;

    public GameFieldTest(int windowWidth){
        frame = new JFrame("Test");
        frame.setPreferredSize(new Dimension(windowWidth,windowWidth));


        //panel = new JPanel();
        //panel.setSize(100, 100);

        //frame.add(panel, BorderLayout.CENTER);
    }

    public void setAnimator(Animator a){
        frame.add(a);
        frame.pack();
    }

    public void show(){
        frame.setVisible(true);
    }


}
