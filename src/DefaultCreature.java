/**
 * Created by jontor on 2018-11-29.
 */
public class DefaultCreature implements Creature{
    private Position pos;
    private int currentHealth;
    private int currentSpeed;



    @Override
    public Position getPosition() {
        return pos;
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void setCurrentSpeed(int newSpeed) {
        currentSpeed = newSpeed;
    }


    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public void setCurrentHealth(int newHealth) {
        currentHealth = newHealth;
        if(currentHealth < 0)
            currentHealth = 0;
    }

    @Override
    public boolean isDead() {
        return currentHealth == 0;
    }

    @Override
    public void moveTo(Position position) {
        pos = position;
    }
}
