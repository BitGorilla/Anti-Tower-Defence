package highscore;

public class Score {

    private String name;
    private String mapName;
    private int score;

    public Score(String name, String mapName, int score){
        this.name = name;
        this.mapName = mapName;
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public String getName() {
        return name;
    }

    public String getMapName() {
        return mapName;
    }
}
