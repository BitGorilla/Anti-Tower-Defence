package Creatures;

import Main.Direction;
import Main.Position;

import java.awt.*;

public class Grunt extends Creature {

    public static final int MAXHEALTH = 1000;
    public static final int SPEED = 4;
    public static final int COST = 100;
    public static final Image image = null;

    public Grunt(Position pos, Direction dir) {
        super(pos, image, dir);
        super.setCurrentHealth(MAXHEALTH);
        resetStats();

    }

    public void resetStats() {
        super.setCurrentSpeed(SPEED);
    }
}
