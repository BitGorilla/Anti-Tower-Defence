package Main;

import Creatures.Creature;
import Tiles.Tile;
import Towers.Tower;

import java.util.ArrayList;

public class WhatToDraw {

    ArrayList<Position> coordinates = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();

    public WhatToDraw() {

    }

    public void setWhatToDraw(ArrayList<Creature> creatures, ArrayList<Tower> towers, ArrayList<Tile> tiles) {
        for (Creature creature: creatures) {
            //coordinates.add(crea);
        }
    }
}
