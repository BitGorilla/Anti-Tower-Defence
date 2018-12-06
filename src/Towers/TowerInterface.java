package Towers;

import Main.Position;

/**
 * Created by jontor on 2018-11-29.
 */
public interface TowerInterface {
    boolean positionInRange(Position pos);
    int shoot();
    boolean readyToShoot();
    void reduceCooldown();

}
