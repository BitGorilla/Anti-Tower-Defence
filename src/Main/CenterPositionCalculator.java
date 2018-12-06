package Main;

/**
 * Class with the purpose to calculate the center position of a
 * game field tile. Also calculates the maximum and minimum  x and y values
 * for the tile.
 *
 */
public class CenterPositionCalculator {
    private double tileDimension;
    private double tileWidth;
    private Position centerPosition;
    private double i;
    private int xMinValue, xMaxValue, yMinValue, yMaxValue;

    /**
     *  Constructor of the class. Calculates the pixel(coordinate) width of the
     *  tile.
     *
     * @param windowDimension The size of the game field window.
     * @param tileDimension The number of tiles vertically and horizontally.
     * @param tileNumber the list order of the tile. Starts with 1.
     */
    public CenterPositionCalculator(double windowDimension,
                                    double tileDimension, int tileNumber){
        i = (double)tileNumber;
        this.tileDimension = tileDimension;

        tileWidth = Math.floor(windowDimension/ tileDimension);

        centerPosition = calcCenter();
        calcLimitValues();
    }

    /**
     * Calculates the center position of the tile in ralation to its position
     * in the game field grid.
     *
     * @return the center position as a Position class.
     */
    private Position calcCenter(){
        int x,y;
        x = y = (int)Math.ceil(tileWidth/2)-1;

       if(i%tileDimension == 0){
            x = x + (int)(tileDimension*tileWidth)/2;
        }
        else {
            x = (x + (int)(tileWidth*((i%tileDimension)-1)));
        }
        y = y + (int)(tileWidth*(Math.ceil(i/tileDimension)-1));

        return new Position(x,y);
    }

    /**
     * Calculates the maximum and minimum values för x and y for the tile in
     * relation to its position in the game field grid.
     *
     * Minimum Values: (0,0)
     */
    private void calcLimitValues(){

        xMinValue=yMinValue = 0;
        xMaxValue = yMaxValue = (int)tileWidth-1;

        if(i%tileDimension == 0){
            xMinValue = xMinValue + (int)(tileWidth*tileDimension-1)/2;
            xMaxValue = xMaxValue + (int)(tileWidth*tileDimension-1);
        }
        else {
            xMinValue = xMinValue + (int)(tileWidth*((i%tileDimension)-1));
            xMaxValue = xMaxValue + (int)(tileWidth*((i%tileDimension)-1));
        }
        yMinValue = yMinValue + (int)(tileWidth*(Math.ceil(i/tileDimension)-1));
        yMaxValue = yMaxValue + (int)(tileWidth*(Math.ceil(i/tileDimension)-1));
    }

    /**
     * @return The center position of the tile.
     */
    public Position getCenterPosition() {
        return centerPosition;
    }

    /**
     * @return The minimum x value of the tile.
     */
    public int getxMinValue() {
        return xMinValue;
    }

    /**
     * @return The maximum x value of the tile.
     */
    public int getxMaxValue() {
        return xMaxValue;
    }

    /**
     * @return The minimum y value of the tile.
     */
    public int getyMinValue() {
        return yMinValue;
    }

    /**
     * @return The maximum y value of the tile.
     */
    public int getyMaxValue() {
        return yMaxValue;
    }
}
