package highscore;

import java.util.Comparator;

/**
 * Custom comparator for sorting lists of Score abjects by score(highest to
 * lowest).
 */
public class CustomComparator implements Comparator<Score> {
    /**
     * Compares two arguments for order. Returns a negative integer, zero, or
     * a positive integer as the first argument is less than, equal to,
     * or greater than the second.
     *
     * @param score1 First object to be compared.
     * @param score2 Second object to be compared.
     * @return A negative integer, zero, or a positive integer as the first
     * argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Score score1, Score score2) {
        return score2.getScore()-score1.getScore() ;
    }
}