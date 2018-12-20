package gameLogic;

import tiles.Tile;

import java.util.ArrayList;

/**
 * Class responsible of storing the content of a level. A game field as tiles,
 * number of credits, and name of the map.
 *
 * @author oi16jsn, oi16ohn
 * @since 2018-12-18
 */
public class Map {
    private int startCredit;
    private String name;
    private ArrayList<Tile> tiles;
    private int winCondition;

    /**
     * Constructor of the class.
     * @param name Name of the map.
     * @param startCredit The number of credits the user starts with.
     * @param tiles The tiles of which the game field consists of.
     */
    public Map(String name, int startCredit, int winCondition,
                                                    ArrayList<Tile> tiles) {
        this.startCredit = startCredit;
        this.name = name;
        this.tiles = tiles;
        this.winCondition = winCondition;
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

    public int getWinCondition() {
        return winCondition;
    }
}
