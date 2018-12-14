package gameLogic;

import java.awt.*;

/**
 * The healthbar is located above a creature and represents the max and
 * current health of the creature.
 */
public class Healthbar {
    private int maxHealth;
    private int currentHealth;
    private Position position;
    private int maxHealthWidth = 20;
    private int maxHealthHeight = 5;
    private int currentHealthHeight = 5;
    private int offset = 20;
    private Color maxHealthColor = Color.black;
    private Color currentHealthColor = Color.red;

    /**
     * Constructor of class.
     *
     * @param maxHealth Maximum health for bar.
     * @param currentHealth Current for bar.
     * @param position Position of bar.
     */
    public Healthbar(int maxHealth, int currentHealth, Position position) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.position = new Position(position.getX()-getMaxHealthWidth()/2,
                position.getY()-offset);
    }

    /**
     * Sets the current health for the bar.
     * @param currentHealth The health to set.
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Sets the position for the healthbar.
     * @param position The position to set.
     */
    public void setPosition(Position position) {
        this.position = new Position(position.getX()-getMaxHealthWidth()/2,
                position.getY()-offset);
    }

    /**
     *
     * @return The position of the healthbar.
     */
    public Position getPosition() {
        return position;
    }

    /**
     *
     * @return The maximum width of the healthbar.
     */
    public int getMaxHealthWidth() {
        return maxHealthWidth;
    }

    /**
     *
     * @return The maximum height of the healthbar.
     */
    public int getMaxHealthHeight() {
        return maxHealthHeight;
    }

    /**
     *
     * @return The current width of the healthbar according to health.
     */
    public int getCurrentHealthWidth() {
        return (int) ((double) currentHealth / (double) maxHealth * (double) maxHealthWidth);
    }

    /**
     *
     * @return The current height of the healthbar.
     */
    public int getCurrentHealthHeight() {
        return currentHealthHeight;
    }

    /**
     *
     * @return The color when healthbar is at max.
     */
    public Color getMaxHealthColor() {
        return maxHealthColor;
    }

    /**
     *
     * @return The color when healthbar is not at max.
     */
    public Color getCurrentHealthColor() {
        return currentHealthColor;
    }
}
