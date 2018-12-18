import formatters.XMLReader;
import gameLogic.Map;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XMLReaderTest {
    XMLReader readerLevels;
    XMLReader readerPretty1;
    @Before
    public void setUp() {
        int boardWidth = 100;
        readerLevels = new XMLReader(boardWidth);
        readerPretty1 = new XMLReader(boardWidth);
        try {
            readerLevels.setSource(new FileInputStream(
                    new File("src/xmlBuilder/Maps/levels.xml")));
            readerPretty1.setSource(new FileInputStream(
                    new File("src/xmlBuilder/Maps/pretty1.xml")));
        } catch (IOException e) {
            System.err.println("No file by that name!");
        }
    }

    @After
    public void tearDown() {
        readerLevels = null;
        readerPretty1 = null;
    }

    @Test
    public void mapNameShouldBeTheSameAsFirstLevelsMap() {
        ArrayList<Map> maps = readerLevels.getMaps();
        Map map = maps.get(0);
        Assert.assertEquals("A Wild Ride", map.getName());
    }

    @Test
    public void mapTilesShouldBeTheSameAsInFirstLevelsMap() {
        ArrayList<Map> maps = readerLevels.getMaps();
        Map map = maps.get(0);
        Assert.assertEquals(400, map.getTiles().size());
    }

    @Test
    public void mapCreditShouldBeTheSameAsFirstLevelsMap() {
        ArrayList<Map> maps = readerLevels.getMaps();
        Map map = maps.get(0);
        Assert.assertEquals(1000, map.getStartCredit());
    }

    @Test
    public void firstTileAreaPositionsShouldBeRight() {
        ArrayList<Map> maps = readerLevels.getMaps();
        Map map = maps.get(0);
        System.out.println(map.getTiles().get(0).getCenterPos().getX());
        System.out.println(map.getTiles().get(0).getCenterPos().getY());
        System.out.println(map.getTiles().get(1).getCenterPos().getX());
        System.out.println(map.getTiles().get(1).getCenterPos().getY());
        System.out.println(map.getTiles().get(2).getCenterPos().getX());
        System.out.println(map.getTiles().get(2).getCenterPos().getY());
        System.out.println(map.getTiles().get(3).getCenterPos().getX());
        System.out.println(map.getTiles().get(3).getCenterPos().getY());
    }

    @Test
    public void mapNameShouldBeTheSameAsXMLBigMap() {
        ArrayList<Map> maps = readerPretty1.getMaps();
        Map map = maps.get(0);
        Assert.assertEquals("Big Test Map", map.getName());
    }

    @Test
    public void mapTilesShouldBeTheSameAsInXMLBigMap() {
        ArrayList<Map> maps = readerPretty1.getMaps();
        Map map = maps.get(0);
        Assert.assertEquals(400, map.getTiles().size());
    }

    @Test
    public void FirstMapCreditShouldBeTheSameAsInPretty1() {
        ArrayList<Map> maps = readerPretty1.getMaps();
        Map map = maps.get(0);
        System.out.println(map.getName());
        Assert.assertEquals(1000, map.getStartCredit());
    }
}
