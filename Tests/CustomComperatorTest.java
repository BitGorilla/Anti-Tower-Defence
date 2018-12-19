import highscore.CustomComparator;
import highscore.Score;
import org.junit.Assert;
import org.junit.Test;

public class CustomComperatorTest {
    private CustomComparator comparator = new CustomComparator();

    @Test
    public void returnNegativeIntegerTest(){
        Score score1 = new Score("test", "test", 1);
        Score score2 = new Score("test", "test", 2);

        Assert.assertTrue(comparator.compare(score1,score2) > 0);
    }

    @Test
    public void returnPositiveIntegerTest(){
        Score score1 = new Score("test", "test", 1);
        Score score2 = new Score("test", "test", 2);

        Assert.assertTrue(comparator.compare(score2,score1) < 0);
    }

    @Test
    public void returnZeroTest(){
        Score score1 = new Score("test", "test", 1);
        Score score2 = new Score("test", "test", 1);

        Assert.assertEquals(0, comparator.compare(score2,score1));
    }
}
