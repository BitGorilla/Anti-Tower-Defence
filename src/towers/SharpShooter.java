package towers;

import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;


public class SharpShooter extends Tower {
    public static final int RANGE = 300;
    public static final int DAMAGE = 100;
    public static final int RATEOFFIRE = 50;
    public static final Color COLOR = Color.magenta;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "towerPink.png");

    public SharpShooter(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE, COLOR);
    }
}
