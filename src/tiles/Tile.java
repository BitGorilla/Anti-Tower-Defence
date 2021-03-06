package tiles;

import gameLogic.Direction;
import gameLogic.GameObject;
import gameLogic.Position;

import java.awt.*;

/**
 * Superclass for all tiles. Contains all methods and attributes
 * which are used in all kinds of tiles such as what direction it has,
 * if a given position is on the tile and if a given position is its
 * centerposition.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
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
        return (pos.getX() >= upperLeft.getX()
                && pos.getX() <= lowerRight.getX())
                && (pos.getY() >= upperLeft.getY()
                && pos.getY() <= lowerRight.getY());
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

    /**
     * @return Position of upper left corner.
     */
    public Position getUpperLeft() {
        return upperLeft;
    }

    /**
     * @return Position of lower right corner.
     */
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
