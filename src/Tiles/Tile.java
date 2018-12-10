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


    /**
     * Constructor of the class.
     *
     * @param image Image representing the object.
     * @param direction The direction to send creatures who reaches the center.
     * @param centerPos The center position of the object relative to the game
     *                  field.
     * @param upperLeft The upper left position of the object relative to the
     *                  game field.
     * @param lowerRight The lower right position of the object relative to the
     *                   game field.
     */
    public Tile(Image image, Direction direction, Position centerPos,
                Position upperLeft,
                Position lowerRight) {
        super(centerPos, image);
        this.direction = direction;
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
    }

    /**
     * Checks if a position is inside the tile object.
     * @param pos Position to check.
     * @return True if position is inside tile. False if not.
     */
    public boolean positionOnTile(Position pos) {
        return (pos.getX() >= upperLeft.getX() && pos.getX() <= lowerRight.getX())
                && (pos.getY() >= upperLeft.getY() && pos.getY() <= lowerRight.getY());
    }

    /**
     *
     * @return The direction of the object.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     *
     * @return The center position of the object.
     */
    public Position getCenterPos() {
        return getPosition();
    }

    //TODO remove?
    public Position getUpperLeft() {
        return upperLeft;
    }

    //TODO remove?
    public Position getLowerRight() {
        return lowerRight;
    }

    /**
     * Sets the direction of the tile.
     * @param direction The direction to set.
     */
    public void setDirection(Direction direction){
        this.direction = direction;
    }
}
