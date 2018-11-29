import javafx.geometry.Pos;

public class DefaultTower implements Tower{

    private int cooldown = 0;
    private int damage;
    private int rateOfFire;
    private int range;
    private Position pos;

    public DefaultTower(Position pos, int range, int damage, int rateOfFire) {
        this.pos = pos;
        this.range = range;
        this.damage = damage;
        this.rateOfFire = rateOfFire;
    }

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
