package towers;

import gameLogic.Position;
import formatters.ImageLoader;

import java.awt.*;

public class LazerToTheFazer extends Tower{
    public static final int RANGE = 150;
    public static final int DAMAGE = 10;
    public static final int RATEOFFIRE = 4;
    public static final Color COLOR = Color.green;
    public static final Image image = ImageLoader.getImageLoader().getImage(
            "towerGreen.png");

    public LazerToTheFazer(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE, COLOR);
    }
}
