package Main;
public class CenterPositionCalculator {
    private double tileDimension;
    private double tileWidth;
    private Position centerPosition;
    private double i;
    private int xMinValue, xMaxValue, yMinValue, yMaxValue;

    /**
     *
     * @param windowDimension The size of the game field window.
     * @param tileDimension The number of tiles vertically and horizontally.
     * @param tileNumber the list order of the tile. Start with 1.
     */
    public CenterPositionCalculator(double windowDimension,
                                    double tileDimension, int tileNumber){
        i = (double)tileNumber;
        this.tileDimension = tileDimension;

        tileWidth = Math.floor(windowDimension/ tileDimension);

        centerPosition = calcCenter();
        calcLimitValues();
    }

    private Position calcCenter(){
        int x,y;
        x = y = (int)Math.ceil(tileWidth/2)-1;

        if(i%tileDimension == 0){
            x = x + (int)(tileDimension*tileWidth);
        }
        else {
            x = x + (int)(tileWidth*((i%tileDimension)-1));
        }

        y = y + (int)(tileWidth*(Math.ceil(i/tileDimension)-1));

        return new Position(x,y);
    }

    private void calcLimitValues(){

        xMinValue=yMinValue = 0;
        xMaxValue = yMaxValue = (int)tileWidth-1;

        if(i%tileDimension == 0){
            xMinValue = xMinValue + (int)(tileWidth*tileDimension-1);
            xMaxValue = xMaxValue + (int)(tileWidth*tileDimension-1);
        }
        else {
            xMinValue = xMinValue + (int)(tileWidth*((i%tileDimension)-1));
            xMaxValue = xMaxValue + (int)(tileWidth*((i%tileDimension)-1));
        }
        yMinValue = yMinValue + (int)(tileWidth*(Math.ceil(i/tileDimension)-1));
        yMaxValue = yMaxValue + (int)(tileWidth*(Math.ceil(i/tileDimension)-1));
    }

    public Position getCenterPosition() {
        return centerPosition;
    }

    public int getxMinValue() {
        return xMinValue;
    }

    public int getxMaxValue() {
        return xMaxValue;
    }

    public int getyMinValue() {
        return yMinValue;
    }

    public int getyMaxValue() {
        return yMaxValue;
    }
}
