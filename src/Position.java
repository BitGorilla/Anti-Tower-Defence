public class Position {

    private int x;
    private int y;

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if(x < 0){
            throw new IllegalArgumentException("X cord can't be negative");
        }
        this.x = x;

    }

    public void setY(int y) {
        if(y < 0){
            throw new IllegalArgumentException("Y cord can't be negative");
        }
        this.y = y;
    }
}
