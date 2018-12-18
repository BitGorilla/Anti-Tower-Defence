package towers;

import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

/**
 * Towertype class. Has a high rate of fire, low range and low damage.
 * @author oi16ohn, oi16jsn
 * @since 2018-12-18
 */
public class LazerToTheFazer extends Tower{
    public static final int RANGE = 150;
    public static final int DAMAGE = 20;
    public static final int RATEOFFIRE = 4;
    public static final Color COLOR = Color.green;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "towerGreen.png");

    /**
     * Constructor of the towertype.
     * @param pos, the position of the tower.
     */
    public LazerToTheFazer(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE, COLOR);
    }
}
