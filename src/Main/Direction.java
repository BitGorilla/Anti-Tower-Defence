package Main;

public enum Direction {
    NORTH, SOUTH, WEST, EAST;

    private Position vector;

    static {
        NORTH.vector = new Position(0,-1);
        SOUTH.vector = new Position(0,1);
        WEST.vector = new Position(-1, 0);
        EAST.vector = new Position(1, 0);
    }

    public Position asVector() {
        return vector;
    }

}