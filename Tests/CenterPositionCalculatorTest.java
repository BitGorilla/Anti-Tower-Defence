import org.junit.Assert;
import org.junit.Test;
import Main.*;

public class CenterPositionCalculatorTest {
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
        int correctX = 9;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    @Test
    public void calculatesOddYCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctY = 9;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    @Test
    public void calculatesEvenXCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctX = 12;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    @Test
    public void calculatesEvenYCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctY = 12;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    @Test
    public void calculatesOddXCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctX = 49;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    @Test
    public void calculatesOddYCenterCoordinateOnFirst13Test(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctY = 49;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    @Test
    public void calculatesEvenXCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile13);
        int correctX = 12;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    @Test
    public void calculatesEvenYCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile13);
        int correctY = 87;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }


    @Test
    public void calculatesEvenXMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMinValue=0;
        Assert.assertEquals(correctMinValue, calculator.getxMinValue());
    }

    @Test
    public void calculatesEvenXMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMaxValue=24;
        Assert.assertEquals(correctMaxValue, calculator.getxMaxValue());
    }

    @Test
    public void calculatesEvenYMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMinValue=0;
        Assert.assertEquals(correctMinValue, calculator.getyMinValue());
    }

    @Test
    public void calculatesEvenYMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMaxValue=24;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }

    @Test
    public void calculatesOddXMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMinValue=0;
        Assert.assertEquals(correctMinValue, calculator.getxMinValue());
    }

    @Test
    public void calculatesOddXMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMaxValue=19;
        Assert.assertEquals(correctMaxValue, calculator.getxMaxValue());
    }

    @Test
    public void calculatesOddYMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMinValue=0;
        Assert.assertEquals(correctMinValue, calculator.getyMinValue());
    }

    @Test
    public void calculatesOddYMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMaxValue=19;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }


    @Test
    public void calculatesOddYMaxValueOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctMaxValue=59;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }
}