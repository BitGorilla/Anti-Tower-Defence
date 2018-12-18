package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Class representing a tile which can flip its direction where it sends
 * creatures that walks on it.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class FlipperTile extends Tile implements TileInterface {

    /**
     * Constructor of the class.
     *
     * @param image The image of the object that is to be drawn.
     * @param direction The direction to send creatures who reaches the center.
     * @param centerPos The center position of the object relative to the game
     *                  field.
     * @param upperLeft The upper left position of the object relative to the
     *                  game field.
     * @param lowerRight The lower right position of the object relative to the
     *                   game field.
     */
    public FlipperTile(Image image, Direction direction, Position centerPos,
                       Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    /**
     * Blank landOn Method, should not affect creatures that walk on it.
     * @param creature, creature that is on the tile.
     */
    @Override
    public void landOn(Creature creature) {

    }

    /**
     * Flips the direction of the tile and sets a new image representing this
     * change. Can only flip 180 degrees,
     * so a tile with direction north for example can only be flipped to south.
     */
    public void flipDirection(){
        System.out.println(getDirection());
        Direction dir = getDirection();
        switch (dir){
            case EAST: setDirection(Direction.WEST);
                setImage(ImageLoader.getImageLoader().getImage("FlipperTile" +
                        "-West.png"));
            break;
            case WEST: setDirection(Direction.EAST);
                setImage(ImageLoader.getImageLoader().getImage("FlipperTile" +
                        "-East.png"));
            break;
            case NORTH: setDirection(Direction.SOUTH);
                setImage(ImageLoader.getImageLoader().getImage("FlipperTile" +
                        "-South.png"));
            break;
            case SOUTH: setDirection(Direction.NORTH);
                setImage(ImageLoader.getImageLoader().getImage("FlipperTile" +
                        "-North.png"));
            break;
        }
    }
}
