/**
 * Created by jontor on 2018-11-29.
 */
public interface Tower {
    boolean positionInRange(Position pos);
    int shoot();
    boolean readyToShoot();
    void reduceCooldown();

}
