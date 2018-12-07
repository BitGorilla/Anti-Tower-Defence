package Creatures;

import Main.Direction;
import Main.Position;

import java.awt.*;

public class SpeedDemon extends Creature {

    public static final int MAXHEALTH = 20;
    public static final int SPEED = 10;
    public static final int COST = 10;
    public static final Image image = null;

    public SpeedDemon(Position pos, Direction dir) {
        super(pos, image, dir);
        setCurrentHealth(MAXHEALTH);
        resetStats();
    }

    public void resetStats() {
        setCurrentSpeed(SPEED);
    }
}
