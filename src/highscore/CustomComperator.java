package highscore;

import java.util.Comparator;

public class CustomComperator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        String score1 = String.valueOf(o1.getScore());
        String score2 = String.valueOf(o2.getScore());

        return o2.getScore()-o1.getScore() ;
    }
}
