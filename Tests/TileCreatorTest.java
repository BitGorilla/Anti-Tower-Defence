import gameLogic.*;
import org.junit.Assert;
import tiles.BlankTile;
import tiles.Tile;
import tiles.TileCreator;
import gameLogic.Position;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by jontor on 2018-12-06.
 */
public class TileCreatorTest {
    Position centerPosition = new Position(5,5);
    Position upperLeftPosition = new Position(0,0);
    Position lowerRightPosition = new Position(10,10);


    @Test
    public void correctTileCanBeCreated() throws Exception {
        TileCreator.createTile("BlankTile",null, Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
        TileCreator.createTile("SlowTile",null, Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
        TileCreator.createTile("GoalTile", null, Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
        TileCreator.createTile("StartTile",null, Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
    }

    @Test
    public void incorrectTileTypeCreatesBlankTile() throws Exception {
        Tile tile = TileCreator.createTile("BadTile",null, Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
        Assert.assertEquals(tile.getClass(), BlankTile.class);
    }

    @Test
    public void tileWithBadConstructorCreatesBlankTile() throws Exception {
       Tile tile = TileCreator.createTile("IncorrectTile1",null, Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
        Assert.assertEquals(tile.getClass(), BlankTile.class);

    }







}
