package Tests;
import org.junit.Test;
import static org.junit.Assert.*;

public class TowerTest {
    private Tower tower;

    public void setUp(){ tower=new Tower(); }

    public void tearDown(){ tower=null; }

    @Test
    public boolean towerCalculatesCorrectPositionsInRange(){

        return false;
    }

    @Test (expected = NullPointerException.class)
    public void towerHandlesEmptyPath(){
        tower.calculatePositionsInRange(null);
    }

}
