package highscore;

/**
 * Class for storing a row from the Highscore database.
 *
 * @author id15msd
 */
public class Score {

    private String name;
    private String mapName;
    private int score;

    /**
     * Constructor of class.
     *
     * @param name Name of user.
     * @param mapName Name of map.
     * @param score Score of the user on the map.
     */
    public Score(String name, String mapName, int score){
        this.name = name;
        this.mapName = mapName;
        this.score = score;
    }

    /**
     * @return Score of the user on the map.
     */
    public int getScore(){
        return score;
    }

    /**
     * @return Name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The map name.
     */
    public String getMapName() {
        return mapName;
    }
}
