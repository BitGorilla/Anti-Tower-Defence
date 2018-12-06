import Towers.Tower;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Main.*;

public class TowerTest {
    private Tower tower;
    private Position pos = new Position(1,1);
    private int range = 20;
    private int damage = 40;
    private int rateOfFire = 30;

    @Before
    public void setUp() {
        tower = new Tower(pos, range, damage, rateOfFire);
    }

    @After
    public void tearDown(){ tower = null; }

    @Test
    public void positionInRangeToBeTrue_PositionOnYEdge() {
        Position testPosition = new Position(1,1+ tower.getRange());
        Assert.assertTrue(tower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeTrue_PositionOnXEdge() {
        Position testPosition = new Position(1+ tower.getRange(),1);
        Assert.assertTrue(tower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeTrue_PositionInRange() {
        Position testPosition = new Position(2,2);
        Assert.assertTrue(tower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeFalse_PositionOutsideYEdge() {
        Position testPosition = new Position(1,2+ tower.getRange());
        Assert.assertFalse(tower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeFalse_PositionOutsideXEdge() {
        Position testPosition = new Position(2+ tower.getRange(),1);
        Assert.assertFalse(tower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeFalse_PositionOutsideDiagonalEdge() {
        Position testPosition = new Position((int) (2+range/Math.sqrt(2)), (int) (2+range/Math.sqrt(2)));
        Assert.assertFalse(tower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeTrue_PositionOnDiagonalEdge() {
        System.out.println(range/Math.sqrt(2));
        System.out.println((int) (range/Math.sqrt(2)));
        Position testPosition = new Position((int) (1+range/Math.sqrt(2)), (int) (1+range/Math.sqrt(2)));
        Assert.assertTrue(tower.positionInRange(testPosition));
    }

    @Test
    public void damageGetterToGetValueSetInConstructor() {
        Assert.assertEquals(damage, tower.shoot());
    }

    @Test
    public void shootToSetCooldownToRateOfFire() {
        tower.shoot();
        Assert.assertEquals(rateOfFire, tower.getCooldown());
    }

    @Test
    public void reduceCooldownToReduceCooldownByOne() {
        tower.shoot();
        tower.reduceCooldown();
        Assert.assertEquals(rateOfFire-1, tower.getCooldown());
    }

    @Test
    public void reduceCooldownSameTimesAsRateOfFireToReduceCooldownToZero() {
        tower.shoot();
        for (int i = 0; i < rateOfFire; i++)
            tower.reduceCooldown();
        Assert.assertEquals(0, tower.getCooldown());
    }

    @Test
    public void reduceCooldownMoreTimesThanRateOfFireToReduceCooldownToZero() {
        tower.shoot();
        for (int i = 0; i < rateOfFire*10; i++)
            tower.reduceCooldown();
        Assert.assertEquals(0, tower.getCooldown());
    }

}
