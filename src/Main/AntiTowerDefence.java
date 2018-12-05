package Main;

import formatters.XMLReader;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Linnea on 2018-11-27.
 */
public class AntiTowerDefence {

    public static void main( String[] args ) throws IOException {

        XMLReader reader = new XMLReader();
        reader.setSource(new FileInputStream("MapFormat2.xml"));
        while (reader.hasNext()){
            reader.next();
        }

        /*SwingUtilities.invokeLater(() -> {
            Main.GUI gui = new Main.GUI("Anti  Defence Game");
            gui.show();

            //new TestController(gui);
        });*/

        //new TestController();

    }

}
