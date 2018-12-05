package Main;

public class SpeedDemon extends Creature {

    public static final int MAXHEALTH = 20;
    public static final int SPEED = 10;
    public static final int COST = 10;

    public SpeedDemon(Position pos, Direction dir) {
        super(pos, dir);
        super.setCurrentHealth(MAXHEALTH);
        resetStats();
    }

    public void resetStats() {
        super.setCurrentSpeed(SPEED);
    }
}
