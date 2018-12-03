import java.util.ArrayList;

public class Tile {
    ArrayList<Position> area;

    public Tile(ArrayList<Position> positions) {
        area = positions;
    }

    public ArrayList<Position> getArea() {
        return area;
    }
}
