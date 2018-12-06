import Tiles.Tile;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Main.*;

public class TileTest {
    Tile tile;
    Position centerPosition = new Position(5,5);
    Position upperLeftPosition = new Position(0,0);
    Position lowerRightPosition = new Position(10,10);

    @Before
    public void setUp() {
        tile = new Tile(null,null,null,null);
    }

    @Test
    public void tileCanBeInitiated(){
        tile = new Tile(Direction.NORTH, centerPosition, upperLeftPosition,lowerRightPosition);
    }

    @Test
    public void positionOnTileTrueIfPositionOnTile(){
        boolean check = true;
        for (int i = 0; i >= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                Position pos = new Position(i,j);
                    check = tile.positionOnTile(pos);
                    if(!check){
                        break;
                    }
            }
            if(!check){
                break;
            }
        }
        Assert.assertTrue(check);
    }



    @After
    public void tearDown() {
        tile = null;
    }
}
