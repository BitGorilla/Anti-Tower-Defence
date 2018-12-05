public class CenterPositionCalculator {
    private double tileDimension;
    private double tileWidth;
    private Position centerPosition;
    private int i;
    private int xMinValue, xMaxValue, yMinValue, yMaxValue;

    public CenterPositionCalculator(double windowDimension,
                                    double tileDimension,
                              int tileNumber){
        /*TODO add 1 to tileNumber?*/
        i = tileNumber;
        this.tileDimension = tileDimension;

        tileWidth = Math.floor(windowDimension/ tileDimension);

        centerPosition = calcCenter();
        calcLimitValues();
    }

    private Position calcCenter(){
        int x,y;
        x = y = (int)Math.ceil(tileWidth/2);

        if(i%tileDimension == 0){
            x *= (int)(tileWidth*(tileDimension));
        }
        else {
            x *= (int)(tileWidth*(i%tileDimension));
        }
        y *= (int)(Math.ceil(i/tileDimension));

        return new Position(x,y);
    }

    private void calcLimitValues(){

        xMinValue=yMinValue = 1;
        xMaxValue = yMaxValue = (int)tileWidth;

        if(i%tileDimension == 0){
            xMinValue *= (int)(tileWidth*(tileDimension));
            xMaxValue *= (int)(tileWidth*(tileDimension));
        }
        else {
            xMinValue *= (int)(tileWidth*(i%tileDimension));
            xMaxValue *= (int)(tileWidth*(i%tileDimension));
        }
        yMinValue *= (int)(Math.ceil(i/tileDimension));
        yMaxValue *= (int)(Math.ceil(i/tileDimension));
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
