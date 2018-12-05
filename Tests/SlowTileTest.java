import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Main.*;

public class SlowTileTest {

    SlowTile slowTile;
    @Before
    public void setUp() {
        slowTile = new SlowTile(null,null,null,null);
    }

    @After
    public void tearDown() {
        slowTile = null;
    }

    @Test
    public void landOnSlowsSpeedOfCreature() {
        SpeedDemon umbridge = new SpeedDemon(null);
        slowTile.landOn(umbridge);
        Assert.assertEquals(SpeedDemon.SPEED/2, umbridge.getCurrentSpeed());
    }
}
