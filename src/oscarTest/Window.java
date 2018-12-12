package oscarTest;
import Main.UserNameDialog;
import Main.DropDownMenu;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    MenuPanel mp;

    public Window(GamePanel gamePanel,
                  MenuPanel menuPanel, FlipperPanel flipperPanel,
                  DropDownMenu dropdown) {
        mp = menuPanel;
        add(menuPanel, BorderLayout.EAST);
        setJMenuBar(dropdown);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(gamePanel,Integer.valueOf(1));
        layeredPane.add(flipperPanel,Integer.valueOf(2));

        layeredPane.setPreferredSize(new Dimension(700,700));
        add(layeredPane);

        setPreferredSize(new Dimension(900,800));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public void showWindow() {
        setVisible(true);
    }

    public void userNameDialog(){

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                UserNameDialog und = new UserNameDialog();
                String name = und.getUserNameInput();
                // put user in database
                mp.setUserName(name);
                //myLabel.setText("Processing");
                //Do the job
                //myLabel.setText("Processed");
            }
        });
        t.start();

    }

    /*public void runSetUserName(String name){
        mp.setUserName(name);
    }*/

    public JPanel getMenuPanel(){
        return mp;
    }
}
