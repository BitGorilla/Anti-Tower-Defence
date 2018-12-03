import java.util.ArrayList;

public class DefaultTile{
    ArrayList<Position> area;

    public DefaultTile(ArrayList<Position> positions) {
        area = positions;
    }

    public ArrayList<Position> getArea() {
        return area;
    }
}
