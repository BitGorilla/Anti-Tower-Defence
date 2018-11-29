import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DefaultTowerTest {
    private DefaultTower defaultTower;
    private Position pos = new Position(1,1);
    private int range = 20;
    private int damage = 40;
    private int rateOfFire = 30;

    @Before
    public void setUp() {
        defaultTower = new DefaultTower(pos, range, damage, rateOfFire);
    }

    @After
    public void tearDown(){ defaultTower = null; }

    @Test
    public void positionInRangeToBeTrue_PositionOnYEdge() {
        Position testPosition = new Position(1,1+defaultTower.getRange());
        Assert.assertTrue(defaultTower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeTrue_PositionOnXEdge() {
        Position testPosition = new Position(1+defaultTower.getRange(),1);
        Assert.assertTrue(defaultTower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeTrue_PositionInRange() {
        Position testPosition = new Position(2,2);
        Assert.assertTrue(defaultTower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeFalse_PositionOutsideYEdge() {
        Position testPosition = new Position(1,2+defaultTower.getRange());
        Assert.assertFalse(defaultTower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeFalse_PositionOutsideXEdge() {
        Position testPosition = new Position(2+defaultTower.getRange(),1);
        Assert.assertFalse(defaultTower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeFalse_PositionOutsideDiagonalEdge() {
        Position testPosition = new Position((int) (2+range/Math.sqrt(2)), (int) (2+range/Math.sqrt(2)));
        Assert.assertFalse(defaultTower.positionInRange(testPosition));
    }

    @Test
    public void positionInRangeToBeTrue_PositionOnDiagonalEdge() {
        System.out.println(range/Math.sqrt(2));
        System.out.println((int) (range/Math.sqrt(2)));
        Position testPosition = new Position((int) (1+range/Math.sqrt(2)), (int) (1+range/Math.sqrt(2)));
        Assert.assertTrue(defaultTower.positionInRange(testPosition));
    }

    @Test
    public void damageGetterToGetValueSetInConstructor() {
        Assert.assertEquals(damage,defaultTower.shoot());
    }

    @Test
    public void shootToSetCooldownToRateOfFire() {
        defaultTower.shoot();
        Assert.assertEquals(rateOfFire,defaultTower.getCooldown());
    }

    @Test
    public void reduceCooldownToReduceCooldownByOne() {
        defaultTower.shoot();
        defaultTower.reduceCooldown();
        Assert.assertEquals(rateOfFire-1,defaultTower.getCooldown());
    }

    @Test
    public void reduceCooldownSameTimesAsRateOfFireToReduceCooldownToZero() {
        defaultTower.shoot();
        for (int i = 0; i < rateOfFire; i++)
            defaultTower.reduceCooldown();
        Assert.assertEquals(0,defaultTower.getCooldown());
    }

    @Test
    public void reduceCooldownMoreTimesThanRateOfFireToReduceCooldownToZero() {
        defaultTower.shoot();
        for (int i = 0; i < rateOfFire*10; i++)
            defaultTower.reduceCooldown();
        Assert.assertEquals(0,defaultTower.getCooldown());
    }

}
