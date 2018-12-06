import javax.swing.*;
import java.awt.*;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Tower implements TowerInterface {

    private int cooldown = 0;
    private int damage;
    private int rateOfFire;
    private int range;
    private Position pos;
    private ImageIcon img;
    //public Graphics2d g2d;

    public Tower(Position pos, int range, int damage, int rateOfFire) {
        this.pos = pos;
        this.range = range;
        this.damage = damage;
        this.rateOfFire = rateOfFire;
        this.img = new ImageIcon(getClass().getResource("./images/Tower.png"));
        //Graphics2D g2d =(Graphics2D) g;
        //this.g2d = Graphics
    }

    //Draw image graphic

    @Override
    public boolean positionInRange(Position pos) {
        return distanceTo(pos) <= range;
    }

    private int distanceTo(Position pos) {
        int dX = this.pos.getX()-pos.getX();
        int dY = this.pos.getY()-pos.getY();
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


}
