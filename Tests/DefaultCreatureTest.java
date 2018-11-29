import org.junit.Assert;
import org.junit.Test;

public class DefaultCreatureTest {
    DefaultCreature defaultCreature;

    public void setUp() {
        defaultCreature = new DefaultCreature();
    }

    @Test
    public void speedGetterGetsSetterValue() {
        int integer = 2341;
        defaultCreature.setSpeed(integer);
        Assert.assertEquals(integer,defaultCreature.getSpeed());
    }

    @Test
    public void costGetterGetsSetterValue() {
        int integer = 371954;
        defaultCreature.setCost(integer);
        Assert.assertEquals(integer,defaultCreature.getCost());
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
        defaultCreature.setPosition(position);
        Assert.assertEquals(position,defaultCreature.getPosition());
    }

    @Test
    public void costCantBeLessThanZero() {
        int integer = -1;
        defaultCreature.setCost(integer);
        Assert.assertTrue(defaultCreature.getCost);
    }

    @Test
    public void costCantBeLessThanZero() {
        int integer = -1;
        defaultCreature.setCost(integer);
        Assert.assertTrue(defaultCreature.getCost);
    }

    public void tearDown() {
        defaultCreature = null;
    }
}
