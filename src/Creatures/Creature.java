package Creatures;

import Main.Direction;
import Main.GameObject;
import Main.Position;

import java.awt.*;

/**
 * Created by jontor on 2018-11-29.
 */
public class Creature extends GameObject implements CreatureInterface {
    private Direction direction;
    private int currentHealth;
    private int currentSpeed;
    private boolean goaled;
    private int defaultSpeed;

    public Creature(Position position, Image image, Direction direction,
                    int defaultSpeed) {
        super(position, image);
        this.defaultSpeed = defaultSpeed;
        this.direction = direction;
        setCurrentSpeed(defaultSpeed);
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
        getPosition().addVector(direction.asVector());
    }

    public void setDefaultStats() {
        currentSpeed = defaultSpeed;
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
        System.out.println("Position: (" + getPosition().getX() + "," + getPosition().getY());
        System.out.println("HP: " + getCurrentHealth());
        System.out.println("Speed: " + getCurrentSpeed());
        System.out.println("Direction: " + direction);
    }
}
