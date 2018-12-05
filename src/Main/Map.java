package Main;

import java.util.ArrayList;

public class Map {
    private int startCredit;
    private int width;
    private ArrayList<Tile> tiles;

    public Map(int startCredit, int width, ArrayList<Tile> tiles) {
        this.startCredit = startCredit;
        this.width = width;
        this.tiles = tiles;
    }

    public int getStartCredit() {
        return startCredit;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
