package excluded;

import javafx.geometry.Pos;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;

public class GameInstanceTest {

    GameInstance gameInstance;

    @Before
    public void setUp() {
        gameInstance = new GameInstance();
    }

    public void addCreatureShouldAddACreature() {
        gameInstance.addCreature(1);
        Assert.assertEquals(1,gameInstance.getCreatureList.length());
    }

    public void addCreatureShouldAddManyCreatures() {
        gameInstance.addCreature("SpeedDemon");
        gameInstance.addCreature("SpeedDemon");
        gameInstance.addCreature("Grunt");
        gameInstance.addCreature("SpeedDemon");
        gameInstance.addCreature("Grunt");
        Assert.assertEquals(5,gameInstance.getCreatureList.length());
    }

    //Betting 100 crowns on that .class is incorrect in expected statement.
    public void addCreatureAddsExpectedCreatureSpeedDemon() {
        gameInstance.addCreature("SpeedDemon");
        Assert.assertEquals(SpeedDemon.class,gameInstance.getCreatureList().get(0).getClass());
    }

    public void addCreatureAddsExpectedCreatureGrunt() {
        gameInstance.addCreature("Grunt");
        Assert.assertEquals(Grunt.class,gameInstance.getCreatureList().get(0).getClass());
    }

    public void damageCreatureShouldDamageExpectedTowerDamage() {
        SpeedDemon niclas = new SpeedDemon(null);
        SharpShooter sniperBoi = new SharpShooter(null);
        int hp = niclas.getCurrentHealth();
        int damage = sniperBoi.shoot();
        gameInstance.damageCreatures(niclas, sniperBoi);
        Assert.assertEquals(hp-damage,niclas.getCurrentHealth());
    }

    public void moveCreaturesShouldMoveOneCreatureWithIndexEqualToItsSpeed() {
        ArrayList<Position> path = new ArrayList<>();
        for (int i = 0; i < SpeedDemon.SPEED * 3; i++) {
            path.add(new Position(i,0));
        }
        gameInstance = new GameInstance(path);
        gameInstance.addCreature("SpeedDemon");
        Position initalPosition = path.get(0);
        gameInstance.moveCreatures();
        Assert.assertEquals(path.get(SpeedDemon.SPEED),gameInstance.getCreatureList().get(0).getPosition);
    }

    public void moveCreaturesShouldMoveAllCreaturesWithIndexEqualToItsSpeed() {
        ArrayList<Position> path = new ArrayList<>();
        for (int i = 0; i < SpeedDemon.SPEED * 3; i++) {
            path.add(new Position(i,i));
        }
        gameInstance = new GameInstance(path);
        gameInstance.addCreature("SpeedDemon");
        gameInstance.addCreature("Grunt");

        gameInstance.moveCreatures();
        Assert.assertEquals(path.get(SpeedDemon.SPEED),gameInstance.getCreatureList().get(0).getPosition);
        Assert.assertEquals(path.get(Grunt.SPEED),gameInstance.getCreatureList().get(1).getPosition);

    }

    public void creatureOnTileTriggersWhenCreatureIsOnTilePosition() {
        ArrayList<Position> positionList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            positionList.add(new Position(i,i));
        }
        SlowTile slowTile = new SlowTile(positionList);
        gameInstance.creatureOnTile();
    }

    @After
    public void tearDown() {
        gameInstance = null;
    }
}
