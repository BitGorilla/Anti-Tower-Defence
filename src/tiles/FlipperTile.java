package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Created by jontor on 2018-12-10.
 */
public class FlipperTile extends Tile implements TileInterface {
    public FlipperTile(Image image, Direction direction, Position centerPos, Position upperLeft, Position lowerRight) {
        super(image, direction, centerPos, upperLeft, lowerRight);
    }

    @Override
    public void landOn(Creature creature) {

    }

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
