package towers;

import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Towertype class. Has a low rate of fire, high range and high damage.
 * @author oi16ohn, oi16jsn
 * @since 2018-12-18
 */
public class SharpShooter extends Tower {
    public static final int RANGE = 300;
    public static final int DAMAGE = 150;
    public static final int RATEOFFIRE = 60;
    public static final Color COLOR = Color.magenta;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "towerPink.png");

    /**
     * Constructor of the towertype.
     * @param pos, the position of the tower.
     */
    public SharpShooter(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE, COLOR);
    }
}
