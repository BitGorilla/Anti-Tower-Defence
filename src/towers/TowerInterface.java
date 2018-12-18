package towers;

import gameLogic.Position;

/**
 * Interface to be implemented by all towers.
 *
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public interface TowerInterface {
    boolean positionInRange(Position pos);
    int shoot();
    boolean readyToShoot();
    void reduceCooldown();

}
