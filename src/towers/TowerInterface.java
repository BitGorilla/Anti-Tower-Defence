package towers;

import gameLogic.Position;

/**
 * @author
 * @since 2018-12-18
 */
public interface TowerInterface {
    boolean positionInRange(Position pos);
    int shoot();
    boolean readyToShoot();
    void reduceCooldown();

}
