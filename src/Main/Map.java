package Main;

import Tiles.Tile;

import java.util.ArrayList;

public class Map {
    private int startCredit;
    private String name;
    private ArrayList<Tile> tiles;

    public Map(String name, int startCredit, ArrayList<Tile> tiles) {
        this.startCredit = startCredit;
        this.name = name;
        this.tiles = tiles;
    }

    public int getStartCredit() {
        return startCredit;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
