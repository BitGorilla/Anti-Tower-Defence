import java.util.Objects;

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

    public void addVector(Position pos){
        this.x += pos.getX();
        this.y += pos.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
