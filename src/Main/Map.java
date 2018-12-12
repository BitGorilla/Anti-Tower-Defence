package Main;

import Tiles.Tile;

import java.util.ArrayList;

/**
 * Class responsible of storing the content of a level. A game field as tiles,
 * number of credits, and name of the map.
 */
public class Map {
    private int startCredit;
    private String name;
    private ArrayList<Tile> tiles;
    private int scale;

    /**
     * Constructor of the class.
     * @param name Name of the map.
     * @param startCredit The number of credits the user starts with.
     * @param tiles The tiles of which the game field consists of.
     */
    public Map(String name, int startCredit, ArrayList<Tile> tiles, int scale) {
        this.startCredit = startCredit;
        this.name = name;
        this.tiles = tiles;
        this.scale = scale;
    }

    /**
     *
     * @return start credit number.
     */
    public int getStartCredit() {
        return startCredit;
    }

    /**
     *
     * @return name of map.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return a list of tiles.
     */
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public int getScale() {
        return scale;
    }
}
