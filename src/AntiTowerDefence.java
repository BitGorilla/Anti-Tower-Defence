import formatters.XMLReader;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Linnea on 2018-11-27.
 */



//Ska byta namn till AntiTD när vi gör Jar-filen


public class AntiTowerDefence {

    public static void main( String[] args ) throws IOException {

        XMLReader reader = new XMLReader();
        reader.setSource(new FileInputStream("MapFormat2.xml"));
        while (reader.hasNext()){
            reader.next();
        }

        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(reader.getHeightAndWidth(),"Anti Tower Defence Game");
            gui.show();

            new Controller(gui);
        });

    }

}
