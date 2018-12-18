import tiles.TileCreator;
import gameLogic.Direction;
import gameLogic.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tiles.*;


import java.util.ArrayList;
import java.util.Map;

public class MapTest{
    private Map map;
    private int credits = 100;
    private String name = "name";
    private ArrayList<Tile> tiles;

    @Before
    public void setUp(){
        tiles = new ArrayList<>();
        Tile tile;
        try {
            tile = TileCreator.createTile("StartTile", Direction.SOUTH,
                    new Position(1, 1)
                    , new Position(0, 0), new Position(2, 2));
            tiles.add(tile);

        }catch (Exception e){
            e.printStackTrace();
        }

        map = new Map(name, credits, tiles);
    }

    @Test
    public void readCreditTest(){
        Assert.assertEquals(100, map.getStartCredit());
    }

    @Test
    public void readNameTest(){
        Assert.assertEquals("name", map.getName());
    }

    @Test
    public void tileListNotEmptyTest(){
        Assert.assertTrue(!tiles.isEmpty());
    }

}
