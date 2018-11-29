import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DefaultCreatureTest {
    DefaultCreature defaultCreature;

    @Before
    public void setUp() {
        defaultCreature = new DefaultCreature();
    }

    @Test
    public void speedGetterGetsSetterValue() {
        int integer = 2341;
        defaultCreature.setCurrentSpeed(integer);
        Assert.assertEquals(integer,defaultCreature.getCurrentSpeed());
    }

    @Test
    public void currentHealthGetterGetsSetterValue() {
        int integer = 3271263;
        defaultCreature.setCurrentHealth(integer);
        Assert.assertEquals(integer,defaultCreature.getCurrentHealth());
    }

    @Test
    public void positionGetterGetsSetterValue() {
        int x = 4124;
        int y = 2136127;
        Position position = new Position(x,y);
        defaultCreature.moveTo(position);
        Assert.assertEquals(position,defaultCreature.getPosition());
    }


    @Test
    public void currentHealthCantBeLessThanZero() {
        int integer = -1;
        defaultCreature.setCurrentHealth(integer);
        Assert.assertFalse(defaultCreature.getCurrentHealth() < 0);
    }

    @After
    public void tearDown() {
        defaultCreature = null;
    }
}
