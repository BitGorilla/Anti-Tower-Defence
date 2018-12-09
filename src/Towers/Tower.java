package Towers;

import Main.GameObject;
import Main.Position;

import java.awt.*;

public class Tower extends GameObject implements TowerInterface {

    private int cooldown = 0;
    private int damage;
    private int rateOfFire;
    private int range;
    private Color laserColor;

    public Tower(Position pos, Image image, int range, int damage,
                 int rateOfFire, Color laserColor) {
        super(pos, image);
        this.range = range;
        this.damage = damage;
        this.rateOfFire = rateOfFire;
        this.laserColor = laserColor;
    }

    @Override
    public boolean positionInRange(Position pos) {
        return distanceTo(pos) <= range;
    }

    private int distanceTo(Position pos) {
        int dX = getPosition().getX()-pos.getX();
        int dY = getPosition().getY()-pos.getY();
        return (int) Math.sqrt(dX*dX+dY*dY);
    }

    @Override
    public int shoot() {
        cooldown = rateOfFire;
        return damage;
    }

    @Override
    public boolean readyToShoot() {
        return cooldown == 0;
    }

    @Override
    public void reduceCooldown() {
        if (cooldown > 0)
            cooldown--;
    }

    public int getRange() {
        return range;
    }

    public int getCooldown() {
        return cooldown;
    }

    public Color getLaserColor() {
        return laserColor;
    }
}
