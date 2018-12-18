import formatters.XMLReader;
import gameLogic.Map;
import formatters.XMLReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XMLReaderTest {
    XMLReader readerSmallMap;
    XMLReader readerBigMap;
    @Before
    public void setUp() {
        int boardWidth = 100;
        readerSmallMap = new XMLReader(boardWidth);
        readerBigMap = new XMLReader(boardWidth);
        try {
            readerSmallMap.setSource(new FileInputStream(
                    new File("Tests/testMaps/testMap1.xml")));
            readerBigMap.setSource(new FileInputStream(
                    new File("Tests/testMaps/testMap2.xml")));
        } catch (IOException e) {
            System.err.println("No file by that name!");
        }
    }

    @After
    public void tearDown() {
        readerSmallMap = null;
        readerBigMap = null;
    }

    @Test
    public void mapNameShouldBeTheSameAsXMLSmallMap() {
        Map map = readerSmallMap.buildMap();
        Assert.assertEquals("Small Map", map.getName());
    }

    @Test
    public void mapTilesShouldBeTheSameAsInXMLSmallMap() {
        Map map = readerSmallMap.buildMap();
        Assert.assertEquals(4, map.getTiles().size());
    }

    @Test
    public void mapCreditShouldBeTheSameAsInXMLSmallMap() {
        Map map = readerSmallMap.buildMap();
        Assert.assertEquals(1000, map.getStartCredit());
    }

    @Test
    public void firstTileAreaPositionsShouldBeRight() {
        Map map = readerSmallMap.buildMap();
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
        Map map = readerBigMap.buildMap();
        Assert.assertEquals("Big Test Map", map.getName());
    }

    @Test
    public void mapTilesShouldBeTheSameAsInXMLBigMap() {
        Map map = readerBigMap.buildMap();
        Assert.assertEquals(2500, map.getTiles().size());
    }

    @Test
    public void mapCreditShouldBeTheSameAsInXMLBigMap() {
        Map map = readerBigMap.buildMap();
        Assert.assertEquals(1000, map.getStartCredit());
    }
}
