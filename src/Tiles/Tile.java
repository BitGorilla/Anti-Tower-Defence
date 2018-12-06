package Tiles;

import Main.Direction;
import Main.Position;

public class Tile {
    private Direction direction;
    private Position centerPos;
    private Position upperLeft;
    private Position lowerRight;


    public Tile(Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        this.direction = direction;
        this.centerPos = centerPos;
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
    }

    public boolean positionOnTile(Position pos) {
        return (pos.getX() >= upperLeft.getX() && pos.getX() <= lowerRight.getX())
                && (pos.getY() >= upperLeft.getY() && pos.getY() <= lowerRight.getY());
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getCenterPos() {
        return centerPos;
    }
}
