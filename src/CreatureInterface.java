public interface CreatureInterface {

    int getPosition();

    void setCurrentHealth(int newHealth);
    int getCurrentHealth();

    void setCurrentSpeed(int newSpeed);
    int getCurrentSpeed();

    boolean isDead();

    void moveTo(int index);

    void setGoaled();

    boolean inGoal();
}
