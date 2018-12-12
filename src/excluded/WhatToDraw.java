package Main;

import Creatures.Creature;
import Tiles.Tile;
import Towers.Tower;

import java.util.ArrayList;

/**
 * Contains the objects that are drawable to the game field.
 */
public class WhatToDraw {

    ArrayList<Position> coordinates = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();

    /**
     * Constructor of the class.
     */
    public WhatToDraw() {

    }

    /**
     * TODO
     *
     * @param creatures The spawned creatures.
     * @param towers the spawned towers.
     * @param tiles the game field tiles.
     */
    public void setWhatToDraw(ArrayList<Creature> creatures, ArrayList<Tower> towers, ArrayList<Tile> tiles) {
        for (Creature creature: creatures) {
            //coordinates.add(crea);
        }
    }
}
