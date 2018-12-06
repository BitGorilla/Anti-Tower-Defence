import Main.Direction;
import Main.Position;
import Tiles.TileCreator;
import org.junit.Test;
import org.junit.Assert.*;
import Creatures.*;

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
        TileCreator.createTile("BlankTile", Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
        TileCreator.createTile("SlowTile", Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
        TileCreator.createTile("GoalTile", Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
        TileCreator.createTile("StartTile", Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
    }

    @Test (expected = ClassNotFoundException.class)
    public void incorrectTileCanNotBeCreated() throws Exception {
        TileCreator.createTile("BadTile", Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
    }

    @Test (expected = ClassNotFoundException.class)
    public void tileWithBadConstructorThrowsException() throws Exception {
        TileCreator.createTile("IncorrectTile1", Direction.NORTH, centerPosition, upperLeftPosition, lowerRightPosition);
    }







}
