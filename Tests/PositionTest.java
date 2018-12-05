import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
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

    private CenterPositionCalculator calculator;
    private double windowDimension = 100;
    private double oddTileDimension = 5;
    private double evenTileDimension = 4;
    private int tile1 = 1;
    private int tile13 = 13;

    @Test
    public void calculatesOddXCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctX = 10;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    @Test
    public void calculatesOddYCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctY = 10;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    @Test
    public void calculatesEvenXCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctX = 13;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    @Test
    public void calculatesEvenYCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctY = 13;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    @Test
    public void calculatesOddXCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctX = 50;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    @Test
    public void calculatesOddYCenterCoordinateOnFirst13Test(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctY = 50;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    @Test
    public void calculatesEvenXCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile13);
        int correctX = 13;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    @Test
    public void calculatesEvenYCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile13);
        int correctY = 88;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }


    @Test
    public void calculatesEvenXMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMinValue=1;
        Assert.assertEquals(correctMinValue, calculator.getxMinValue());
    }

    @Test
    public void calculatesEvenXMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMaxValue=25;
        Assert.assertEquals(correctMaxValue, calculator.getxMaxValue());
    }

    @Test
    public void calculatesEvenYMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMinValue=1;
        Assert.assertEquals(correctMinValue, calculator.getyMinValue());
    }

    @Test
    public void calculatesEvenYMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMaxValue=25;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }

    @Test
    public void calculatesOddXMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMinValue=1;
        Assert.assertEquals(correctMinValue, calculator.getxMinValue());
    }

    @Test
    public void calculatesOddXMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMaxValue=20;
        Assert.assertEquals(correctMaxValue, calculator.getxMaxValue());
    }

    @Test
    public void calculatesOddYMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMinValue=1;
        Assert.assertEquals(correctMinValue, calculator.getyMinValue());
    }

    @Test
    public void calculatesOddYMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMaxValue=20;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }


    @Test
    public void calculatesOddYMaxValueOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctMaxValue=60;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }
}
