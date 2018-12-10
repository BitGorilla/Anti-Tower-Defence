package Towers;

import Main.Position;
import formatters.ImageLoader;

import java.awt.*;


public class SharpShooter extends Tower {
    public static final int RANGE = 10000;
    public static final int DAMAGE = 10;
    public static final int RATEOFFIRE = 20;
    public static final Color COLOR = Color.magenta;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "Tower.png");

    public SharpShooter(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE, COLOR);
    }
}
