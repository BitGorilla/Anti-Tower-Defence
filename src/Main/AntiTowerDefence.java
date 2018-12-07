package Main;

import formatters.XMLReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Linnea on 2018-11-27.
 */
public class AntiTowerDefence {

    public static void main( String[] args ) throws IOException {
        Controller controller = new Controller();
        XMLReader reader = controller.createXMLReader();
        reader.setSource(new FileInputStream(new File(
                "XMLBuilder/Maps/mapBig.xml")));

        GameManager gm = controller.createGameManager(reader.getMaps());
        gm.startGame();

        while (true) {
            if (!gm.getWhatToDraw().isEmpty())
                gm.getWhatToDraw().get(0).getPosition().print();
        }
        }

}
