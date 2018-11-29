public interface Creature {

    public Position getPosition();

    public void setCurrentHealth(int newHealth);
    public int getCurrentHealth();

    public void setCurrentSpeed(int newSpeed);
    public int getCurrentSpeed();

    public boolean isDead();

    public void moveTo(Position position);
}
