package Towers;

import Main.Position;

import java.awt.*;


public class SharpShooter extends Tower {
    public static final int RANGE = 3000;
    public static final int DAMAGE = 1000;
    public static final int RATEOFFIRE = 1;
    public static final Image image = null;

    public SharpShooter(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE);
    }
}
