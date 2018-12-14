package gameLogic;

/**
 * Enumeration class representing all four of the walkable directionts in the
 * game.
 *
 * @author oi16jsn, oi16ohn
 *
 */
public enum Direction {
    NORTH, SOUTH, WEST, EAST, BLANK;

    private Position vector;

    static {
        NORTH.vector = new Position(0,-1);
        SOUTH.vector = new Position(0,1);
        WEST.vector = new Position(-1, 0);
        EAST.vector = new Position(1, 0);
        BLANK.vector = new Position(0,0);
    }

    /**
     *
     * @return vector, position object with a
     * 0:1:0:1 vector in the enum direction.
     */
    public Position asVector() {
        return vector;
    }

}