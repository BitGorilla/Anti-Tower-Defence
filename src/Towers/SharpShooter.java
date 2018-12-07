package Towers;

import Main.Position;

import java.awt.*;


public class SharpShooter extends Tower {
    public static final int RANGE = 30;
    public static final int DAMAGE = 10;
    public static final int RATEOFFIRE = 2;
    public static final Image image = null;

    public SharpShooter(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE);
    }
}
