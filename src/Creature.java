public interface Creature {

    Position getPosition();

    int getCost();

    int getCurrentHealth();

    int getSpeed();

    void reduceHealth();

    boolean isDead();

    void moveTo(Position position);
}
