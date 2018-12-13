package Creatures;

import Main.Direction;
import Main.Position;
import formatters.ImageLoader;

import java.awt.*;

public class Grunt extends Creature {

    public static final int MAXHEALTH = 800;
    public static final int SPEED = 3;
    public static final int COST = 100;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "grunt2.png");

    public Grunt(Position pos, Direction dir) {
        super(pos, image, dir, SPEED, MAXHEALTH, COST);
        super.setCurrentHealth(MAXHEALTH);
        resetStats();

    }

    public void resetStats() {
        super.setCurrentSpeed(SPEED);
    }
}
