package tiles;

import creatures.Creature;

/**
 * Class representing an incorrect tile, used only in testing.
 * @author oi16jsn
 * @since 2018-12-18
 */
public class IncorrectTile1 extends Tile implements TileInterface {

        public IncorrectTile1() {
            super(null,null,null,
                    null, null);
        }

        @Override
        public void landOn(Creature creature) {
            creature.setCurrentSpeed(creature.getCurrentSpeed()/2);
        }
}
