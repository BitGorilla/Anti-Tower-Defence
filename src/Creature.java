/**
 * Created by jontor on 2018-11-29.
 */
public class Creature implements CreatureInterface {
    private int index;
    private int currentHealth;
    private int currentSpeed;
    private boolean goaled;

    public Creature(int index) {
        this.index = index;
    }
    @Override
    public int getPosition() {
        return index;
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
    public void moveTo(int index) {
        this.index = index;
    }

    @Override
    public void setGoaled() {
        goaled = true;
    }

    @Override
    public boolean inGoal() {
        return goaled;
    }

    public void printStats() {
        System.out.println(this.getClass());
        System.out.println("Position: " + getPosition());
        System.out.println("HP: " + getCurrentHealth());
        System.out.println("Speed: " + getCurrentSpeed());
    }
}
