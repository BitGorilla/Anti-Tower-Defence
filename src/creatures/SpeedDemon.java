package creatures;

import gameLogic.Direction;
import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

public class SpeedDemon extends Creature {

    public static final int MAXHEALTH = 130;
    public static final int SPEED = 15;
    public static final int COST = 50;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "speedDemon.png");

    public SpeedDemon(Position pos, Direction dir) {
        super(pos, image, dir, SPEED, MAXHEALTH, COST);
        setCurrentHealth(MAXHEALTH);
    }
}
