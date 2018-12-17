package gameLogic;

import java.util.Objects;

/**
 * Class representing a position with a x and y value.
 *
 * @author
 * @since
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructor of class.
     * @param x x position.
     * @param y y position.
     */
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     *
     * @return x position as an Integer.
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return y position as an Integer.
     */
    public int getY() {
        return y;
    }

    /**
     * TODO write purpose of method
     * @param pos
     */
    public void addVector(Position pos){
        this.x += pos.getX();
        this.y += pos.getY();
    }

    /**
     * Compares object to this instance of the class.
     *
     * @param o Object to compare.
     * @return Object equals this class instance or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    /**
     * Generates a hashcode of the x and y value.
     * @return Hash value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Prints x and y values to console.
     */
    public void print() {
        System.out.println("(" + x +"," + y + ")");
    }
}
