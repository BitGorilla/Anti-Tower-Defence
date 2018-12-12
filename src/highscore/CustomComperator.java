package highscore;

import java.util.Comparator;

public class CustomComperator implements Comparator<Score> {
    @Override
    public int compare(Score score1, Score score2) {
        return score2.getScore()-score1.getScore() ;
    }
}
