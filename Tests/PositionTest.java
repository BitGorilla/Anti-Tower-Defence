import gameLogic.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author id15msd
 */

public class PositionTest {
    private Position position;

    public void tearDown() {position=null;}

    /*@Test (expected = NullPointerException.class)
    public void constructorHandlesNullAsParameter(){
        int i = null;
        position = new Position(null, null);
    }*/

    @Test
    public void positionTakesCorrectXCoordinate(){
        position = new Position(1,2);
        assertEquals(1, position.getX());
    }

    @Test
    public void positionTakesCorrectYCoordinate(){
        position = new Position(1,2);
        assertEquals(2, position.getY());
    }

/*    @Test
    public void positionSetsXCoordinateCorrect(){
        position = new Position(1,1);
        position.setX(2);
        assertEquals(2, position.getX());
    }

    @Test
    public void positionSetsYCoordinateCorrect(){
        position = new Position(1,1);
        position.setY(2);
        assertEquals(2, position.getY());
    }

    @Test (expected = IllegalArgumentException.class)
    public void cantSetNegativeXCoordinate(){
        position = new Position(1,1);
        position.setX(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void cantSetNegativeYCoordinate(){
        position = new Position(1,1);
        position.setY(-1);
    }*/

    @Test
    public void addVectorAddsPositiveVectorCorrectly(){
        position = new Position(1,1);
        Position vector = new Position(3,3);
        position.addVector(vector);
        assertEquals(position, new Position(4,4));
    }

    @Test
    public void addVectorAddsNegativeVectorCorrectly(){
        position = new Position(5,5);
        Position vector = new Position(-3,-3);
        position.addVector(vector);
        assertEquals(position, new Position(2,2));
    }


    /*@Test (expected = NullPointerException.class)
    public void setXHandlesNullAsParameter(){
        position = new Position(1,1);
        position.setX(null);
    }

    @Test (expected = NullPointerException.class)
    public void setYHandlesNullAsParameter(){
        position = new Position(1,1);
        position.setY(null);
    }*/
}
