package Tiles;

import Main.Direction;
import Main.GameObject;
import Main.Position;
import javafx.geometry.Pos;

import java.awt.*;

public class Tile extends GameObject {
    private Direction direction;
    private Position upperLeft;
    private Position lowerRight;
    private Image image;


    public Tile(Image image, Direction direction, Position centerPos,
                Position upperLeft,
                Position lowerRight) {
        super(centerPos, image);
        this.direction = direction;
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
        return getPosition();
    }

    public Position getUpperLeft() {
        return upperLeft;
    }

    public Position getLowerRight() {
        return lowerRight;
    }
}
