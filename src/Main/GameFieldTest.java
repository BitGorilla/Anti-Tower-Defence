package Main;
import formatters.Animator;

import javax.swing.*;
import java.awt.*;

public class GameFieldTest {

    JFrame frame;
    JPanel panel;

    public GameFieldTest(int windowWidth){
        frame = new JFrame("Test");
        frame.setPreferredSize(new Dimension(windowWidth, windowWidth));
    }

    public void setAnimator(Animator a){
        frame.add(a);
        frame.pack();
    }

    public void show(){
        frame.setVisible(true);
    }


}
