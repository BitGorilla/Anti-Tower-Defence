import Main.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CreatureTest {
    private Creature creature;

    @Before
    public void setUp() {
        creature = new Creature(null, null);
    }

    @Test
    public void setCurrentHealthToZeroEqualsZero(){
        creature.setCurrentHealth(0);
        Assert.assertEquals(creature.getCurrentHealth(),0);
    }

    @Test
    public void setCurrentHealthToNegativeSetsItToZero(){
        creature.setCurrentHealth(-5);
        Assert.assertEquals(creature.getCurrentHealth(),0);
    }

    @Test
    public void creatureWithHealthAtZeroIsDead(){
        creature.setCurrentHealth(0);
        Assert.assertTrue(creature.isDead());
    }

    @Test
    public void creatureWithHealthAtpositiveIsDead(){
        creature.setCurrentHealth(5);
        Assert.assertFalse(creature.isDead());
    }

    @Test
    public void creatureMoveSouthDirectionMovesOneStepSouth(){
        Position pos = new Position(0,0);
        creature = new Creature(pos, Direction.SOUTH);
        creature.move();
        Position southMovePos = new Position(0,1);
        Assert.assertEquals(creature.getPosition(),southMovePos);
    }

    @Test
    public void creatureMoveWestDirectionMovesOneStepWest(){
        Position pos = new Position(5,5);
        creature = new Creature(pos, Direction.WEST);
        creature.move();
        Position westMovePos = new Position(4,5);
        Assert.assertEquals(creature.getPosition(),westMovePos);
    }

    @Test
    public void creatureMoveEastDirectionMovesOneStepEast(){
        Position pos = new Position(5,5);
        creature = new Creature(pos, Direction.EAST);
        creature.move();
        Position eastMovePos = new Position(6,5);
        Assert.assertEquals(creature.getPosition(),eastMovePos);
    }

    @Test
    public void creatureMoveNorthDirectionMovesOneStepNorth(){
        Position pos = new Position(5,5);
        creature = new Creature(pos, Direction.NORTH);
        creature.move();
        Position NorthMovePos = new Position(5,4);
        Assert.assertEquals(creature.getPosition(),NorthMovePos);
    }

    @Test
    public void creatureMovingAllDirectionsShouldbeBackAtSamePosition(){
        Position pos = new Position(5,5);
        creature = new Creature(pos, Direction.NORTH);
        for (Direction dir  :Direction.values() ) {
            if(dir != Direction.BLANK) {
                creature.setDirection(dir);
                creature.move();
            }
        }
        Assert.assertEquals(pos,creature.getPosition());
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
        creature = new Creature(position, Direction.BLANK);
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
