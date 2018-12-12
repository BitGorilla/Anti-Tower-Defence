package Creatures;

import Main.Direction;
import Main.Position;
import formatters.ImageLoader;

import java.awt.*;

public class SpeedDemon extends Creature {

    public static final int MAXHEALTH = 100;
    public static final int SPEED = 10;
    public static final int COST = 10;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "speedDemon.png");

    public SpeedDemon(Position pos, Direction dir) {
        super(pos, image, dir, SPEED, MAXHEALTH);
        setCurrentHealth(MAXHEALTH);
    }
}
