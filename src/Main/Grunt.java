package Main;

public class Grunt extends Creature {

    public static final int MAXHEALTH = 1000;
    public static final int SPEED = 4;
    public static final int COST = 100;

    public Grunt(Position pos) {
        super(pos);
        super.setCurrentHealth(MAXHEALTH);
        resetStats();

    }

    public void resetStats() {
        super.setCurrentSpeed(SPEED);
    }
}
