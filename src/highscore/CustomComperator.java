package highscore;

import java.util.Comparator;

public class CustomComperator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o2.getScore()-o1.getScore() ;
    }
}
