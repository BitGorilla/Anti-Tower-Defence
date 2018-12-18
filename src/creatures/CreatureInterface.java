package creatures;

import gameLogic.Direction;

/**
 * Creature interface declare what a creature should contain and what methods
 * it have.
 * Creatures are the objects which the player sends out to reach the goal.
 * @author oi16jsn, oi16ohn
 * @since 2018-11-29
 */

public interface CreatureInterface {

    void setDirection(Direction direction);

    void setCurrentHealth(int newHealth);
    int getCurrentHealth();

    void setCurrentSpeed(int newSpeed);
    int getCurrentSpeed();

    boolean isDead();

    void move();

    void setGoaled();

    boolean inGoal();
}
