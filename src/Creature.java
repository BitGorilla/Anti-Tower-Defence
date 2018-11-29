public interface Creature {

    public Position getPosition();

    public int getCost();

    public int getCurrentHealth();

    public int getSpeed();

    public void reduceHealth();

    public boolean isDead();

    public void moveTo(Position position);
}
