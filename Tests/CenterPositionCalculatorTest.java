import org.junit.Assert;
import org.junit.Test;
import gameLogic.*;

/**
 * Tests for the class CenterPositionCalculator.
 *
 * @author id15msd
 */

public class CenterPositionCalculatorTest {
    private CenterPositionCalculator calculator;
    private double windowDimension = 100;
    private double oddTileDimension = 5;
    private double evenTileDimension = 4;
    private double twoTileDimension = 2;
    private int tile1 = 1;
    private int tile13 = 13;
    private int tile16 = 16;

    /*20x20 tile*/
    @Test
    public void calculatesOddXCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctX = 9;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    /*20x20 tile*/
    @Test
    public void calculatesOddYCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctY = 9;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenXCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctX = 12;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenYCenterCoordinateOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctY = 12;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    /*20x20 tile*/
    @Test
    public void calculatesOddXCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctX = 49;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    /*20x20 tile*/
    @Test
    public void calculatesOddYCenterCoordinateOnFirst13Test(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctY = 49;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenXCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile13);
        int correctX = 12;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctX, calcPosition.getX());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenYCenterCoordinateOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile13);
        int correctY = 87;
        Position calcPosition = calculator.getCenterPosition();
        Assert.assertEquals(correctY, calcPosition.getY());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenXMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMinValue=0;
        Assert.assertEquals(correctMinValue, calculator.getxMinValue());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenXMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMaxValue=24;
        Assert.assertEquals(correctMaxValue, calculator.getxMaxValue());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenYMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMinValue=0;
        Assert.assertEquals(correctMinValue, calculator.getyMinValue());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenYMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile1);
        int correctMaxValue=24;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }

    /*20x20 tile*/
    @Test
    public void calculatesOddXMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMinValue=0;
        Assert.assertEquals(correctMinValue, calculator.getxMinValue());
    }

    /*20x20 tile*/
    @Test
    public void calculatesOddXMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMaxValue=19;
        Assert.assertEquals(correctMaxValue, calculator.getxMaxValue());
    }

    /*20x20 tile*/
    @Test
    public void calculatesOddYMinValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMinValue=0;
        Assert.assertEquals(correctMinValue, calculator.getyMinValue());
    }

    /*20x20 tile*/
    @Test
    public void calculatesOddYMaxValueOnFirstTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile1);
        int correctMaxValue=19;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }

    /*20x20 tile*/
    @Test
    public void calculatesOddYMaxValueOn13TileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, tile13);
        int correctMaxValue=59;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }

    /*25x25 tile*/
    @Test
    public void calculatesEvenYMaxValueOnLastTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                evenTileDimension, tile16);
        int correctMaxValue=99;
        Assert.assertEquals(correctMaxValue, calculator.getyMaxValue());
    }

    /*20x20 tile*/
    @Test
    public void calculatesEvenXCenterValueOnLastTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, 25);
        int correctMaxValue=89;
        Assert.assertEquals(correctMaxValue, calculator.getCenterPosition().
                            getX());
    }

    /*20x20 tile*/
    @Test
    public void calculatesEvenXMaxValueOnLastTileTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                oddTileDimension, 25);
        int correctMaxValue=99;
        Assert.assertEquals(correctMaxValue, calculator.getxMaxValue());
    }

    @Test
    public void checkCenterPositionForTwoDimensionTest(){
        calculator = new CenterPositionCalculator(windowDimension,
                twoTileDimension, 2);
        int correctValue = 74;
        Assert.assertEquals(correctValue,calculator.getCenterPosition().getX());
    }

    @Test
    public void testTest() {
        calculator = new CenterPositionCalculator(100,2,4);
    }


}
