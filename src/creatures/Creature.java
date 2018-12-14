package creatures;

import formatters.ImageLoader;
import gameLogic.Direction;
import gameLogic.GameObject;
import gameLogic.Healthbar;
import gameLogic.Position;

import java.awt.*;

/**
 * Creatures are the objects which the player sends out to reach the goal.
 * @author io16jsn, io16ohl
 * @since 2018-11-29
 */
public class Creature extends GameObject implements CreatureInterface {
    private Direction direction;
    private int currentHealth;
    private int currentSpeed;
    private boolean goaled;
    private int defaultSpeed;
    private Healthbar healthbar;
    private int cost;

    /**
     * Constructor of class.
     *
     * @param position Center position of the creature object.
     * @param image Image representing the creature.
     * @param direction The direction the creature object is traveling.
     * @param defaultSpeed The default speed which the creature is traveling.
     * @param maxHealth The maximum health of the creature.
     */
    public Creature(Position position, Image image, Direction direction,
                    int defaultSpeed, int maxHealth, int cost) {
        super(position, image);
        this.defaultSpeed = defaultSpeed;
        this.direction = direction;
        setCurrentSpeed(defaultSpeed);
        healthbar = new Healthbar(maxHealth, maxHealth, position);
        setCost(cost);
    }

    /**
     * Sets the direction of the creature.
     * @param direction The direction to set.
     */
    @Override
    public void setDirection(Direction direction){
        if(!direction.equals(Direction.BLANK)) {
            this.direction = direction;
        }else {
            switch (this.direction) {
                case EAST:
                    setDirection(Direction.WEST);
                    break;
                case WEST:
                    setDirection(Direction.EAST);
                    break;
                case NORTH:
                    setDirection(Direction.SOUTH);
                    break;
                case SOUTH:
                    setDirection(Direction.NORTH);
                    break;
            }
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     *
     * @return The current health of the creature.
     */
    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Sets a temporary speed for the creature.
     * @param newSpeed The temporary speed.
     */
    @Override
    public void setCurrentSpeed(int newSpeed) {
        currentSpeed = newSpeed;
    }

    /**
     *
     * @return The current speed of the creature.
     */
    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets the current health of the creature.
     * @param newHealth The health to set.
     */
    @Override
    public void setCurrentHealth(int newHealth) {
        currentHealth = newHealth;
        if(currentHealth < 0)
            currentHealth = 0;
        healthbar.setCurrentHealth(currentHealth);
    }

    /**
     * Checks if the creature is dead by checking its health.
     * @return True if dead, false if not.
     */
    @Override
    public boolean isDead() {
        return currentHealth == 0;
    }

    /**
     * Changes the position of the creature.
     */
    @Override
    public void move() {
        getPosition().addVector(direction.asVector());
        healthbar.setPosition(getPosition());
    }

    /**
     * Sets the creature values back to default values.
     */
    public void setDefaultStats() {
        currentSpeed = defaultSpeed;
    }

    /**
     * Sets if the creature has reached the goal.
     */
    @Override
    public void setGoaled() {
        goaled = true;
    }

    /**
     * Checks if the creature is in goal.
     * @return
     */
    @Override
    public boolean inGoal() {
        return goaled;
    }

    /**
     *
     * @return The healthbar of the creature.
     */
    public Healthbar getHealthbar() {
        return healthbar;
    }


}
