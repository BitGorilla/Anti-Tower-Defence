import gui.Controller;
import formatters.XMLReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AntiTD {

    public static void main(String[] args) throws IOException {
        int gameWidth = 700;
        XMLReader reader;
        reader = new XMLReader(gameWidth);

        try {
            if (args.length == 0) {
                reader.setSource(new FileInputStream(new File("src/xmlbuilder" +
                        "/Maps/pretty1.xml")));
            } else if (args.length == 1 && args[0].endsWith(".xml")) {
                reader.setSource(new FileInputStream(new File(args[0])));
            } else {
                System.err.println("The program only takes one argument, an .xml " +
                        "file containing the maps.\nIf no arguments are given " +
                        "the " +
                        "default maps are run.");
                System.exit(1);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not find that file!");
            System.exit(1);
        }
        new Controller(reader.getMaps(), gameWidth,
                reader.getWidth());
    }

}
