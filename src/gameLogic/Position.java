package gameLogic;

import java.util.Objects;

/**
 * Class representing a position with a x and y value.
 *
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
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
     * Adds a vector to the position, adding the x-values respectively y-values
     * together resulting in a new Position.
     * @param pos, Position with the x and y values to add to the position.
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

}
