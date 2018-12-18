package towers;

import gameLogic.GameObject;
import gameLogic.Position;

import java.awt.*;

/**
 * towers are objects placed along the game field path to shoot creatures.
 * @author
 * @since 2018-12-18
 */
public class Tower extends GameObject implements TowerInterface {

    private int cooldown = 0;
    private int damage;
    private int rateOfFire;
    private int range;
    private Color laserColor;

    /**
     * Constructor of class.
     *
     * @param pos Center position of the object.
     * @param image Image representing the tower.
     * @param range The range of which the tower can shoot creatures.
     * @param damage How much damage a shot does to a creature.
     * @param rateOfFire How fast the tower shoots.
     * @param laserColor The color of the towers laser.
     */
    public Tower(Position pos, Image image, int range, int damage,
                 int rateOfFire, Color laserColor) {
        super(pos, image);
        this.range = range;
        this.damage = damage;
        this.rateOfFire = rateOfFire;
        this.laserColor = laserColor;
    }

    /**
     * Checks if a position is in range.
     *
     * @param pos Position to check.
     * @return True if in range, false if not.
     */
    @Override
    public boolean positionInRange(Position pos) {
        return distanceTo(pos) <= range;
    }

    /**
     * Calculates the distance from the tower object to a position.
     *
     * @param pos The position to calculate to.
     * @return The distance as an Integer.
     */
    private int distanceTo(Position pos) {
        int dX = getPosition().getX()-pos.getX();
        int dY = getPosition().getY()-pos.getY();
        return (int) Math.sqrt(dX*dX+dY*dY);
    }

    /**
     * O o
     * /¯/___________________________ ________
     * | IMMA FIRIN' MAH﻿ LAZOR! BLAAAAGHH!
     * \_\¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯ ¯ ¯¯¯¯¯¯¯
     *
     * @return The damage the tower does.
     */
    @Override
    public int shoot() {
        cooldown = rateOfFire;
        return damage;
    }

    /**
     * Checks if the tower can shoot.
     *
     * @return True if it can shoot, false if not.
     */
    @Override
    public boolean readyToShoot() {
        return cooldown == 0;
    }

    /**
     * Reduces the cooldown of the tower laser beam.
     */
    @Override
    public void reduceCooldown() {
        if (cooldown > 0)
            cooldown--;
    }

    //TODO remove?
    public int getRange() {
        return range;
    }

    //TODO remove?
    public int getCooldown() {
        return cooldown;
    }

    /**
     * @return the color of the laser.
     */
    public Color getLaserColor() {
        return laserColor;
    }
}
