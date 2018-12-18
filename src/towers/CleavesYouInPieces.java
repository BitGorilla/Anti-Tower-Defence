package towers;

import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;
/**
 * @author
 * @since 2018-12-18
 */

//He'll break your heart.
public class CleavesYouInPieces extends Tower {
    public static final int RANGE = 200;
    public static final int DAMAGE = 50;
    public static final int RATEOFFIRE = 15;
    public static final Color COLOR = Color.yellow;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "towerYellow.png");
    /**
     * Constructor of class.
     *
     * @param pos        Center position of the object.

     */
    public CleavesYouInPieces(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE, COLOR);
    }
}
