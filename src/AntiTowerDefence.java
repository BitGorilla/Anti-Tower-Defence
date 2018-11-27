import javax.swing.*;

/**
 * Created by Linnea on 2018-11-27.
 */
public class AntiTowerDefence {

    public static void main( String[] args ) {

        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI("Anti Tower Defence Game");
            gui.show();

            //new TestController(gui);
        });

        //new TestController();

    }

}
