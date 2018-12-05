import javafx.geometry.Pos;

/**
 * Created by jontor on 2018-11-29.
 */
public class Creature implements CreatureInterface {
    private Position position;
    private Direction direction;
    private int currentHealth;
    private int currentSpeed;
    private boolean goaled;

    public Creature(Position position) {
        this.position = position;
    }
    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setDirection(Direction direction){
        this.direction = direction;
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
    public void move() {
        position.addVector(direction.asVector());
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
