package tiles;

import creatures.Creature;

/**
 * @author
 * @since 2018-12-18
 */
public class IncorrectTile1 extends Tile implements TileInterface {

        public IncorrectTile1() {
            super(null,null,null,null, null);
        }

        @Override
        public void landOn(Creature creature) {
            creature.setCurrentSpeed(creature.getCurrentSpeed()/2);
        }
}
