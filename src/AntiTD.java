import gui.Controller;
import formatters.XMLReader;

import java.io.*;

/**
 * @author oi16ohn, id15msd
 * @since 2018-12-18
 */
public class AntiTD {

    /**
     * Reads file input from terminal window and creates a XMLReader for
     * reading the file. Creates a Controller object based on the .xml file.
     *
     * @param args Console input.
     * @throws IOException If reading of file fails.
     */
    public static void main(String[] args) throws IOException {
        int gameWidth = 700;
        XMLReader reader;
        reader = new XMLReader(gameWidth);


        if (args.length == 0) {

            InputStream is = AntiTD.class.getResourceAsStream(
                    "/xmlBuilder/Maps/levels.xml");
            if (null != is) {
                reader.setSource(is);
            } else {
                System.err.println("Couldn't find that file!");
                System.exit(1);

            }

        } else if (args.length == 1 && args[0].endsWith(".xml")) {

            InputStream is = AntiTD.class.getResourceAsStream(
                    "/xmlBuilder/Maps/"+args[0]);
            if (null != is) {
                reader.setSource(is);
            } else {
                System.err.println("Couldn't find that file!");
                System.exit(1);

            }
        } else {
            System.err.println("The program only takes one argument, an .xml " +
                    "file containing the maps.\nIf no arguments are given " +
                    "the " +
                    "default maps are run.");
            System.exit(1);
        }

        new Controller(reader.getMaps(), gameWidth, reader.getWidth());
    }

}
