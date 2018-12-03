import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreatureTest {
    Creature creature;

    @Before
    public void setUp() {
        creature = new Creature(null);
    }

    @Test
    public void speedGetterGetsSetterValue() {
        int integer = 2341;
        creature.setCurrentSpeed(integer);
        Assert.assertEquals(integer, creature.getCurrentSpeed());
    }

    @Test
    public void currentHealthGetterGetsSetterValue() {
        int integer = 3271263;
        creature.setCurrentHealth(integer);
        Assert.assertEquals(integer, creature.getCurrentHealth());
    }

    @Test
    public void positionGetterGetsSetterValue() {
        int x = 4124;
        int y = 2136127;
        Position position = new Position(x,y);
        creature.moveTo(position);
        Assert.assertEquals(position, creature.getPosition());
    }


    @Test
    public void currentHealthCantBeLessThanZero() {
        int integer = -1;
        creature.setCurrentHealth(integer);
        Assert.assertFalse(creature.getCurrentHealth() < 0);
    }

    @After
    public void tearDown() {
        creature = null;
    }
}
