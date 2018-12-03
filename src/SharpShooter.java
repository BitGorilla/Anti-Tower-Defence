public class SharpShooter extends Tower {
    public static final int RANGE = 1997;
    public static final int DAMAGE = 999;
    public static final int RATEOFFIRE = 10;

    public SharpShooter(Position pos) {
        super(pos, RANGE, DAMAGE, RATEOFFIRE);
    }
}
