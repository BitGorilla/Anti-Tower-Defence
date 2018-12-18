package towers;

import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;
/**
 * Towertype class. Has a medium rate of fire, medium range and medium damage.
 * @author oi16ohn
 * @since 2018-12-18
 */

public class CleavesYouInPieces extends Tower {
    public static final int RANGE = 200;
    public static final int DAMAGE = 50;
    public static final int RATEOFFIRE = 15;
    public static final Color COLOR = Color.yellow;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "towerYellow.png");

    /**
     * Constructor of the towertype.
     * @param pos, the position of the tower.
     */
    public CleavesYouInPieces(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE, COLOR);
    }
}
