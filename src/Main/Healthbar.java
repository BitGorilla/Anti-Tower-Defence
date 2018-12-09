package Main;

import java.awt.*;

public class Healthbar {
    private int maxHealth;
    private int currentHealth;
    private Position position;
    private int maxHealthWidth = 20;
    private int maxHealthHeight = 5;
    private int currentHealthHeight = 5;
    private int offset = 20;
    private Color maxHealthColor = Color.red;
    private Color currentHealthColor = Color.green;

    public Healthbar(int maxHealth, int currentHealth, Position position) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.position = new Position(position.getX()-getMaxHealthWidth()/2,
                position.getY()-offset);
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setPosition(Position position) {
        this.position = new Position(position.getX()-getMaxHealthWidth()/2,
                position.getY()-offset);
    }

    public Position getPosition() {
        return position;
    }

    public int getMaxHealthWidth() {
        return maxHealthWidth;
    }

    public int getMaxHealthHeight() {
        return maxHealthHeight;
    }

    public int getCurrentHealthWidth() {
        System.out.println(maxHealth);
        return (int) ((double) currentHealth / (double) maxHealth * (double) maxHealthWidth);
    }

    public int getCurrentHealthHeight() {
        return currentHealthHeight;
    }

    public Color getMaxHealthColor() {
        return maxHealthColor;
    }

    public Color getCurrentHealthColor() {
        return currentHealthColor;
    }
}
