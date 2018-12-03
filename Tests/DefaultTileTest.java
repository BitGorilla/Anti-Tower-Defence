import javafx.geometry.Pos;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class DefaultTileTest {
    DefaultTile tile;
    @Before
    public void setUp() {
        tile = new DefaultTile(null);
    }

    @After
    public void tearDown() {
        tile = null;
    }

    @Test
    public void getAreaReturnsPositionSetInConstructor() {
        ArrayList<Position> positions = new ArrayList<>();
        int x = 1233;
        int y = 24124;
        Position pos = new Position(x,y);
        positions.add(pos);
        tile = new DefaultTile(positions);
        Assert.assertEquals(pos,tile.getArea().get(0));
    }
}
