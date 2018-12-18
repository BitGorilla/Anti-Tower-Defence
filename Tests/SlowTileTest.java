import creatures.Creature;
import creatures.SpeedDemon;
import gameLogic.Position;
import tiles.SlowTile;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SlowTileTest {

    SlowTile slowTile;
    @Before
    public void setUp() {
        slowTile = new SlowTile(null,null,null,null, null);
    }

    @After
    public void tearDown() {
        slowTile = null;
    }

    @Test
    public void landOnSlowsSpeedOfCreature() {
        Creature umbridge = new Creature(new Position(0,0),null, null,4,1,1);
        slowTile.landOn(umbridge);
        Assert.assertEquals(4/2, umbridge.getCurrentSpeed());
    }
}
