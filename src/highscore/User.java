package highscore;

public class User {

    private String name;



    private String mapName;
    private int score;

    public User(String name, String mapName, int score){
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
