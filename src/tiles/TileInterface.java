package tiles;

import creatures.Creature;

/**
 * Interface to be implemented by all tiles.
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public interface TileInterface {

    void landOn(Creature creature);
}