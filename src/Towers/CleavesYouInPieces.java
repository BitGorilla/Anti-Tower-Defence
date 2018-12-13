package Towers;

import Main.Position;
import formatters.ImageLoader;

import java.awt.*;
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
     * @param image      Image representing the tower.
     * @param range      The range of which the tower can shoot creatures.
     * @param damage     How much damage a shot does to a creature.
     * @param rateOfFire How fast the tower shoots.
     * @param laserColor The color of the towers laser.
     */
    public CleavesYouInPieces(Position pos) {
        super(pos, image, RANGE, DAMAGE, RATEOFFIRE, COLOR);
    }
}
