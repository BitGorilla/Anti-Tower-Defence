package Main;

public class SharpShooter extends Tower {
    public static final int RANGE = 30;
    public static final int DAMAGE = 10;
    public static final int RATEOFFIRE = 2;

    public SharpShooter(Position pos) {
        super(pos, RANGE, DAMAGE, RATEOFFIRE);
    }
}
